<script>
import UserService from "./service";

export default {
    name: "WidgetUserSingle",
    props: ["user"],
    data: function () {
        return {
            data: {
		id: null
	    }
        }
    },
    mounted: function () 
    {
        UserService.get(this.user).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-user-single"> 


<div v-if="this.data.id != null" class="card" style="width: 18rem;">
  <div class="card-header">
    {{ data.username }}
  </div>
  <div class="card-body">
    <h5 class="card-title"><router-link :to="'/users/' + this.data.id">{{ data.firstname }} {{ data.lastname }}</router-link></h5>
    <p class="card-text">{{ data.email}}</p>
  </div>
</div>

    </div>

</template>

<style scoped> 



</style>
