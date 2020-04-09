<script>
import CommentService from "./service";

export default {
    name: "WidgetCommentSingle",
    props: ["comment"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        CommentService.get(this.comment).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-comment-single"> 
    </div>

</template>

<style scoped> 



</style>