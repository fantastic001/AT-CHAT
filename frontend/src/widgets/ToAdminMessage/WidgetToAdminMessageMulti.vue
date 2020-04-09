<script>
import ToAdminMessageService from "./service";
import WidgetToAdminMessageSingle from "./WidgetToAdminMessageSingle.vue";


export default {
    name: "WidgetToAdminMessageMulti",
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
        ToAdminMessageService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetToAdminMessageSingle": WidgetToAdminMessageSingle
    }
}
</script>

<template>
    <div class="WidgetToAdminMessageSingle"> 
      <WidgetToAdminMessageSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :toadminmessage="item.id"
          />
    </div>

</template>

<style scoped> 



</style>