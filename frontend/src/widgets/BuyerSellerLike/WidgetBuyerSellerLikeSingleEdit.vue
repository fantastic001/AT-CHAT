<script>
import BuyerSellerLikeService from "./service";

export default {
    name: "WidgetBuyerSellerLikeSingleEdit",
    props: ["buyersellerlike"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerSellerLikeService.get(this.buyersellerlike).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-buyersellerlike-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>