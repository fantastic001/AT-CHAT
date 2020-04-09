<script>


import WidgetUserMulti from "../widgets/User/WidgetUserMulti.vue"

import WidgetFromAdminMessageMulti from "../widgets/FromAdminMessage/WidgetFromAdminMessageMulti.vue"

import WidgetToAdminMessageMulti from "../widgets/ToAdminMessage/WidgetToAdminMessageMulti.vue"


import AdminService from "../widgets/Admin/service"
import WidgetAdminSingle from "../widgets/Admin/WidgetAdminSingle.vue"
import WidgetAdminSingleEdit from "../widgets/Admin/WidgetAdminSingleEdit.vue"
import WidgetAdminMulti from "../widgets/Admin/WidgetAdminMulti.vue"
import WidgetItemMulti from "../widgets/Item/WidgetItemMulti.vue";

import WidgetItemNew from "../widgets/Item/WidgetItemNew.vue";

export default {
    name: "Home",
    data: function () {
            return {
		data: {},
		role: "",
		search: false,
		create: false,
		search_data: {
			name_contains: "",
			description_contains: "",
			min_price: 0,
			max_price: 100000
		}
	    };
	},
    mounted: function () 
    {
    	this.role = localStorage.getItem("role");
    },
    methods: {
    	filter: function(item) {
		return item.name.includes(this.search_data.name_contains) && 
			item.description.includes(this.search_data.description_contains) &&
			item.price >= this.search_data.min_price && 
			item.price <= this.search_data.max_price;
	},
	submit_search: function() {
		this.$refs.items.reload();
	}
    },
    components: {
    	WidgetItemMulti,
	WidgetItemNew
        
    }
}
</script>

<template>
<div>

<button class="btn btn-primary" v-if="this.role == 'SELLER'" @click="create = !create">Create item</button>

<WidgetItemNew v-if="this.create" />


<button class="search-toggle btn btn-primary" @click="search = !search">Advanced Search</button>
<div v-if="this.search" class="search-part">


<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Name contains</span>
  </div>
  <input type="text" v-model="search_data.name_contains" class="form-control" placeholder="" aria-label="name" aria-describedby="basic-addon1">
</div>

<div class="input-group mb-3">
  <div class="input-group-prepend">
    <span class="input-group-text" id="basic-addon1">Description contains</span>
  </div>
  <input type="text" v-model="search_data.description_contains" class="form-control" placeholder="" aria-label="desc" aria-describedby="basic-addon1">
</div>

<div class="input-group">
  <div class="input-group-prepend">
    <span class="input-group-text">Price range</span>
  </div>
  <input type="number" aria-label="More than" class="form-control" v-model="search_data.min_price" />
  <input type="number" aria-label="Less than" class="form-control" v-model="search_data.max_price" />
</div>
<button class="btn btn-primary" @click="submit_search">Search</button>
</div>


<WidgetItemMulti :filter="this.filter" ref="items"/>
</div>
</template>

<style scoped> 

.search-toggle {
	margin: 10px;
}

.search-part {
	background-color: #ddd;
	padding: 10px;
	margin: 10px;
}

</style>
