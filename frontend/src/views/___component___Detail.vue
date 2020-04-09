<script>

{% for dependency in dependencies %}
import Widget{{ dependency[0].upper() + dependency[1:] }}Multi from "../widgets/{{  dependency[0].upper() + dependency[1:] }}/Widget{{ dependency[0].upper() + dependency[1:] }}Multi.vue"
{% endfor %}

import {{name }}Service from "../widgets/{{ name }}/service"
import Widget{{ name }}Single from "../widgets/{{  name }}/Widget{{ name }}Single.vue"
import Widget{{ name }}SingleEdit from "../widgets/{{  name }}/Widget{{ name }}SingleEdit.vue"
import Widget{{ name }}Multi from "../widgets/{{  name }}/Widget{{ name }}Multi.vue"
import Widget{{ name }}New from "../widgets/{{  name }}/Widget{{ name }}New.vue"


export default {
    name: "{{ name }}Detail",
    props: ["{{ name | lower}}"],
    data: function () {
            return {
		data: {}
	    };
	},
    mounted: function () 
    {
    	{{name}}Service.get(this.{{ name | lower}}).then(response => this.data = response.data)
    },
    methods: {
        itemDelete: function (event) 
        {
            {{name}}Service.delete(this.{{ name | lower}}).then(response => 
            {
                if (response.status < 400) 
                {
                    alert("{{name}} item is deleted");
                }
            })
        }
    },
    components: {
        {% for dependency in dependencies%}
        "Widget{{ dependency[0].upper() + dependency[1:] }}Multi": Widget{{ dependency[0].upper() + dependency[1:] }}Multi,
        {% endfor %}
        "Widget{{ name }}Single": Widget{{ name }}Single,
        "Widget{{ name }}New": Widget{{ name }}New,
        "Widget{{ name }}SingleEdit": Widget{{ name }}SingleEdit,
        "Widget{{ name }}Multi": Widget{{ name }}Multi
    }
}
</script>>

<template>
    <div class="{{ name }}-detail"> 
        <button v-on:click="itemDelete">Delete</button>
        <Widget{{ name }}Single :{{ name | lower}}="this.{{ name | lower}}" />

        {% for dependency in dependencies%}
        <Widget{{ dependency[0].upper() + dependency[1:] }}Multi :filter="x => x.{{ name[0].lower() + name[1:] }} == this.{{ name | lower}}"/>
        
        {% endfor %}
    </div>

</template>

<style scoped> 



</style>
