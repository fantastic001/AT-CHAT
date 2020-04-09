<script>
import CommentService from "./service";
import OrderService from "../Order/service";

export default {
    name: "WidgetCommentNew",
    props: ["item"],
    data: function () {
        return {
            data: {},
	    enabled: false
        };
    },
    mounted: function() {
	if (localStorage.getItem("role") != "BUYER") this.enabled = true;
	OrderService.list().then(response => {
		this.orders = response.data;
		if (this.orders.filter(
			x => x.item == this.item && localStorage.getItem("role") == "BUYER" && localStorage.getItem("buyer_id") == x.buyer && x.status == "SHIPPED"
		).length > 0) {
			this.enabled = true;
		}
	});
    },
    methods: {
    	create: function() 
	{
		this.data.item = this.item;
		CommentService.create(this.data).then(response => {
			this.data = {user: 0, item: this.item, body: ""}
			this.$emit("submit");
		});
	}
    }
}
</script>

<template>
    <div class="widget-comment-new"> 
        <div v-if="this.enabled" class="input-group mb-3">
  		<input v-model="data.body" type="text" class="form-control" placeholder="Write a comment..." />
  		<div class="input-group-append">
    		<button @click="create" class="btn btn-outline-secondary" type="button">Send</button>
  	</div>
    </div>

    </div>

</template>

<style scoped> 



</style>
