<script>
import BuyerFavoriteItemService from "./service";
import WidgetBuyerFavoriteItemSingle from "./WidgetBuyerFavoriteItemSingle.vue";


export default {
    name: "WidgetBuyerFavoriteItemMulti",
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
        BuyerFavoriteItemService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetBuyerFavoriteItemSingle": WidgetBuyerFavoriteItemSingle
    }
}
</script>

<template>
    <div class="WidgetBuyerFavoriteItemSingle"> 
      <WidgetBuyerFavoriteItemSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :buyerfavoriteitem="item.id"
          />
    </div>

</template>

<style scoped> 



</style>