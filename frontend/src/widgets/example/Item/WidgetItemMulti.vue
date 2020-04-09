<script>
import ItemService from "./service";
import WidgetItemSingle from "./WidgetItemSingle.vue";


export default {
    name: "WidgetItemMulti",
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
        ItemService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetItemSingle": WidgetItemSingle
    }
}
</script>

<template>
    <div class="WidgetItemSingle"> 
      <WidgetItemSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :item="item.id"
          />
    </div>

</template>

<style scoped> 



</style>