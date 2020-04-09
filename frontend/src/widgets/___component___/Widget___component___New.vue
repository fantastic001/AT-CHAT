<script>
import {{ component }}Service from "./service";

export default {
    name: "Widget{{ component }}New",
    data: function () {
        return {
            data: {}
        };
    },
}
</script>

<template>
    <div class="widget-{{ component | lower}}-new"> 
        
    </div>

</template>

<style scoped> 



</style>