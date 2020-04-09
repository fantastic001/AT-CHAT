<script>



import FromAdminMessageService from "../widgets/FromAdminMessage/service"
import WidgetFromAdminMessageSingle from "../widgets/FromAdminMessage/WidgetFromAdminMessageSingle.vue"
import WidgetFromAdminMessageSingleEdit from "../widgets/FromAdminMessage/WidgetFromAdminMessageSingleEdit.vue"
import WidgetFromAdminMessageMulti from "../widgets/FromAdminMessage/WidgetFromAdminMessageMulti.vue"
import WidgetFromAdminMessageNew from "../widgets/FromAdminMessage/WidgetFromAdminMessageNew.vue"


export default {
    name: "FromAdminMessageDetail",
    props: ["fromadminmessage"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	FromAdminMessageService.get(this.fromadminmessage).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            FromAdminMessageService.delete(this.fromadminmessage).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("FromAdminMessage item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetFromAdminMessageSingle": WidgetFromAdminMessageSingle,
        "WidgetFromAdminMessageNew": WidgetFromAdminMessageNew,
        "WidgetFromAdminMessageSingleEdit": WidgetFromAdminMessageSingleEdit,
        "WidgetFromAdminMessageMulti": WidgetFromAdminMessageMulti
    }
}
</script>>

<template>
    <div class="FromAdminMessage-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetFromAdminMessageSingle :fromadminmessage="this.fromadminmessage" />

        
    </div>

</template>

<style scoped> 



</style>