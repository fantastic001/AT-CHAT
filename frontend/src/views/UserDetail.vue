<script>

import UserService from "../widgets/User/service"

export default {
    name: "UserDetail",
    props: ["id"],
    data: function () {
            return {
		data: {},
		type: null,
		foreign_key: 0,
		role: localStorage.getItem("role"),
	    };
	},
    mounted: function () 
    {
    	
    },
    methods: {
        
    },
    components: {
    }
}
</script>

<template>
    <div class="User-detail"> 

    </div>

</template>

<style scoped> 



</style>
