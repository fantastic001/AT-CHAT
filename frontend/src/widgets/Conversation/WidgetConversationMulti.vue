<script>
import ConversationService from "./service";
import WidgetConversationSingle from "./WidgetConversationSingle.vue";


export default {
    name: "WidgetConversationMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        ConversationService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetConversationSingle": WidgetConversationSingle
    }
}
</script>

<template>
    <div class="WidgetConversationSingle"> 
      <WidgetConversationSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :conversation="item.id"
          />
    </div>

</template>

<style scoped> 



</style>