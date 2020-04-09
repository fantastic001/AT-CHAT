<script>


import WidgetUserMulti from "../widgets/User/WidgetUserMulti.vue"

import WidgetOrderMulti from "../widgets/Order/WidgetOrderMulti.vue"

import WidgetOrderReviewMulti from "../widgets/OrderReview/WidgetOrderReviewMulti.vue"

import WidgetBuyerFavoriteItemMulti from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemMulti.vue"

import WidgetBuyerSellerLikeMulti from "../widgets/BuyerSellerLike/WidgetBuyerSellerLikeMulti.vue"

import WidgetMessageMulti from "../widgets/Message/WidgetMessageMulti.vue"

import WidgetItemReportMulti from "../widgets/ItemReport/WidgetItemReportMulti.vue"

import WidgetSellerReportMulti from "../widgets/SellerReport/WidgetSellerReportMulti.vue"


import BuyerService from "../widgets/Buyer/service"
import WidgetBuyerSingle from "../widgets/Buyer/WidgetBuyerSingle.vue"
import WidgetBuyerSingleEdit from "../widgets/Buyer/WidgetBuyerSingleEdit.vue"
import WidgetBuyerMulti from "../widgets/Buyer/WidgetBuyerMulti.vue"
import WidgetBuyerNew from "../widgets/Buyer/WidgetBuyerNew.vue"


export default {
    name: "BuyerDetail",
    props: ["buyer"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	BuyerService.get(this.buyer).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            BuyerService.delete(this.buyer).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Buyer item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetUserMulti": WidgetUserMulti,
        
        "WidgetOrderMulti": WidgetOrderMulti,
        
        "WidgetOrderReviewMulti": WidgetOrderReviewMulti,
        
        "WidgetBuyerFavoriteItemMulti": WidgetBuyerFavoriteItemMulti,
        
        "WidgetBuyerSellerLikeMulti": WidgetBuyerSellerLikeMulti,
        
        "WidgetMessageMulti": WidgetMessageMulti,
        
        "WidgetItemReportMulti": WidgetItemReportMulti,
        
        "WidgetSellerReportMulti": WidgetSellerReportMulti,
        
        "WidgetBuyerSingle": WidgetBuyerSingle,
        "WidgetBuyerNew": WidgetBuyerNew,
        "WidgetBuyerSingleEdit": WidgetBuyerSingleEdit,
        "WidgetBuyerMulti": WidgetBuyerMulti
    }
}
</script>>

<template>
    <div class="Buyer-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetBuyerSingle :buyer="this.buyer" />

        
        <WidgetUserMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetOrderMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetOrderReviewMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetBuyerFavoriteItemMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetBuyerSellerLikeMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetMessageMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetItemReportMulti :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetSellerReportMulti :filter="x => x.buyer == this.buyer"/>
        
        
    </div>

</template>

<style scoped> 



</style>