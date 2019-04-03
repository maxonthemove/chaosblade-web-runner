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
        <el-row type="flex" justify="center">
            <el-popover
                    placement="bottom"
                    width="600"
                    trigger="click">
                <div style="height: 600px;overflow-x: scroll"> ${history}</div>
                <el-button slot="reference" type="success">History</el-button>
            </el-popover>
            <el-popover
                    placement="bottom"
                    width="600"
                    trigger="click"
                    style="margin-left: 50px">
                <div style="height: 600px;overflow-x: scroll"> ${example}</div>
                <el-button slot="reference" type="warning">Example</el-button>
            </el-popover>
        </el-row>
        <el-main id="out">
            <div class="line">输入的shell命令： <span id="shell">${shell}<span></div>
            <div class="line">执行结果：</div>
            <#list messageList as item>
                <el-row :gutter="20">
                    <el-col :span="14" :offset="6">
                        <div class="grid-content bg-purple" style="text-align: left">${item}</div>
                    </el-col>
                </el-row>
            </#list>
        </el-main>
    </el-container>

    <form action="/shell/run" method="get">


        <el-row :gutter="20" style="margin-top: 50px" type="flex" justify="center">
            <el-col :span="12">
                <div class="grid-content bg-purple">
                    <el-input id="input-box" v-model="input" name="shell" v-on:keyup.up.native="lastShell"
                              v-on:keyup.down.native="nextShell"
                              placeholder="请输入shell命令"></el-input>
                </div>
            </el-col>
            <el-col :span="3">
                <div class="grid-content bg-purple">
                    <button style="border: none;background:white;margin-top: -2px" type="submit">
                        <el-button type="primary">执行</el-button>
                    </button>
                </div>
            </el-col>
            <div style="font-size: 20px;margin-top: 3px">帮助 --help</div>
        </el-row>
    </form>
    <div v-for="(item,index) in commandObjectList">
        <el-row style="margin-top: 20px" type="flex" justify="left">
            <el-col :span="5">
                <div class="grid-content bg-purple"></div>
            </el-col>

            <el-col :span="3">
                <div class="grid-content bg-purple">
                    <el-button type="primary" @click=commandClicked(item.key)
                               style="width: 100px;font-size: 20px">
                        {{item.key}}
                    </el-button>
                </div>
            </el-col>
            <el-col :span="8">
                <div class="grid-content bg-purple-light">
                    {{item.desc}}
                </div>
            </el-col>
        </el-row>
    </div>
    <div id="commandCollection" hidden> ${commandList}</div>
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
                visible: false,
                input: "",
                commandObjectList: [],
                shellList: [],
                shellOffset: 0
            }
        },
        mounted() {
            document.getElementById("input-box").focus();
            let shell = document.getElementById("shell").innerText;
            if (shell) {
                this.input = shell + " ";
            } else {
                this.input = 'blade ';
            }
            let commandCollection = document.getElementById("commandCollection").innerText;
            this.commandObjectList = JSON.parse(commandCollection);
            if (this.commandObjectList.length === 0 && this.input.indexOf('help') === -1 && this.input.indexOf('blade') > -1) {
                this.input = this.input + '--help ';
            }
            var _this = this;
            axios.get('/getShellList')
                .then(function (response) {
                    // console.log(response);
                    // console.log(response.data);
                    _this.shellList = response.data

                })
                .catch((error) => {
                    // console.log(error);
                });
        },
        methods: {
            commandClicked(key) {
                this.input = this.input + key + " ";
                var _this = this;
                axios.get('/getCommand?shell=' + _this.input)
                    .then(function (response) {
                        // console.log(response);
                        // console.log(response.data);
                        _this.commandObjectList = response.data
                        if (_this.commandObjectList.length === 0 && _this.input.indexOf('help') === -1 && this.input.indexOf('blade') > -1) {
                            _this.input = _this.input + '--help ';
                        }
                    })
                    .catch((error) => {
                        // console.log(error);
                    });
                // console.log("key:" + key);
                document.getElementById("input-box").focus();
            },
            lastShell() {
                // console.log(this.shellList)
                this.input = this.shellList[this.shellList.length - 1 - this.shellOffset]
                if (this.shellOffset < this.shellList.length - 1) {
                    this.shellOffset += 1
                }
            },
            nextShell() {
                // console.log("next")
                this.input = this.shellList[this.shellList.length - 1 - this.shellOffset]
                if (this.shellOffset > 0) {
                    this.shellOffset -= 1
                }
            }
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

    .bg-purple-light {
        /*margin-top: 8px;*/
        font-size: 23px;
    }

</style>
</html>

