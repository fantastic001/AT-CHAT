<script>
import CommentService from "./service";
import WidgetCommentSingle from "./WidgetCommentSingle.vue";


export default {
    name: "WidgetCommentMulti",
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
        CommentService.list().then(response => this.items = response.data);
    },
    components: {
    	"WidgetCommentSingle": WidgetCommentSingle
    }
}
</script>

<template>
    <div class="WidgetCommentSingle"> 
      <WidgetCommentSingle
      	v-for="item in items.filter(filter)"
      	:id="item.id"
      	:key="item.id"
        :comment="item.id"
          />
    </div>

</template>

<style scoped> 



</style>