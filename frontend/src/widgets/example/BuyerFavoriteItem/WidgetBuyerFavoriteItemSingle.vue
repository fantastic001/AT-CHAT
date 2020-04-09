<script>
import BuyerFavoriteItemService from "./service";

export default {
    name: "WidgetBuyerFavoriteItemSingle",
    props: ["buyerfavoriteitem"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerFavoriteItemService.get(this.buyerfavoriteitem).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-buyerfavoriteitem-single"> 
    </div>

</template>

<style scoped> 



</style>