<script>



import OrderReviewService from "../widgets/OrderReview/service"
import WidgetOrderReviewSingle from "../widgets/OrderReview/WidgetOrderReviewSingle.vue"
import WidgetOrderReviewSingleEdit from "../widgets/OrderReview/WidgetOrderReviewSingleEdit.vue"
import WidgetOrderReviewMulti from "../widgets/OrderReview/WidgetOrderReviewMulti.vue"
import WidgetOrderReviewNew from "../widgets/OrderReview/WidgetOrderReviewNew.vue"


export default {
    name: "OrderReviewDetail",
    props: ["orderreview"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	OrderReviewService.get(this.orderreview).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            OrderReviewService.delete(this.orderreview).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("OrderReview item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetOrderReviewSingle": WidgetOrderReviewSingle,
        "WidgetOrderReviewNew": WidgetOrderReviewNew,
        "WidgetOrderReviewSingleEdit": WidgetOrderReviewSingleEdit,
        "WidgetOrderReviewMulti": WidgetOrderReviewMulti
    }
}
</script>>

<template>
    <div class="OrderReview-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetOrderReviewSingle :orderreview="this.orderreview" />

        
    </div>

</template>

<style scoped> 



</style>