<script>
import MessageService from "./service";
import WidgetBuyerSingle from "../Buyer/WidgetBuyerSingle.vue"
import WidgetItemSingle from "../Item/WidgetItemSingle.vue"
export default {
    name: "WidgetMessageSingle",
    props: ["message"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        MessageService.get(this.message).then(response => this.data = response.data);
    },
    components: {
    	"WidgetBuyerSingle": WidgetBuyerSingle,
	"WidgetItemSingle": WidgetItemSingle
    }
}
</script>

<template>
    <div class="widget-message-single"> 
        <WidgetBuyerSingle :buyer="this.data.buyer" />
        <h1>{{ data.title }}</h1>
	<div class="message-body">{{ data.body}}</div>
    </div>

</template>

<style scoped> 



</style>
