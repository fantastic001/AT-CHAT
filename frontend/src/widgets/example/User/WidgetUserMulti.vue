<script>
import UserService from "./service";
import WidgetUserSingle from "./WidgetUserSingle.vue";


export default {
    name: "WidgetUserMulti",
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
        UserService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetUserSingle": WidgetUserSingle
    }
}
</script>

<template>
    <div class="WidgetUserSingle"> 
      <WidgetUserSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :user="item.id"
          />
    </div>

</template>

<style scoped> 



</style>