<script>
import CategoryService from "./service";

export default {
    name: "WidgetCategoryNew",
    data: function () {
        return {
            data: {
		name: "",
		description: "",
		id: 0
	    }
        };
    },
    methods: {
	submit: function() {
		CategoryService.create(this.data).then(response => {
			this.$router.push("/categories/" + response.data.id);
		})
	}
    }
}
</script>

<template>
    <div class="widget-category-new"> 
        <input type="text" v-model="data.name" placeholder="Name"/>
        <input type="text" v-model="data.description" placeholder="Description"/>
	<button @click="submit">Create</button>
    </div>

</template>

<style scoped> 



</style>
