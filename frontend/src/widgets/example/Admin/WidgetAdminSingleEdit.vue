<script>
import AdminService from "./service";

export default {
    name: "WidgetAdminSingleEdit",
    props: ["admin"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        AdminService.get(this.admin).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-admin-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>