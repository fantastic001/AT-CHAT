<script>



import BuyerSellerLikeService from "../widgets/BuyerSellerLike/service"
import WidgetBuyerSellerLikeSingle from "../widgets/BuyerSellerLike/WidgetBuyerSellerLikeSingle.vue"
import WidgetBuyerSellerLikeSingleEdit from "../widgets/BuyerSellerLike/WidgetBuyerSellerLikeSingleEdit.vue"
import WidgetBuyerSellerLikeMulti from "../widgets/BuyerSellerLike/WidgetBuyerSellerLikeMulti.vue"
import WidgetBuyerSellerLikeNew from "../widgets/BuyerSellerLike/WidgetBuyerSellerLikeNew.vue"


export default {
    name: "BuyerSellerLikeDetail",
    props: ["buyersellerlike"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	BuyerSellerLikeService.get(this.buyersellerlike).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            BuyerSellerLikeService.delete(this.buyersellerlike).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("BuyerSellerLike item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetBuyerSellerLikeSingle": WidgetBuyerSellerLikeSingle,
        "WidgetBuyerSellerLikeNew": WidgetBuyerSellerLikeNew,
        "WidgetBuyerSellerLikeSingleEdit": WidgetBuyerSellerLikeSingleEdit,
        "WidgetBuyerSellerLikeMulti": WidgetBuyerSellerLikeMulti
    }
}
</script>>

<template>
    <div class="BuyerSellerLike-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetBuyerSellerLikeSingle :buyersellerlike="this.buyersellerlike" />

        
    </div>

</template>

<style scoped> 



</style>