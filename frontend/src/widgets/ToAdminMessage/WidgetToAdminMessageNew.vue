<script>
import ToAdminMessageService from "./service";

export default {
    name: "WidgetToAdminMessageNew",
    props: ["admin"],
    data: function () {
        return {
            data: {
	    	seller: localStorage.getItem("seller_id"),
		title: "",
		body: ""
	    },
	    role: localStorage.getItem("role"),
	    seller_id: localStorage.getItem("seller_id")
        };
    },
    methods: {
	submit: function() 
	{
		this.data.admin = this.admin;
		ToAdminMessageService.create(this.data).then(response => {
			alert("Message sent");
			this.$router.push("/");
		})
	}
    }
}
</script>

<template>
    <div class="widget-toadminmessage-new"> 
        <input type="text" v-model="data.title" placeholder="Message title" />
        <textarea v-model="data.body" />
	<button @click="submit">Send</button>
    </div>

</template>

<style scoped> 



</style>
