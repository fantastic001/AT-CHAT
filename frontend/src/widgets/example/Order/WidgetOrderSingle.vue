<script>
import OrderService from "./service";

export default {
    name: "WidgetOrderSingle",
    props: ["order"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        OrderService.get(this.order).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-order-single"> 
    </div>

</template>

<style scoped> 



</style>