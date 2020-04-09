<script>
import OrderReviewService from "./service";
import WidgetBuyerSingle from "../Buyer/WidgetBuyerSingle.vue";

export default {
    name: "WidgetOrderReviewSingle",
    props: ["orderreview"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        OrderReviewService.get(this.orderreview).then(response => this.data = response.data);
    },
    components: {
        "WidgetBuyerSingle": WidgetBuyerSingle
    }
}
</script>

<template>
    <div class="widget-orderreview-single"> 
    <WidgetBuyerSingle :buyer="this.buyer" />
    <div class="order-review-details">
        <div class="order-review-title">{{ data.title }}</div>
        <div class="order-review-body">{{ data.body }}</div>
    </div>
    </div>

</template>

<style scoped> 



</style>
