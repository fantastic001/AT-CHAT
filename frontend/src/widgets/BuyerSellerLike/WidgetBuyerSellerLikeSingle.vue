<script>
import BuyerSellerLikeService from "./service";

export default {
    name: "WidgetBuyerSellerLikeSingle",
    props: ["buyersellerlike"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerSellerLikeService.get(this.buyersellerlike).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-buyersellerlike-single"> 
    </div>

</template>

<style scoped> 



</style>