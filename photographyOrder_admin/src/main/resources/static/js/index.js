
var vue = new Vue({
    el: '#app',
    data: {
        timeList:[],
        pickTime:[],
        order:{},
        disabledFlag:false
    },
    methods: {
        allTime: function () {
            axios.get('/admin/allTime').then(function (response) {
                vue.timeList = response.data;
            })
        },

        chooseTime: function (time) {
            vue.pickTime = time;
            vue.order.tId = time.id;
        },

        submit: function () {
            if (vue.order.name == null) {
                alert("请输入您的姓名");
                return;
            }
            if (vue.order.mobilePhone == null) {
                alert("请输入您的联系电话");
                return;
            }
            if (vue.order.photoObj == null) {
                alert("请输入拍照对象");
                return;
            }
            //修改按钮为不可点击状态，防止表单重复提交
            vue.disabledFlag = true;

            axios.post('/admin/saveOrder',vue.order).then(function (response) {
                alert(response.data.message);
                if (response.data.success){
                    location = "index.html";
                }
            })
        }
    },
    created: function () {
        this.allTime();
    }
})
