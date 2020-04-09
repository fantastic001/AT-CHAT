<script>
import SellerService from "./service";

export default {
    name: "WidgetSellerSingle",
    props: ["seller"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        SellerService.get(this.seller).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-seller-single"> 
    </div>

</template>

<style scoped> 



</style>