<script>
import ItemReportService from "./service";

export default {
    name: "WidgetItemReportSingle",
    props: ["itemreport"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ItemReportService.get(this.itemreport).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-itemreport-single"> 
    </div>

</template>

<style scoped> 



</style>