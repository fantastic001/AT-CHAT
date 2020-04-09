<script>


import WidgetUserMulti from "../widgets/User/WidgetUserMulti.vue"

import WidgetItemMulti from "../widgets/Item/WidgetItemMulti.vue"

import WidgetBuyerSellerLikeMulti from "../widgets/BuyerSellerLike/WidgetBuyerSellerLikeMulti.vue"

import WidgetToAdminMessageMulti from "../widgets/ToAdminMessage/WidgetToAdminMessageMulti.vue"

import WidgetSellerReportMulti from "../widgets/SellerReport/WidgetSellerReportMulti.vue"


import SellerService from "../widgets/Seller/service"
import WidgetSellerSingle from "../widgets/Seller/WidgetSellerSingle.vue"
import WidgetSellerSingleEdit from "../widgets/Seller/WidgetSellerSingleEdit.vue"
import WidgetSellerMulti from "../widgets/Seller/WidgetSellerMulti.vue"
import WidgetSellerNew from "../widgets/Seller/WidgetSellerNew.vue"


export default {
    name: "SellerDetail",
    props: ["seller"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	SellerService.get(this.seller).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            SellerService.delete(this.seller).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Seller item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetUserMulti": WidgetUserMulti,
        
        "WidgetItemMulti": WidgetItemMulti,
        
        "WidgetBuyerSellerLikeMulti": WidgetBuyerSellerLikeMulti,
        
        "WidgetToAdminMessageMulti": WidgetToAdminMessageMulti,
        
        "WidgetSellerReportMulti": WidgetSellerReportMulti,
        
        "WidgetSellerSingle": WidgetSellerSingle,
        "WidgetSellerNew": WidgetSellerNew,
        "WidgetSellerSingleEdit": WidgetSellerSingleEdit,
        "WidgetSellerMulti": WidgetSellerMulti
    }
}
</script>>

<template>
    <div class="Seller-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetSellerSingle :seller="this.seller" />

        
        <WidgetUserMulti :filter="x => x.seller == this.seller"/>
        
        
        <WidgetItemMulti :filter="x => x.seller == this.seller"/>
        
        
        <WidgetBuyerSellerLikeMulti :filter="x => x.seller == this.seller"/>
        
        
        <WidgetToAdminMessageMulti :filter="x => x.seller == this.seller"/>
        
        
        <WidgetSellerReportMulti :filter="x => x.seller == this.seller"/>
        
        
    </div>

</template>

<style scoped> 



</style>