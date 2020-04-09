<script>
import ToAdminMessageService from "./service";
import Seller from "../Seller/WidgetSellerSingle.vue";

export default {
    name: "WidgetToAdminMessageSingle",
    props: ["toadminmessage"],
    data: function () {
        return {
            data: {
		seller: null
	    },
	    role: localStorage.getItem("role"),
	    admin_id: localStorage.getItem("admin_id")
        }
    },
    mounted: function () 
    {
        ToAdminMessageService.get(this.toadminmessage).then(response => this.data = response.data);
    },
    components: 
    {
        Seller,
    }
}
</script>

<template>
    <div class="widget-toadminmessage-single"> 
    <Seller v-if="this.data.seller != null" :seller="this.data.seller" />
    <h1>{{ data.title }}</h1>
    <div class="message-body">{{ data.body }}</div>
    </div>

</template>

<style scoped> 

.widget-toadminmessage-single {
	background-color: #eeffff;
	padding: 10px;
}

</style>
