<script>
import SellerReportService from "./service";

export default {
    name: "WidgetSellerReportSingleEdit",
    props: ["sellerreport"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        SellerReportService.get(this.sellerreport).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-sellerreport-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>