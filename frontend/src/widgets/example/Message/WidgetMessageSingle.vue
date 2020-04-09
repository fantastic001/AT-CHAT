<script>
import MessageService from "./service";

export default {
    name: "WidgetMessageSingle",
    props: ["message"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        MessageService.get(this.message).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-message-single"> 
    </div>

</template>

<style scoped> 



</style>