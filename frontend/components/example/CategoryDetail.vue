<script>


import WidgetItemMulti from "../widgets/Item/WidgetItemMulti.vue"


import CategoryService from "../widgets/Category/service"
import WidgetCategorySingle from "../widgets/Category/WidgetCategorySingle.vue"
import WidgetCategorySingleEdit from "../widgets/Category/WidgetCategorySingleEdit.vue"
import WidgetCategoryMulti from "../widgets/Category/WidgetCategoryMulti.vue"
import WidgetCategoryNew from "../widgets/Category/WidgetCategoryNew.vue"


export default {
    name: "CategoryDetail",
    props: ["category"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	CategoryService.get(this.category).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            CategoryService.delete(this.category).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Category item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetItemMulti": WidgetItemMulti,
        
        "WidgetCategorySingle": WidgetCategorySingle,
        "WidgetCategoryNew": WidgetCategoryNew,
        "WidgetCategorySingleEdit": WidgetCategorySingleEdit,
        "WidgetCategoryMulti": WidgetCategoryMulti
    }
}
</script>>

<template>
    <div class="Category-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetCategorySingle :category="this.category" />

        
        <WidgetItemMulti :filter="x => x.category == this.category"/>
        
        
    </div>

</template>

<style scoped> 



</style>