<script>
import CategoryService from "./service";
import WidgetCategorySingle from "./WidgetCategorySingle.vue";


export default {
    name: "WidgetCategoryMulti",
    props: {
        filter: {
            type: Function,
            default: (x => true)
        }
    },
    data: function () {
        return {
            items: []
        }
    },
    mounted: function () 
    {
        CategoryService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetCategorySingle": WidgetCategorySingle
    }
}
</script>

<template>
    <div class="WidgetCategorySingle"> 
      <WidgetCategorySingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :category="item.id"
          />
    </div>

</template>

<style scoped> 



</style>