<script>
import SellerReportService from "./service";
import WidgetBuyerSingle from "../Buyer/WidgetBuyerSingle.vue";

export default {
    name: "WidgetSellerReportSingle",
    props: ["sellerreport"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        SellerReportService.get(this.sellerreport).then(response => this.data = response.data);
    },
    components: {
        "WidgetBuyerSingle": WidgetBuyerSingle
    }
}
</script>

<template>
    <div class="widget-sellerreport-single"> 
    <WidgetBuyerSingle :buyer="this.buyer" />
    <div class="seller-report-details">
        <div class="seller-report-title">{{ data.title }}</div>
        <div class="seller-report-body">{{ data.body }}</div>
    </div>
    </div>

</template>

<style scoped> 



</style>
