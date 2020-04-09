<script>
import BuyerFavoriteItemService from "./service";

export default {
    name: "WidgetBuyerFavoriteItemSingleEdit",
    props: ["buyerfavoriteitem"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerFavoriteItemService.get(this.buyerfavoriteitem).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-buyerfavoriteitem-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>