package com.stefan.message;

import com.stefan.data.Message;
import com.stefan.data.User;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.Collection;

public class MessageManager {
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
        ArrayList<Message> result = new ArrayList<>();
        for (Message msg : this.messages) {
            if (msg.getToUsername().equals(user.getUsername())) {
                result.add(msg);
            }
        }
        return result;
    }

    public ArrayList<Message> getOutbox(User user) {
        ArrayList<Message> result = new ArrayList<>();
        for (Message msg : this.messages) {
            if (msg.getFromUsername().equals(user.getUsername())) {
                result.add(msg);
            }
        }
        return result;
    }

    public Message createMessage(String from, String to, String subject, String text) {
        Message msg = new Message(from, to, LocalDateTime.now(), subject, text);
        this.messages.add(msg);
        return msg;
    }

    public void broadcastMessage(String from, String subject, String text, Collection<User> users) {
        for (User user : users) {
            if (! user.getUsername().equals(from))
                this.createMessage(from, user.getUsername(), subject, text);
        }
    }
}