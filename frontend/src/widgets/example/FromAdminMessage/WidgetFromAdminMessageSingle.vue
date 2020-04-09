<script>
import FromAdminMessageService from "./service";

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
    }
}
</script>

<template>
    <div class="widget-fromadminmessage-single"> 
    </div>

</template>

<style scoped> 



</style>