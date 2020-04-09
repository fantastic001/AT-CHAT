<script>
import FromAdminMessageService from "./service";
import WidgetAdminSingle from "../Admin/WidgetAdminSingle.vue";
import WidgetUserSingle from "../User/WidgetUserSingle.vue";

export default {
    name: "WidgetFromAdminMessageSingle",
    props: ["fromadminmessage"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        FromAdminMessageService.get(this.fromadminmessage).then(response => this.data = response.data);
    },
    components: {
    	"WidgetAdminSingle": WidgetAdminSingle,
	"WidgetUserSingle": WidgetUserSingle
    }
}
</script>

<template>
    <div class="widget-fromadminmessage-single"> 
        <span class="badge badge-danger">Administrattor message</span>
	<div class="message-sender"><WidgetAdminSingle admin="this.admin" /></div> 
	<div class="message-to"><WidgetUserSingle user="this.user" /></div> 
	
<div class="card">
  <div class="card-body">
    <h5 class="card-title">{{ data.title }}</h5>
    <h6 class="card-subtitle mb-2 text-muted">From Administrator</h6>
    <p class="card-text">{{ data.body }}</p>
  </div>
</div>

    </div>

</template>

<style scoped> 



</style>
