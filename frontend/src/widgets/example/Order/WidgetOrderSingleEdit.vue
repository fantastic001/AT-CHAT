<script>
import OrderService from "./service";

export default {
    name: "WidgetOrderSingleEdit",
    props: ["order"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        OrderService.get(this.order).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-order-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>