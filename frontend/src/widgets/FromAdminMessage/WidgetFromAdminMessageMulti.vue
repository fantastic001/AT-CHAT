<script>
import FromAdminMessageService from "./service";
import WidgetFromAdminMessageSingle from "./WidgetFromAdminMessageSingle.vue";


export default {
    name: "WidgetFromAdminMessageMulti",
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
        FromAdminMessageService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetFromAdminMessageSingle": WidgetFromAdminMessageSingle
    }
}
</script>

<template>
    <div class="WidgetFromAdminMessageSingle"> 
      <WidgetFromAdminMessageSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :fromadminmessage="item.id"
          />
    </div>

</template>

<style scoped> 



</style>