<!DOCTYPE html>
<html lang="en">
<head>
    <title>简单模式</title>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="../static/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="../static/mystyle.css">
</head>
<body>
<div id="app">
    <el-container>
        <el-header>ChaosBlade 网页执行器 简单模式</el-header>
        <el-main>
            <el-row type="flex" justify="center">
                <el-col :span="14">
                    <div class="grid-content">chaosblade首先需要与目标进程建立连接，请输入要建立连接的进程名：
                        <el-autocomplete
                                class="inline-input"
                                v-model="state1"
                                :fetch-suggestions="querySearch"
                                placeholder="例如 : SpringbootDemo.jar"
                                @select="handleSelect"
                                style="width: 500px"
                        ></el-autocomplete>
                    </div>
                </el-col>
            </el-row>

            <el-row type="flex" justify="center">
                <el-col :span="14">
                    <div class="grid-content">简单模式支持建立以下几种实验</div>
                </el-col>
            </el-row>
        </el-main>
    </el-container>
</div>
</body>

<!-- import Vue before Element -->
<script src="../static/vue.js"></script>
<!-- import JavaScript -->
<script src="../static/element-ui/lib/index.js"></script>
<#--import axios-->
<script src="../static/axios.js"></script>

<script>
    new Vue({
        el: '#app',
        data: function () {
            return {
                input: '',
                restaurants: [],
                state1: '',
            }
        },
        methods: {
            querySearch(queryString, cb) {
                var restaurants = this.restaurants;
                var results = queryString ? restaurants.filter(this.createFilter(queryString)) : restaurants;
                // 调用 callback 返回建议列表的数据
                cb(results);
            },
            createFilter(queryString) {
                return (restaurant) => {
                    return (restaurant.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
                };
            },
            loadAll() {
                return [
                    {"value": "springboot.jar", "address": ""},
                    {"value": "springboot.jar", "address": ""},
                    {"value": "springboot.jar", "address": ""},
                    {"value": "springboot.jar", "address": ""},
                    {"value": "springboot.jar", "address": ""},
                    {"value": "springboot.jar", "address": ""},
                    {"value": "springboot.jar", "address": ""}
                ];
            },
            handleSelect(item) {
                console.log(item);
            }
        },
        mounted() {
            this.restaurants = this.loadAll();
        }
    })
</script>
<style>
    .el-header, .el-footer {
        background-color: #B3C0D1;
        color: #333;
        text-align: center;
        line-height: 60px;
    }

    .el-aside {
        background-color: #D3DCE6;
        color: #333;
        text-align: center;
        line-height: 200px;
    }

    .el-main {
        background-color: #E9EEF3;
        color: #333;
        text-align: left;
        line-height: 40px;
    }

    body > .el-container {
        margin-bottom: 40px;
    }

    .el-container:nth-child(5) .el-aside,
    .el-container:nth-child(6) .el-aside {
        line-height: 260px;
    }

    .el-container:nth-child(7) .el-aside {
        line-height: 320px;
    }

    .el-row {
        margin-bottom: 20px;

    &
    :last-child {
        margin-bottom: 0;
    }

    }
    .el-col {
        border-radius: 4px;
    }

    .bg-purple-dark {
        background: #99a9bf;
    }

    .bg-purple {
        background: #d3dce6;
    }

    .grid-content {
        border-radius: 4px;
        min-height: 8px;
    }

    .el-row {
        margin-bottom: 20px;

    &
    :last-child {
        margin-bottom: 0;
    }

    }
    .el-col {
        border-radius: 4px;
    }

    .bg-purple-dark {
        background: #99a9bf;
    }

    .bg-purple {
        background: #d3dce6;
    }

    .bg-purple-light {
        background: #e5e9f2;
    }

    .my-autocomplete {

    li {
        line-height: normal;
        padding: 7px;

    .name {
        text-overflow: ellipsis;
        overflow: hidden;
    }

    .addr {
        font-size: 12px;
        color: #b4b4b4;
    }

    .highlighted .addr {
        color: #ddd;
    }

</style>
</html>