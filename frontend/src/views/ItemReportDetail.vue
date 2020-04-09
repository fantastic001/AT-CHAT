<script>



import ItemReportService from "../widgets/ItemReport/service"
import WidgetItemReportSingle from "../widgets/ItemReport/WidgetItemReportSingle.vue"
import WidgetItemReportSingleEdit from "../widgets/ItemReport/WidgetItemReportSingleEdit.vue"
import WidgetItemReportMulti from "../widgets/ItemReport/WidgetItemReportMulti.vue"
import WidgetItemReportNew from "../widgets/ItemReport/WidgetItemReportNew.vue"


export default {
    name: "ItemReportDetail",
    props: ["itemreport"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	ItemReportService.get(this.itemreport).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            ItemReportService.delete(this.itemreport).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("ItemReport item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetItemReportSingle": WidgetItemReportSingle,
        "WidgetItemReportNew": WidgetItemReportNew,
        "WidgetItemReportSingleEdit": WidgetItemReportSingleEdit,
        "WidgetItemReportMulti": WidgetItemReportMulti
    }
}
</script>>

<template>
    <div class="ItemReport-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetItemReportSingle :itemreport="this.itemreport" />

        
    </div>

</template>

<style scoped> 



</style>