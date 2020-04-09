<script>
import BuyerService from "./service";

export default {
    name: "WidgetBuyerSingleEdit",
    props: ["buyer"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerService.get(this.buyer).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-buyer-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>