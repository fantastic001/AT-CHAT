<script>
import {{ component }}Service from "./service";
import Widget{{ component }}Single from "./Widget{{component}}Single.vue";


export default {
    name: "Widget{{ component }}Multi",
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
        {{ component }}Service.list().then(response => this.items = response.data);
    },
    components: {
    	"Widget{{ component }}Single": Widget{{ component }}Single
    }
}
</script>

<template>
    <div class="Widget{{component}}Single"> 
      <Widget{{ component }}Single
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :{{ component | lower}}="item.id"
          />
    </div>

</template>

<style scoped> 



</style>