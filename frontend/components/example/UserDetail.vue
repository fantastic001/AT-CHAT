<script>


import WidgetConversationMulti from "../widgets/Conversation/WidgetConversationMulti.vue"

import WidgetFromAdminMessageMulti from "../widgets/FromAdminMessage/WidgetFromAdminMessageMulti.vue"


import UserService from "../widgets/User/service"
import WidgetUserSingle from "../widgets/User/WidgetUserSingle.vue"
import WidgetUserSingleEdit from "../widgets/User/WidgetUserSingleEdit.vue"
import WidgetUserMulti from "../widgets/User/WidgetUserMulti.vue"
import WidgetUserNew from "../widgets/User/WidgetUserNew.vue"


export default {
    name: "UserDetail",
    props: ["user"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	UserService.get(this.user).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            UserService.delete(this.user).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("User item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetConversationMulti": WidgetConversationMulti,
        
        "WidgetFromAdminMessageMulti": WidgetFromAdminMessageMulti,
        
        "WidgetUserSingle": WidgetUserSingle,
        "WidgetUserNew": WidgetUserNew,
        "WidgetUserSingleEdit": WidgetUserSingleEdit,
        "WidgetUserMulti": WidgetUserMulti
    }
}
</script>>

<template>
    <div class="User-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetUserSingle :user="this.user" />

        
        <WidgetConversationMulti :filter="x => x.user == this.user"/>
        
        
        <WidgetFromAdminMessageMulti :filter="x => x.user == this.user"/>
        
        
    </div>

</template>

<style scoped> 



</style>