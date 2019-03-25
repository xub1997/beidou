window.app={
    /**
     * netty服务后端发布的url地址
     */
    //nettyServerUrl: 'ws://120.76.196.44:8088/ws',


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
}