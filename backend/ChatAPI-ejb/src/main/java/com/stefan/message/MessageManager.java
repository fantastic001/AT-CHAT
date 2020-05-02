package com.stefan.message;

import com.stefan.data.Message;
import com.stefan.data.User;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;

import javax.ejb.EJB;

import com.stefan.cluster.Control;
import com.stefan.cluster.Node;

import com.stefan.data.User;
import com.stefan.user.UserManager;

public class MessageManager {

    @EJB 
    private Control control;

    private static MessageManager instance = null; 
    public static MessageManager getInstance() {
        if (instance == null) instance = new MessageManager();
        return instance;
    }

    private ArrayList<Message> messages;
    private MessageManager() {
        this.messages = new ArrayList<>();
    }

    public ArrayList<Message> getInbox(User user) {
        if (! control.getControl().hasUser(user)) {
            return new ArrayList<>();
        }
        ArrayList<Message> result = new ArrayList<>();
        for (Message msg : this.messages) {
            if (msg.getToUsername().equals(user.getUsername())) {
                result.add(msg);
            }
        }
        return result;
    }

    public ArrayList<Message> getOutbox(User user) {
        if (! control.getControl().hasUser(user)) {
            return new ArrayList<>();
        }
        ArrayList<Message> result = new ArrayList<>();
        for (Message msg : this.messages) {
            if (msg.getFromUsername().equals(user.getUsername())) {
                result.add(msg);
            }
        }
        return result;
    }

    public Collection<Message> getMessages(User user) {
        if (! control.getControl().hasUser(user)) {
            return new ArrayList<>();
        }
        Collection<Message> union = getInbox(user);
        union.addAll(getOutbox(user));
        ArrayList<Message> result = new ArrayList<>(union);
        Collections.sort(result, (c1, c2) -> c1.getCreationTime().compareTo(c2.getCreationTime()));
        return result;
    }

    public Message createMessage(String from, String to, String subject, String text) {
        User toUser = null;
        User fromUser = null;
        for (User user : UserManager.getInstance().getOnlineUsers()) {
            if (user.getUsername().equals(from)) fromUser = user;
            if (user.getUsername().equals(to)) toUser = user;
        }
        if (toUser == null || fromUser == null) return null;
        if (! control.getControl().hasUser(fromUser)) {
            return null;
        }
        Message msg = new Message(from, to, LocalDateTime.now(), subject, text);
        if (! control.getControl().hasUser(toUser)) {
            Node node = control.getControl().findNode(toUser.getHostAlias());
            node.postAsync("/node/messages/", msg);
        }
        this.messages.add(msg);
        return msg;
    }

    public Message createMessage(Message msg) {
        this.messages.add(msg);
        return msg;
    }



    public void broadcastMessage(String from, String subject, String text, Collection<User> users) {
        for (User user : users) {
            if (! user.getUsername().equals(from))
                this.createMessage(from, user.getUsername(), subject, text);
        }
    }
    public void broadcastMessage(Message message, Collection<User> users) {
        this.broadcastMessage(message.getFromUsername(), message.getSubject(), message.getText(), users);
    }
}