<script>
import OrderReviewService from "./service";
import WidgetOrderReviewSingle from "./WidgetOrderReviewSingle.vue";


export default {
    name: "WidgetOrderReviewMulti",
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
        OrderReviewService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetOrderReviewSingle": WidgetOrderReviewSingle
    }
}
</script>

<template>
    <div class="WidgetOrderReviewSingle"> 
      <WidgetOrderReviewSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :orderreview="item.id"
          />
    </div>

</template>

<style scoped> 



</style>