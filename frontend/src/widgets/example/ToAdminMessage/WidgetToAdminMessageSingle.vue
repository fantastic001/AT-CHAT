<script>
import ToAdminMessageService from "./service";

export default {
    name: "WidgetToAdminMessageSingle",
    props: ["toadminmessage"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        ToAdminMessageService.get(this.toadminmessage).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-toadminmessage-single"> 
    </div>

</template>

<style scoped> 



</style>