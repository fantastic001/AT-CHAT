<script>


import WidgetUserMulti from "../widgets/User/WidgetUserMulti.vue"

import WidgetFromAdminMessageMulti from "../widgets/FromAdminMessage/WidgetFromAdminMessageMulti.vue"

import WidgetToAdminMessageMulti from "../widgets/ToAdminMessage/WidgetToAdminMessageMulti.vue"


import AdminService from "../widgets/Admin/service"
import WidgetAdminSingle from "../widgets/Admin/WidgetAdminSingle.vue"
import WidgetAdminSingleEdit from "../widgets/Admin/WidgetAdminSingleEdit.vue"
import WidgetAdminMulti from "../widgets/Admin/WidgetAdminMulti.vue"
import WidgetAdminNew from "../widgets/Admin/WidgetAdminNew.vue"
import WidgetToAdminMessageNew from "../widgets/ToAdminMessage/WidgetToAdminMessageNew.vue";

export default {
    name: "AdminDetail",
    props: ["admin"],
    data: function () {
            return {
		data: {},
		role: localStorage.getItem("role")
	    }
	},
    mounted: function () 
    {
    	AdminService.get(this.admin).then(response => this.data = response.data)

    },
    methods: {
        itemDelete: function (event) 
        {
        }
    },
    components: {
        WidgetAdminSingle,
        WidgetAdminNew,
        WidgetAdminSingleEdit,
        WidgetAdminMulti,
	WidgetToAdminMessageNew,
	WidgetToAdminMessageMulti,
	WidgetFromAdminMessageMulti
    }
}
</script>

<template>
    <div class="Admin-detail"> 
        <WidgetAdminSingle :admin="this.admin" />
        
        
        <WidgetToAdminMessageMulti v-if="this.role == 'ADMIN'" :filter="x => x.admin == this.admin"/>
        
	<WidgetToAdminMessageNew v-if="this.role == 'SELLER'" :admin="this.admin"/>
        
    </div>

</template>

<style scoped> 



</style>
