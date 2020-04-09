<script>
import SellerService from "./service";

export default {
    name: "WidgetSellerSingleEdit",
    props: ["seller"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        SellerService.get(this.seller).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-seller-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>