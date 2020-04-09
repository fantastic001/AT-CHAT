<script>
import {{ component }}Service from "./service";

export default {
    name: "Widget{{ component }}Single",
    props: ["{{ component | lower}}"],
    data: function () {
        return {
            data: {}
        }
    },
    mounted: function () 
    {
        {{ component }}Service.get(this.{{component | lower}}).then(response => this.data = response.data);
    }
}
</script>

<template>
    <div class="widget-{{component | lower}}-single"> 
    </div>

</template>

<style scoped> 



</style>
