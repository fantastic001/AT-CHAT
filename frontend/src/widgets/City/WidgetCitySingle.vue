<script>
import CityService from "./service";

export default {
    name: "WidgetCitySingle",
    props: ["city"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        CityService.get(this.city).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-city-single"> 
    	{{ data.name }}, {{ data.country}}
    </div>

</template>

<style scoped> 



</style>
