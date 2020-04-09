<script>
import AdminService from "./service";
import UserService from "../User//service";

export default {
    name: "WidgetAdminSingle",
    props: ["admin"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        AdminService.get(this.admin).then(response => {
		this.data = response.data;
		UserService.get(this.data.user).then(response => this.data = response.data)
	});
    }
}
</script>

<template>
    <div class="widget-admin-single"> 
	{{ data.firstname }} {{ data.lastname }} - <b>Administrator</b>


    </div>

</template>



<style scoped> 


.widget-admin-single {
	padding: 10px; 
	background-color: #ffcccc; 
	margin: 10px;
}

</style>
