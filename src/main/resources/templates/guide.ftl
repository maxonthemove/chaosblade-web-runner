<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="../static/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="../static/mystyle.css">
</head>
<body>
<div id="app">

    <el-container>
        <el-header>ChaosBlade 网页执行器</el-header>
        <el-main id="out">执行结果</el-main>
    </el-container>
    <form action="/shell/run" method="get">
        <el-row :gutter="20" style="margin-top: 50px" type="flex" justify="center">
            <el-col :span="12">
                <div class="grid-content bg-purple">
                    <el-input id="input-box" v-model="input" name="shell" placeholder="请输入内容"></el-input>
                </div>
            </el-col>
            <el-col :span="3">
                <div class="grid-content bg-purple-light">
                    <button style="border: none;background:white;margin-top: -2px" type="submit">
                        <el-button type="primary">提交</el-button>
                    </button>
                </div>
            </el-col>
        </el-row>
    </form>



</div>
</body>
<!-- import Vue before Element -->
<script src="../static/vue.js"></script>
<!-- import JavaScript -->
<script src="../static/element-ui/lib/index.js"></script>
<script>
    new Vue({
        el: '#app',
        data: function () {
            return {
                visible: false,
                input: ""
            }
        },
        mounted() {
            document.getElementById("input-box").focus();
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
        text-align: center;
        line-height: 160px;
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
</style>
</html>

