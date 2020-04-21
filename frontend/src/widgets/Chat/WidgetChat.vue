<script>
import UserService from "./../User/service";
import ChatService from "./service.js";

import CloseIcon from 'vue-beautiful-chat/src/assets/close-icon.png'
import OpenIcon from 'vue-beautiful-chat/src/assets/logo-no-bg.svg'
import FileIcon from 'vue-beautiful-chat/src/assets/file.svg'
import CloseIconSvg from 'vue-beautiful-chat/src/assets/close.svg'


export default {
    name: "WidgetChat",
    props: ["user"],
    data: function () {
        return {
            icons:{
                open:{
                img: OpenIcon,
                name: 'default',
                },
                close:{
                img: CloseIcon,
                name: 'default',
                },
                file:{
                img: FileIcon,
                name: 'default',
                },
                closeSvg:{
                img: CloseIconSvg,
                name: 'default',
                },
            },
            participants: [
                {
                id: this.user,
                name: this.user,
                imageUrl: 'https://avatars3.githubusercontent.com/u/1915989?s=230&v=4'
                },
            ], // the list of all the participant of the conversation. `name` is the user name, `id` is used to establish the author of a message, `imageUrl` is supposed to be the user avatar.
            titleImageUrl: 'https://a.slack-edge.com/66f9/img/avatars-teams/ava_0001-34.png',
            messageList: [
                { type: 'text', author: `me`, data: { text: `Say yes!` } },
                { type: 'text', author: `user1`, data: { text: `No.` } }
            ], // the list of the messages to show, can be paginated and adjusted dynamically
            newMessagesCount: 0,
            isChatOpen: false, // to determine whether the chat window should be open or closed
            showTypingIndicator: '', // when set to a value matching the participant.id it shows the typing indicator for the specific user
            colors: {
                header: {
                bg: '#4e8cff',
                text: '#ffffff'
                },
                launcher: {
                bg: '#4e8cff'
                },
                messageList: {
                bg: '#ffffff'
                },
                sentMessage: {
                bg: '#4e8cff',
                text: '#ffffff'
                },
                receivedMessage: {
                bg: '#eaeaea',
                text: '#222222'
                },
                userInput: {
                bg: '#f4f7f9',
                text: '#565867'
                }
            }, // specifies the color scheme for the component
            alwaysScrollToBottom: false, // when set to true always scrolls the chat to the bottom when new events are in (new message, user starts typing...)
            messageStyling: true // enables *bold* /emph/ _underline_ and such (more info at github.com/mattezza/msgdown)
        }
    },
    mounted: function () 
    {
        this.loadParticipants();
        this.loadMessages();
        this.timer = setInterval(this.loadMessages, 300);
    },
    beforeDestroy() {
        clearInterval(this.timer);
    },
    methods: {
        loadParticipants() {
            if (this.user == "all") {
                UserService.online().then(response => {
                    this.participants = response.data.map(x => {
                        return {
                            id: x.username,
                            name: x.username,
                            imageUrl: ""
                        }
                    }).filter(x => x.name != localStorage.getItem("user_id"));
                });
            }
            else {
                this.participants = [this.user];
            }
        },
        loadMessages() {
            ChatService.list().then(response => {
                var me = localStorage.getItem("user_id");
                this.messageList = response.data.map(x => {
                    if (x.fromUsername == me) return {
                        author: "me",
                        type: "text",
                        data: {text: x.text}
                    }
                    else return {
                        author: x.fromUsername,
                        type: "text",
                        data: {text: x.text}
                    }
                })
            });
        },
        sendMessage (text) {
            if (text.length > 0) {
                this.newMessagesCount = this.isChatOpen ? this.newMessagesCount : this.newMessagesCount + 1
                this.onMessageWasSent({ author: 'support', type: 'text', data: { text } })
            }
            },
            onMessageWasSent (message) {
                // called when the user sends a message
                this.messageList = [ ...this.messageList, message ];
                if (this.user != "all") {
                    ChatService.send(this.user,"Message",message.data.text);
                }
                else {
                       ChatService.broadcast("Message",message.data.text);
                }
            },
            openChat () {
            // called when the user clicks on the fab button to open the chat
            this.isChatOpen = true
            this.newMessagesCount = 0
            },
            closeChat () {
            // called when the user clicks on the botton to close the chat
            this.isChatOpen = false
            },
            handleScrollToTop () {
            // called when the user scrolls message list to top
            // leverage pagination for loading another page of messages
            },
            handleOnType () {
            console.log('Emit typing event')
            },
            editMessage(message){
            const m = this.messageList.find(m=>m.id === message.id);
            m.isEdited = true;
            m.data.text = message.data.text;
            }
    },
    components:{
        // "beautiful-chat": Chat
    }
}
</script>

<template>
    <div class="widget-chat-single"> 
    <beautiful-chat
      :participants="participants"
      :titleImageUrl="titleImageUrl"
      :onMessageWasSent="onMessageWasSent"
      :messageList="messageList"
      :newMessagesCount="newMessagesCount"
      :isOpen="isChatOpen"
      :close="closeChat"
      :icons="icons"
      :open="openChat"
      :showEmoji="true"
      :showFile="true"
      :showTypingIndicator="showTypingIndicator"
	  :showLauncher="true"
	  :showCloseButton="true"
      :colors="colors"
      :alwaysScrollToBottom="alwaysScrollToBottom"
      :messageStyling="messageStyling"
      @onType="handleOnType"
      @edit="editMessage" />

    </div>

</template>

<style scoped> 



</style>