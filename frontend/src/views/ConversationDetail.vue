<script>



import ConversationService from "../widgets/Conversation/service"
import WidgetConversationSingle from "../widgets/Conversation/WidgetConversationSingle.vue"
import WidgetConversationSingleEdit from "../widgets/Conversation/WidgetConversationSingleEdit.vue"
import WidgetConversationMulti from "../widgets/Conversation/WidgetConversationMulti.vue"
import WidgetConversationNew from "../widgets/Conversation/WidgetConversationNew.vue"


export default {
    name: "ConversationDetail",
    props: ["conversation"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	ConversationService.get(this.conversation).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            ConversationService.delete(this.conversation).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Conversation item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetConversationSingle": WidgetConversationSingle,
        "WidgetConversationNew": WidgetConversationNew,
        "WidgetConversationSingleEdit": WidgetConversationSingleEdit,
        "WidgetConversationMulti": WidgetConversationMulti
    }
}
</script>>

<template>
    <div class="Conversation-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetConversationSingle :conversation="this.conversation" />

        
    </div>

</template>

<style scoped> 



</style>