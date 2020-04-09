<script>
import SellerService from "./service";
import WidgetSellerSingle from "./WidgetSellerSingle.vue";


export default {
    name: "WidgetSellerMulti",
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
        SellerService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetSellerSingle": WidgetSellerSingle
    }
}
</script>

<template>
    <div class="WidgetSellerSingle"> 
      <WidgetSellerSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :seller="item.id"
          />
    </div>

</template>

<style scoped> 



</style>