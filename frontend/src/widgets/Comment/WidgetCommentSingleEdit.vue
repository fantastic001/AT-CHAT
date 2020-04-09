<script>
import CommentService from "./service";

export default {
    name: "WidgetCommentSingleEdit",
    props: ["comment"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        CommentService.get(this.comment).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-comment-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>