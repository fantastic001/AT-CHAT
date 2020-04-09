<script>
import BuyerService from "./service";
import WidgetBuyerSingle from "./WidgetBuyerSingle.vue";


export default {
    name: "WidgetBuyerMulti",
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
        BuyerService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetBuyerSingle": WidgetBuyerSingle
    }
}
</script>

<template>
    <div class="WidgetBuyerSingle"> 
      <WidgetBuyerSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :buyer="item.id"
          />
    </div>

</template>

<style scoped> 



</style>