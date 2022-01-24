<!--点击label标签组件
    props: content 文本内容
    methods: touchLb 点击事件
-->
<template>
    <label class="touchLabel" @click="touchLb">{{content}}</label>
</template>
<script>
    export default {
        props: {
            content: {
                type:String,
                default:""
            },
        },
        methods: {
            touchLb() {
                this.$emit("touchLb");
            }
        }
    }
</script>

<style>
    .touchLabel {
        cursor: pointer;
        color: white;
    }

    .touchLabel:hover {
        color: #ccd1d6
    }
</style>