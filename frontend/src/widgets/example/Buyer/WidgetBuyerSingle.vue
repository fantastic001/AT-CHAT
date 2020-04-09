<script>
import BuyerService from "./service";

export default {
    name: "WidgetBuyerSingle",
    props: ["buyer"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerService.get(this.buyer).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-buyer-single"> 
    </div>

</template>

<style scoped> 



</style>