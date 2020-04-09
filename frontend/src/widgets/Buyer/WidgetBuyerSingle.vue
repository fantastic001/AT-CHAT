<script>
import BuyerService from "./service";
import UserService from "../User/service";
export default {
    name: "WidgetBuyerSingle",
    props: ["buyer"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        BuyerService.get(this.buyer).then(response => {
		this.data = response.data;
		UserService.get(this.data.user).then(response => this.data = response.data)
	});
    }
}
</script>

<template>
    <div class="widget-buyer-single"> 
    <span class="badge badge-pill badge-warning">Buyer</span>
    <div class="card" style="width: 18rem;">
        <div class="card-body">
            <h5 class="card-title">{{ data.firstname }} {{ data.lastname }}</h5>
            <h6 class="card-subtitle mb-2 text-muted">{{ data.email }}</h6>
            <p class="card-text">{{ data.phone }} - joined on {{data.registrationDate }}</p>
        </div>
    </div>
    </div>

</template>

<style scoped> 



</style>
