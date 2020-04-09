<script>
import OrderService from "./service";
import WidgetOrderSingle from "./WidgetOrderSingle.vue";


export default {
    name: "WidgetOrderMulti",
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
        OrderService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetOrderSingle": WidgetOrderSingle
    }
}
</script>

<template>
    <div class="WidgetOrderSingle"> 
      <WidgetOrderSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :order="item.id"
          />
    </div>

</template>

<style scoped> 



</style>