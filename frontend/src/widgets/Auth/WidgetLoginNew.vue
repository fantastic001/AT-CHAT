<script>
import LoginService from "./service";
import CheckRoleService from "../CheckRole/service";
//import router from '../../../router';

export default {
    name: "WidgetLoginNew",
    data: function () {
        return {
            data: {
	    	userName: null,
		password: null,
	    },

        };
    },
    methods: {
    	submit: function() 
	{
		LoginService.login(this.data).then(response => {
			console.log(response)
			if (response.data.code == 0) {
				CheckRoleService.get().then(response => {
					localStorage.setItem("user", this.data.userName);
					localStorage.setItem("role", response.data.message);
					this.$store.commit("login", {user: this.data.userName, role: response.data.message});
					this.$router.push("/");
					LoginService.info().then(response => {
						console.log("AUTHORIZATION INFO:");
						console.log(response);
						localStorage.setItem("user_id", response.data.user);
						localStorage.setItem("buyer_id", response.data.buyer);
						localStorage.setItem("seller_id", response.data.seller);
						localStorage.setItem("admin_id", response.data.admin);
					});

				});

			}
			else {
				localStorage.setItem("user", null);
				alert("Error while logging in. Access forbidden or wrong credentials");
			}


		}).catch(error => {
				alert("Error while logging in. Access forbidden or wrong credentials");
		});
	}
    }
}
</script>

<template>

    <div class="widget-login-new"> 

		<h2> Login</h2>
		<p>
		<input type="text" class="form-control" placeholder="Username" v-model="data.userName" />
		</p>
		
		<p>
		<input type="password" class="form-control" placeholder="Password" v-model="data.password" />
		</p>
		

		<button type="button" class="btn btn-primary btn-lg btn-block" v-on:click="submit">Submit</button>
		&nbsp;
		&nbsp;
		<a href="/frontend/#/register">If you dont have account, click here to register</a>
    </div>

</template>

<style scoped> 



.widget-login-new {
	position: relative;
    top:20%;
    left:40%;
	padding: 10px; 
	margin: 10px;
	text-align: center;
	width: 20%;
}

.success-box 
{
	
	padding: 5px;
}

</style>
