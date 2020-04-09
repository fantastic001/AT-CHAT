<script>
import ItemService from "./service";
import CategoryService from "../Category/service"
import CityService from "../City/service"

export default {
    name: "WidgetItemNew",
    data: function () {
        return {
            data: {
		name: "",
		description: "",
		seller: localStorage.getItem("seller_id"),
		city: null,
		category: null,
		active: true,
		"image": null,
		"likes": 0,
		"dislikes": 0,
		"dueDate": null,
		"creationDate": null,
		"shipped": false,
	    },
	    categories: [],
	    cities: []
        };
    },
    mounted: function() {
	CategoryService.list().then(response => {
		this.categories = response.data;
	})
	CityService.list().then(response => {
		this.cities = response.data;
	})
    },
    methods: {
	submit: function() {
		ItemService.create(this.data).then(response => {
			this.$router.push("/items/" + response.data.id);
		});
	},
    }
}
</script>

<template>
<div class="widget-item-new"> 

<input type="text" class="form-control" v-model="data.name" placeholder="Item name" />
<input type="text" class="form-control" v-model="data.description" placeholder="Item description" />
<input type="number" class="form-control" v-model="data.price" placeholder="Price" />
<input type="date" class="form-control" v-model="data.dueDate" placeholder="Item due date" />
<select v-model="data.category">
	<option disabled value="">Please select category</option>
	<option v-for="category in this.categories" :key="category.id" :value="category.id"> {{ category.name}}</option>
</select>
<select v-model="data.city">
	<option disabled value="">Please select city</option>
	<option v-for="city in this.cities" :key="city.id" :value="city.id"> {{ city.name}}</option>
</select>
<button class="btn btn-primary" @click="submit">Create</button>


</div>

</template>

<style scoped> 



</style>
