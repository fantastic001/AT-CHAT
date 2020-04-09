<script>
import ItemReportService from "./service";

export default {
    name: "WidgetItemReportNew",
    props: ["item"],
    data: function () {
        return {
            data: {
		title: "",
		body: ""
	    }
        };
    },
    methods: {
	submit: function() {
		this.data.item = this.item;
		this.data.buyer = localStorage.getItem("buyer_id");
		ItemReportService.create(this.data).then(response => {
			alert("Report sent");
			this.data = {};
		});
	}
    }
}
</script>

<template>
    <div class="widget-itemreport-new"> 
        <input type="text" placeholder="Title" v-model="data.title" class="form-control" />
        <input type="text" placeholder="Description" v-model="data.body" class="form-control" />
	<button @click="submit">Send report</button>
    </div>

</template>

<style scoped> 



</style>
