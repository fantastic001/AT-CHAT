<script>


import WidgetSellerMulti from "../widgets/Seller/WidgetSellerMulti.vue"

import WidgetOrderMulti from "../widgets/Order/WidgetOrderMulti.vue"

import WidgetBuyerFavoriteItemMulti from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemMulti.vue"

import WidgetCommentMulti from "../widgets/Comment/WidgetCommentMulti.vue"
import WidgetCommentNew from "../widgets/Comment/WidgetCommentNew.vue"

import WidgetItemReportMulti from "../widgets/ItemReport/WidgetItemReportMulti.vue"
import WidgetItemReportNew from "../widgets/ItemReport/WidgetItemReportNew.vue"


import ItemService from "../widgets/Item/service"
import WidgetItemSingle from "../widgets/Item/WidgetItemSingle.vue"
import WidgetItemSingleEdit from "../widgets/Item/WidgetItemSingleEdit.vue"
import WidgetItemMulti from "../widgets/Item/WidgetItemMulti.vue"
import WidgetItemNew from "../widgets/Item/WidgetItemNew.vue"



export default {
    name: "ItemDetail",
    props: ["id"],
    data: function () {
            return {
		data: {},
		report: false,
		role: localStorage.getItem("role")
	    };
	},
    mounted: function () 
    {
    	ItemService.get(this.id).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            ItemService.delete($route.params.id).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Item item is deleted");
                }
            })
        },
	reloadComments: function () {
		this.$refs.comments.reload();
	}
    },
    components: {
        
        "WidgetSellerMulti": WidgetSellerMulti,
        
        "WidgetOrderMulti": WidgetOrderMulti,
        
        "WidgetBuyerFavoriteItemMulti": WidgetBuyerFavoriteItemMulti,
        
        "WidgetCommentMulti": WidgetCommentMulti,
        "WidgetCommentNew": WidgetCommentNew,
        
        "WidgetItemReportMulti": WidgetItemReportMulti,
        
        "WidgetItemSingle": WidgetItemSingle,
        "WidgetItemNew": WidgetItemNew,
        "WidgetItemSingleEdit": WidgetItemSingleEdit,
        "WidgetItemMulti": WidgetItemMulti,
	WidgetItemReportNew
    }
}
</script>

<template>
    <div class="Item-detail"> 
	<p>Item ID: {{this.id}}</p>
        <WidgetItemSingle :item="$route.params.id" />

        
        <WidgetSellerMulti :filter="x => x.item == this.id"/>
	<button @click="report = !report" v-if="this.role == 'BUYER'" class="btn btn-primary">Report this item</button>
        <WidgetItemReportNew v-if="this.report" />
        
        <WidgetBuyerFavoriteItemMulti :filter="x => x.item == this.id"/>
        
        
        <WidgetCommentMulti ref="comments" :filter="x => x.item == this.id"/>
	<WidgetCommentNew v-if="this.role == 'BUYER' || this.role == 'ADMIN' || this.role == 'SELLER'" @submit="reloadComments" :item="this.id" />
        
        
        <WidgetItemReportMulti :filter="x => x.item == this.id"/>
        
        
    </div>

</template>

<style scoped> 



</style>
