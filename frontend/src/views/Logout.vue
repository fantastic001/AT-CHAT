<script>


export default {
    name: "LogOut",
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
	localStorage.setItem("user", "");
	localStorage.setItem("role", "");
	this.$store.commit("login", {user: "", role: "NOT_LOGGED"});
	this.$router.push("/");
    },
}
</script>

<template>

<p>Logging out...</p>

</template>

<style scoped> 



</style>
