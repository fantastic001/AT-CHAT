<script>



import ToAdminMessageService from "../widgets/ToAdminMessage/service"
import WidgetToAdminMessageSingle from "../widgets/ToAdminMessage/WidgetToAdminMessageSingle.vue"
import WidgetToAdminMessageSingleEdit from "../widgets/ToAdminMessage/WidgetToAdminMessageSingleEdit.vue"
import WidgetToAdminMessageMulti from "../widgets/ToAdminMessage/WidgetToAdminMessageMulti.vue"
import WidgetToAdminMessageNew from "../widgets/ToAdminMessage/WidgetToAdminMessageNew.vue"


export default {
    name: "ToAdminMessageDetail",
    props: ["toadminmessage"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	ToAdminMessageService.get(this.toadminmessage).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            ToAdminMessageService.delete(this.toadminmessage).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("ToAdminMessage item is deleted");
                }
            })
        }
    },
    components: {
        
        "WidgetToAdminMessageSingle": WidgetToAdminMessageSingle,
        "WidgetToAdminMessageNew": WidgetToAdminMessageNew,
        "WidgetToAdminMessageSingleEdit": WidgetToAdminMessageSingleEdit,
        "WidgetToAdminMessageMulti": WidgetToAdminMessageMulti
    }
}
</script>>

<template>
    <div class="ToAdminMessage-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <WidgetToAdminMessageSingle :toadminmessage="this.toadminmessage" />

        
    </div>

</template>

<style scoped> 



</style>