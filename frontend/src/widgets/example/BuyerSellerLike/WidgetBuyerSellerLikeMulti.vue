<script>
import BuyerSellerLikeService from "./service";
import WidgetBuyerSellerLikeSingle from "./WidgetBuyerSellerLikeSingle.vue";


export default {
    name: "WidgetBuyerSellerLikeMulti",
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
        BuyerSellerLikeService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetBuyerSellerLikeSingle": WidgetBuyerSellerLikeSingle
    }
}
</script>

<template>
    <div class="WidgetBuyerSellerLikeSingle"> 
      <WidgetBuyerSellerLikeSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :buyersellerlike="item.id"
          />
    </div>

</template>

<style scoped> 



</style>