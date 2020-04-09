<script>
import SellerReportService from "./service";

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
    }
}
</script>

<template>
    <div class="widget-sellerreport-single"> 
    </div>

</template>

<style scoped> 



</style>