<script>
import ItemService from "./service";

export default {
    name: "WidgetItemSingleEdit",
    props: ["item"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ItemService.get(this.item).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-item-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>