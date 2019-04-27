window.app={
    /**
     * netty服务后端发布的url地址
     */
    nettyServerUrl: 'ws://localhost:8088/ws',


    /**
     * 后端服务发布的url地址
     */
    //serverUrl: 'http://120.76.196.44:7000',
    serverUrl: '',


    /**
     * 图片服务器的url地址
     */
   // imgServerUrl: 'http://39.108.181.16:88/group1/',

    /**
     * 判断字符串是否为空
     * @param {Object} str
     * true：不为空
     * false：为空
     */
    isNotNull: function(str) {
        if (str != null && str != "" && str != undefined) {
            return true;
        }
        return false;
    },

    /**
     * 和后端的枚举对应
     */
    CONNECT:1,//第一次(或重连)初始化连接
    KEEPALIVE:2,//客户端保持心跳
    DISCONNECT:3,//断开连接
    GETCARLIST:4,//获取车辆列表
    GETCARSTATE:5,//获取车辆状态
    GETLASTPOSITION:6,//获取车辆的最新位置


    /**
     * 和后端的 Content 发送内容模型对象保持一致
     * @param {Object} carId
     * @param {Object} comId
     * @param {Object} msg
     */
    Content: function(carId, comId, msg){
        this.carId = carId;
        this.comId = comId;
        this.msg = msg;
    },

    /**
     * 构建消息 DataContent 模型对象
     * @param {Object} action
     * @param {Object} content
     * @param {Object} extend
     */
    DataContent: function(action, content, extend){
        this.action = action;
        this.content = content;
        this.extend = extend;
    }

}