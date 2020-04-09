<script>
import FromAdminMessageService from "./service";

export default {
    name: "WidgetFromAdminMessageSingleEdit",
    props: ["fromadminmessage"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        FromAdminMessageService.get(this.fromadminmessage).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-fromadminmessage-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>