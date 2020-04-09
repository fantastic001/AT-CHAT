<script>
import CityService from "./service";
import WidgetCitySingle from "./WidgetCitySingle.vue";


export default {
    name: "WidgetCityMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        CityService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetCitySingle": WidgetCitySingle
    }
}
</script>

<template>
    <div class="WidgetCitySingle"> 
      <WidgetCitySingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :city="item.id"
          />
    </div>

</template>

<style scoped> 



</style>