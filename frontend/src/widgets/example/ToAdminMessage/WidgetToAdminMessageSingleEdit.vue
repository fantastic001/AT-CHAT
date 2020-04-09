<script>
import ToAdminMessageService from "./service";

export default {
    name: "WidgetToAdminMessageSingleEdit",
    props: ["toadminmessage"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ToAdminMessageService.get(this.toadminmessage).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-toadminmessage-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>