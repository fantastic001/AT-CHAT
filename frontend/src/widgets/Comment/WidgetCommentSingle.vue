<script>
import CommentService from "./service";
import UserService from "../User/service"
export default {
    name: "WidgetCommentSingle",
    props: ["comment"],
    data: function () {
        return {
            data: {},
	    author: {}
        }
    },
    mounted: function () 
    {
        CommentService.get(this.comment).then(response => {
		this.data = response.data;
		UserService.get(this.data.user).then(response => this.author = response.data)
	});
    }
}
</script>

<template>
<div class="widget-comment-single"> 

<div class="card">

  <div class="card-body">
    <h5 class="card-title">{{ author.firstname }} {{author.lastname }}</h5>
    <p class="card-text">{{ data.body }}</p>
  </div>
</div> 


</div>

</template>

<style scoped> 

</style>
