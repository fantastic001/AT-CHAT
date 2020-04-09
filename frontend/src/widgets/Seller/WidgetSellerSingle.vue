<script>
import SellerService from "./service";
import WidgetUserSingle from "../User/WidgetUserSingle.vue";

export default {
    name: "WidgetSellerSingle",
    props: ["seller"],
    data: function () {
        return {
            data: {
		user: null
	    },
	    likes: 0,
	    dislikes: 0
        }
    },
    created: function () 
    {
        SellerService.get(this.seller).then(response => {
		this.data = response.data;
		this.$forceUpdate();
	});

	SellerService.getLikeCount(this.seller).then(response => this.likes = response.data);
	SellerService.getDislikeCount(this.seller).then(response => this.dislikes = response.data);
    },
    components: {
        "WidgetUserSingle": WidgetUserSingle
    },
    methods: 
    {
    	likeSeller: function() 
	{
		SellerService.like(this.seller).then(response => 
		{
			SellerService.getLikeCount(this.seller).then(response => this.likes = response.data);
			SellerService.getDislikeCount(this.seller).then(response => this.dislikes = response.data);
		});
	},
	dislikeSeller: function() 
	{
		SellerService.dislike(this.seller).then(response => 
		{
			SellerService.getLikeCount(this.seller).then(response => this.likes = response.data);
			SellerService.getDislikeCount(this.seller).then(response => this.dislikes = response.data);
		});
		
	}
    }
}
</script>

<template>
    <div class="widget-seller-single">
    <WidgetUserSingle v-if="this.data.user != null" :user="this.data.user" />

    <button @click="likeSeller" type="button" class="btn btn-primary">
       Like<span class="badge badge-light">{{likes}}</span>
    </button>
    
    <button @click="dislikeSeller" type="button" class="btn btn-danger">
       Dislike<span class="badge badge-light">{{dislikes}}</span>
    </button>
    </div>

</template>

<style scoped> 



</style>
