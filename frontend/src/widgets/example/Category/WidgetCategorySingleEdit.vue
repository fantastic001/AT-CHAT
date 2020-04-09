<script>
import CategoryService from "./service";

export default {
    name: "WidgetCategorySingleEdit",
    props: ["category"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        CategoryService.get(this.category).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-category-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>