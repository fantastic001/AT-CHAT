<script>
import AdminService from "./service";

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
        AdminService.get(this.admin).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-admin-single"> 
    </div>

</template>

<style scoped> 



</style>