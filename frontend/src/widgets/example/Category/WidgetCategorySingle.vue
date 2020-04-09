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
    </div>

</template>

<style scoped> 



</style>