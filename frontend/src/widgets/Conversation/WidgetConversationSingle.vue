<script>
import ConversationService from "./service";

export default {
    name: "WidgetConversationSingle",
    props: ["conversation"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ConversationService.get(this.conversation).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-conversation-single"> 
    </div>

</template>

<style scoped> 



</style>