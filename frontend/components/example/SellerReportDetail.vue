<script>



import SellerReportService from "../widgets/SellerReport/service"
import WidgetSellerReportSingle from "../widgets/SellerReport/WidgetSellerReportSingle.vue"
import WidgetSellerReportSingleEdit from "../widgets/SellerReport/WidgetSellerReportSingleEdit.vue"
import WidgetSellerReportMulti from "../widgets/SellerReport/WidgetSellerReportMulti.vue"
import WidgetSellerReportNew from "../widgets/SellerReport/WidgetSellerReportNew.vue"


export default {
    name: "SellerReportDetail",
    props: ["sellerreport"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	SellerReportService.get(this.sellerreport).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            SellerReportService.delete(this.sellerreport).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("SellerReport item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetSellerReportSingle": WidgetSellerReportSingle,
        "WidgetSellerReportNew": WidgetSellerReportNew,
        "WidgetSellerReportSingleEdit": WidgetSellerReportSingleEdit,
        "WidgetSellerReportMulti": WidgetSellerReportMulti
    }
}
</script>>

<template>
    <div class="SellerReport-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetSellerReportSingle :sellerreport="this.sellerreport" />

        
    </div>

</template>

<style scoped> 



</style>