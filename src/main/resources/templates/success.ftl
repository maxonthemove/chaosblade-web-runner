<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="https://unpkg.com/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="../static/mystyle.css">
</head>
<body>
<div id="app">

    <el-container>
        <el-header>ChaosBlade 网页执行器</el-header>
        <el-main id="out">
            <div class="line">输入的shell命令： ${shell}</div>
            <div class="line">执行结果：</div>
            <#list messageList as item>
                <div class="line">${item}</div>
            </#list>
        </el-main>
    </el-container>
    <form action="/shell/run" method="get">
        <el-row :gutter="20" style="margin-top: 50px" type="flex" justify="center">
            <el-col :span="12">
                <div class="grid-content bg-purple">
                    <el-input v-model="input" name="shell" placeholder="请输入shell命令"></el-input>
                </div>
            </el-col>
            <el-col :span="3">
                <div class="grid-content bg-purple-light">
                    <button style="border: none;background:white;margin-top: -2px" type="submit">
                        <el-button type="primary">提交</el-button>
                    </button>
                </div>
            </el-col>
    </form>
    </el-row>


</div>
</body>
<!-- import Vue before Element -->
<script src="https://unpkg.com/vue/dist/vue.js"></script>
<!-- import JavaScript -->
<script src="https://unpkg.com/element-ui/lib/index.js"></script>
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
            // alert("sss");
        }
    })
</script>
<style>
    .line {
        /*height: 20px;*/
    }

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
        line-height: 30px;
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

