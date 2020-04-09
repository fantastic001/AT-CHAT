<script>
import UserService from "./service";
import BuyerService from "../Buyer/service";
import SellerService from "../Seller/service";

export default {
    name: "WidgetUserNew",
    data: function () {
        return {
            data: {
	    	username: null,
		password: null,
		email: null
	    },
	    success: false,

        };
    },
    methods: {
    	submit: function() 
	{
		UserService.create(this.data).then(response => {
			console.log("User created: ");
			console.log(response.data);
			this.success = true
			this.user = response.data.id;
		});
	},

    	submitBuyer: function() 
	{
		console.log(this.user);
		BuyerService.create({id:0, user:this.user}).then(response => {
			this.$router.push("/");
		});
	},
    	submitSeller: function() 
	{
		console.log(this.user);
		SellerService.create({id: 0, user:this.user}).then(response => {
			this.$router.push("/");
		});
	}
    }
}
</script>

<template>
    <div class="widget-user-new"> 
        <div v-if="this.success">Creation successful</div>
	<div v-if="!this.success"> 
		<p>
		<label>Username</label>
		<input type="text" v-model="data.username" />
		</p>
		
		<p>
		<label>Password</label>
		<input type="password" v-model="data.password" />
		</p>
		
		<p>
		<label>Email</label>
		<input type="text" v-model="data.email" />
		</p>
		
		<p>
		<label>Firstname</label>
		<input type="text" v-model="data.firstname" />
		</p>
		
		<p>
		<label>Lastname</label>
		<input type="text" v-model="data.lastname" />
		</p>
		
		<p>
		<label>Phone</label>
		<input type="text" v-model="data.phone" />
		</p>

		<p><button v-on:click="submit">Submit</button></p>
	</div>
	<div v-if="this.success">
		<p>Select your type (user ID: {{ user }})</p>
		<p><button v-on:click="submitBuyer">Register as a buyer</button></p>
		<p><button v-on:click="submitSeller">Register as a seller</button></p>
	</div>
    </div>

</template>

<style scoped> 



</style>
