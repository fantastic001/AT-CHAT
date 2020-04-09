<script>



import BuyerFavoriteItemService from "../widgets/BuyerFavoriteItem/service"
import WidgetBuyerFavoriteItemSingle from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemSingle.vue"
import WidgetBuyerFavoriteItemSingleEdit from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemSingleEdit.vue"
import WidgetBuyerFavoriteItemMulti from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemMulti.vue"
import WidgetBuyerFavoriteItemNew from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemNew.vue"


export default {
    name: "BuyerFavoriteItemDetail",
    props: ["buyerfavoriteitem"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	BuyerFavoriteItemService.get(this.buyerfavoriteitem).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            BuyerFavoriteItemService.delete(this.buyerfavoriteitem).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("BuyerFavoriteItem item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetBuyerFavoriteItemSingle": WidgetBuyerFavoriteItemSingle,
        "WidgetBuyerFavoriteItemNew": WidgetBuyerFavoriteItemNew,
        "WidgetBuyerFavoriteItemSingleEdit": WidgetBuyerFavoriteItemSingleEdit,
        "WidgetBuyerFavoriteItemMulti": WidgetBuyerFavoriteItemMulti
    }
}
</script>>

<template>
    <div class="BuyerFavoriteItem-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetBuyerFavoriteItemSingle :buyerfavoriteitem="this.buyerfavoriteitem" />

        
    </div>

</template>

<style scoped> 



</style>