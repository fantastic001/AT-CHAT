<script>
import FromAdminMessageService from "./service";

export default {
    name: "WidgetFromAdminMessageNew",
    props: ["user"],
    data: function () {
        return {
            data: {
		admin: localStorage.getItem("admin_id"),
	    },
        };
    },
    methods: {
	submit: function() 
	{
		this.data.user = this.user;
		FromAdminMessageService.create(this.data).then(response => {
			this.data.title = "";
			this.data.body = "";
			alert("Message sent");
		})
	}
    }
}
</script>

<template>
    <div class="widget-fromadminmessage-new"> 
        <p><input type="text" v-model="data.title" placeholder="title" /></p>
        <p><textarea v-model="data.body" /></p>
	<p><button @click="submit">Send</button></p>
    </div>

</template>

<style scoped> 



</style>
