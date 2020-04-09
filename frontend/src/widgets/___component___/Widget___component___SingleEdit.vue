<script>
import {{ component }}Service from "./service";

export default {
    name: "Widget{{ component }}SingleEdit",
    props: ["{{ component | lower}}"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        {{ component }}Service.get(this.{{ component | lower}}).then(response => this.data = response);
    }
}
</script>

<template>
    <div class="widget-{{ component | lower}}-single-edit"> 
        
    </div>

</template>

<style scoped> 

</style>