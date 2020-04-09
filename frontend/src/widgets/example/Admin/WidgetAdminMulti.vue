<script>
import AdminService from "./service";
import WidgetAdminSingle from "./WidgetAdminSingle.vue";


export default {
    name: "WidgetAdminMulti",
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
        AdminService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetAdminSingle": WidgetAdminSingle
    }
}
</script>

<template>
    <div class="WidgetAdminSingle"> 
      <WidgetAdminSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :admin="item.id"
          />
    </div>

</template>

<style scoped> 



</style>