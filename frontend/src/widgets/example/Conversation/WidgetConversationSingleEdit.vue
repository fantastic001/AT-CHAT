<script>
import ConversationService from "./service";

export default {
    name: "WidgetConversationSingleEdit",
    props: ["conversation"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ConversationService.get(this.conversation).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-conversation-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>