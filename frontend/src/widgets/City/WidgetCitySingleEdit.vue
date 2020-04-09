<script>
import CityService from "./service";

export default {
    name: "WidgetCitySingleEdit",
    props: ["city"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        CityService.get(this.city).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-city-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>