<script>


import WidgetSellerMulti from "../widgets/Seller/WidgetSellerMulti.vue"

import WidgetOrderMulti from "../widgets/Order/WidgetOrderMulti.vue"

import WidgetBuyerFavoriteItemMulti from "../widgets/BuyerFavoriteItem/WidgetBuyerFavoriteItemMulti.vue"

import WidgetCommentMulti from "../widgets/Comment/WidgetCommentMulti.vue"

import WidgetItemReportMulti from "../widgets/ItemReport/WidgetItemReportMulti.vue"


import ItemService from "../widgets/Item/service"
import WidgetItemSingle from "../widgets/Item/WidgetItemSingle.vue"
import WidgetItemSingleEdit from "../widgets/Item/WidgetItemSingleEdit.vue"
import WidgetItemMulti from "../widgets/Item/WidgetItemMulti.vue"
import WidgetItemNew from "../widgets/Item/WidgetItemNew.vue"


export default {
    name: "ItemDetail",
    props: ["item"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	ItemService.get(this.item).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            ItemService.delete(this.item).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Item item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetSellerMulti": WidgetSellerMulti,
        
        "WidgetOrderMulti": WidgetOrderMulti,
        
        "WidgetBuyerFavoriteItemMulti": WidgetBuyerFavoriteItemMulti,
        
        "WidgetCommentMulti": WidgetCommentMulti,
        
        "WidgetItemReportMulti": WidgetItemReportMulti,
        
        "WidgetItemSingle": WidgetItemSingle,
        "WidgetItemNew": WidgetItemNew,
        "WidgetItemSingleEdit": WidgetItemSingleEdit,
        "WidgetItemMulti": WidgetItemMulti
    }
}
</script>>

<template>
    <div class="Item-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetItemSingle :item="this.item" />

        
        <WidgetSellerMulti :filter="x => x.item == this.item"/>
        
        
        <WidgetOrderMulti :filter="x => x.item == this.item"/>
        
        
        <WidgetBuyerFavoriteItemMulti :filter="x => x.item == this.item"/>
        
        
        <WidgetCommentMulti :filter="x => x.item == this.item"/>
        
        
        <WidgetItemReportMulti :filter="x => x.item == this.item"/>
        
        
    </div>

</template>

<style scoped> 



</style>