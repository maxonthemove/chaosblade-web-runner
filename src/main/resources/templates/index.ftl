<!DOCTYPE html>
<html lang="en">
<head>
    <title>chaosblade执行器</title>
    <meta charset="UTF-8">
    <!-- import CSS -->
    <link rel="stylesheet" href="../static/element-ui/lib/theme-chalk/index.css">
    <link rel="stylesheet" href="../static/mystyle.css">
</head>
<body>
<div id="app">
    <el-container>
        <el-header>ChaosBlade 网页执行器</el-header>

        <el-main>
            <el-row type="flex" class="row-bg" justify="center" style="margin-top: 10px" :gutter="10">
                <el-col :span="2">
                    <div class="grid-content">
                        <el-button type="primary" @click.native="jump('command')">命令模式</el-button>
                    </div>
                </el-col>
                <el-col :span="8">
                    <div class="grid-content">
                        需要输入chaosblade具体命令
                    </div>
                </el-col>
            </el-row>
            <el-row type="flex" class="row-bg" justify="center" style="margin-top: 10px" :gutter="20">
                <el-col :span="2">
                    <div class="grid-content">
                        <el-button type="success" @click.native="jump('easy')">简单模式</el-button>
                    </div>
                </el-col>
                <el-col :span="8">
                    <div class="grid-content">
                        通过预设的操作使用chaosblade，只需要输入一些必要的参数。（未完成）
                    </div>
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
            return {}
        },
        methods: {
            jump(url) {
                window.location.href = url;
            }
        }
    })
</script>
<style>
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

    .grid-content {
        border-radius: 4px;
        min-height: 36px;
        text-align: left;
    }

    .row-bg {
        padding: 10px 0;
        /*background-color: #f9fafc;*/
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