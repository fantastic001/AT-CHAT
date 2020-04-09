<script>
import ItemReportService from "./service";
import WidgetBuyerSingle from "../Buyer/WidgetBuyerSingle.vue";
export default {
    name: "WidgetItemReportSingle",
    props: ["itemreport"],
    data: function () {
        return {
            data: {
		buyer: null
	    }
        }
    },
    mounted: function () 
    {
        ItemReportService.get(this.itemreport).then(response => this.data = response.data);
    },
    components: {
    	"WidgetBuyerSingle": WidgetBuyerSingle
    }
}
</script>

<template>
    <div class="widget-itemreport-single"> 
        <WidgetBuyerSingle v-if="this.data.buyer != null" :buyer="data.buyer" />
        <h1>{{ data.title }}</h1>
	<div class="report-body">{{ data.body}}</div>
    </div>

</template>

<style scoped> 

.widget-itemreport-single {
	background-color: #faa;
	padding: 15px;
	margin: 10px;
}

</style>
