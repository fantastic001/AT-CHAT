<script>
import CategoryService from "./service";

export default {
    name: "WidgetCategorySingle",
    props: ["category"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        CategoryService.get(this.category).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-category-single"> 
    	<div class="card" style="width: 18rem;">
           <div class="card-body">
               <h5 class="card-title">{{ data.name }}</h5>
               <p class="card-text">{{ data.description }}</p>
               <router-link :to='"/categories/" + this.data.id' class="card-link">See all items in category</router-link>
           </div>
        </div>
    </div>

</template>

<style scoped> 



</style>
