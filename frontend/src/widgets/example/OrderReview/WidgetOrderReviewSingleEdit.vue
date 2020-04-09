<script>
import OrderReviewService from "./service";

export default {
    name: "WidgetOrderReviewSingleEdit",
    props: ["orderreview"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        OrderReviewService.get(this.orderreview).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-orderreview-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>