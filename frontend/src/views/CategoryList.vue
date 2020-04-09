<script>


import WidgetItemMulti from "../widgets/Item/WidgetItemMulti.vue"


import CategoryService from "../widgets/Category/service"
import WidgetCategorySingle from "../widgets/Category/WidgetCategorySingle.vue"
import WidgetCategorySingleEdit from "../widgets/Category/WidgetCategorySingleEdit.vue"
import WidgetCategoryMulti from "../widgets/Category/WidgetCategoryMulti.vue"
import WidgetCategoryNew from "../widgets/Category/WidgetCategoryNew.vue"


export default {
    name: "CategoryList",
    data: function () {
            return {
		data: {},
		role: localStorage.getItem("role")
	    };
	},
    mounted: function () 
    {
    	CategoryService.get(this.category).then(response => this.data = response.data)
    },
    components: {
        
        "WidgetItemMulti": WidgetItemMulti,
        
        "WidgetCategorySingle": WidgetCategorySingle,
        "WidgetCategoryNew": WidgetCategoryNew,
        "WidgetCategorySingleEdit": WidgetCategorySingleEdit,
        "WidgetCategoryMulti": WidgetCategoryMulti
    }
}
</script>

<template>
    <div class="Category-detail"> 
	<WidgetCategoryNew v-if="this.role == 'ADMIN'"/>
        <WidgetCategoryMulti />

        
        
    </div>

</template>

<style scoped> 



</style>
