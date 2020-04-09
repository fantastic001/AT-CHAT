<script>
import MessageService from "./service";
import WidgetMessageSingle from "./WidgetMessageSingle.vue";


export default {
    name: "WidgetMessageMulti",
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
        MessageService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetMessageSingle": WidgetMessageSingle
    }
}
</script>

<template>
    <div class="WidgetMessageSingle"> 
      <WidgetMessageSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :message="item.id"
          />
    </div>

</template>

<style scoped> 



</style>