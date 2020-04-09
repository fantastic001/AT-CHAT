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
		data: {},
		tab: 0
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
</script>

<template>
    <div class="Buyer-detail"> 
        <WidgetBuyerSingle :buyer="this.buyer" />
        
	<ul class="nav nav-pills">
	  <li><a @click.prevent="tab = 0;" href="#">Shipped orders </a></li>
	  <li><a @click.prevent="tab = 1;" href="#">Shipping orders </a></li>
	  <li><a @click.prevent="tab = 2;" href="#">Order Reviews </a></li>
	  <li><a @click.prevent="tab = 3;" href="#">Item reports </a></li>
	  <li><a @click.prevent="tab = 4;" href="#">Seller reports </a></li>
	  <li><a href="#">...</a></li>
	</ul>

        
        <WidgetOrderMulti v-if="this.tab == 0" :filter="x => x.buyer == this.buyer && x.status == 'SHIPPED'"/>
        
        <WidgetOrderMulti v-if="this.tab == 1" :filter="x => x.buyer == this.buyer && x.status == 'SHIPPING'"/>
        
	<WidgetOrderReviewMulti v-if="this.tab == 2" :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetItemReportMulti v-if="this.tab == 3" :filter="x => x.buyer == this.buyer"/>
        
        
        <WidgetSellerReportMulti v-if="this.tab == 4" :filter="x => x.buyer == this.buyer"/>
        
        
    </div>

</template>

<style scoped> 

.nav li {
	padding: 10px;
}

</style>
