<script>
import OrderReviewService from "./service";

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
    }
}
</script>

<template>
    <div class="widget-orderreview-single"> 
    </div>

</template>

<style scoped> 



</style>