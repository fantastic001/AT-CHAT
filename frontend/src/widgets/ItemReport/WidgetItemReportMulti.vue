<script>
import ItemReportService from "./service";
import WidgetItemReportSingle from "./WidgetItemReportSingle.vue";


export default {
    name: "WidgetItemReportMulti",
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
        ItemReportService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetItemReportSingle": WidgetItemReportSingle
    }
}
</script>

<template>
    <div class="WidgetItemReportSingle"> 
      <WidgetItemReportSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :itemreport="item.id"
          />
    </div>

</template>

<style scoped> 



</style>