<script>
import SellerReportService from "./service";
import WidgetSellerReportSingle from "./WidgetSellerReportSingle.vue";


export default {
    name: "WidgetSellerReportMulti",
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
        SellerReportService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetSellerReportSingle": WidgetSellerReportSingle
    }
}
</script>

<template>
    <div class="WidgetSellerReportSingle"> 
      <WidgetSellerReportSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :sellerreport="item.id"
          />
    </div>

</template>

<style scoped> 



</style>