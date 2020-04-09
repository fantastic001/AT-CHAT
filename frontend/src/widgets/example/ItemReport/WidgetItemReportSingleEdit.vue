<script>
import ItemReportService from "./service";

export default {
    name: "WidgetItemReportSingleEdit",
    props: ["itemreport"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ItemReportService.get(this.itemreport).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-itemreport-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>