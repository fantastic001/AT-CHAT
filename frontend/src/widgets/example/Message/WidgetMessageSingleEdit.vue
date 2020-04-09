<script>
import MessageService from "./service";

export default {
    name: "WidgetMessageSingleEdit",
    props: ["message"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        MessageService.get(this.message).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-message-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>