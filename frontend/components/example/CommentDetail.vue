<script>



import CommentService from "../widgets/Comment/service"
import WidgetCommentSingle from "../widgets/Comment/WidgetCommentSingle.vue"
import WidgetCommentSingleEdit from "../widgets/Comment/WidgetCommentSingleEdit.vue"
import WidgetCommentMulti from "../widgets/Comment/WidgetCommentMulti.vue"
import WidgetCommentNew from "../widgets/Comment/WidgetCommentNew.vue"


export default {
    name: "CommentDetail",
    props: ["comment"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	CommentService.get(this.comment).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            CommentService.delete(this.comment).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("Comment item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetCommentSingle": WidgetCommentSingle,
        "WidgetCommentNew": WidgetCommentNew,
        "WidgetCommentSingleEdit": WidgetCommentSingleEdit,
        "WidgetCommentMulti": WidgetCommentMulti
    }
}
</script>>

<template>
    <div class="Comment-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetCommentSingle :comment="this.comment" />

        
    </div>

</template>

<style scoped> 



</style>