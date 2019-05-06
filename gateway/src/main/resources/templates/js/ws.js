export let websocketServer = {
  url: '',
  lockReconnect: false,
  ws: null,
  type: null,
  cb: null,
  recived:false,
  createWebSocket() {
    try {
      if ('WebSocket' in window) {
        this.ws = new WebSocket(this.url);
      } else if ('MozWebSocket' in window) {
        this.ws = new WebSocket(this.url);
      } else {
        alert("您的浏览器不支持websocket协议,建议使用新版谷歌、火狐等浏览器，请勿使用IE10以下浏览器，360浏览器请使用极速模式，不要使用兼容模式！")
      }
      this.initEvent();
      //this.windowClose();
    } catch (err) {
      console.log(err);
      this.reconnect();
    }
  },
  initEvent() {
    this.ws.onopen = () => {
      this.heartCheck.reset(); //心跳检测重置
      this.heartCheck.start(this.ws,this.type); //心跳检测重置
      console.log("ws连接成功！" + new Date().format("yyyy-MM-dd hh:mm:ss"));
      //this.ws.send("carId=" + this.carId)
      //console.log(this.type);
      this.ws.send(JSON.stringify(this.type))
    };
    this.ws.onmessage = event => {
      this.heartCheck.reset();
      this.heartCheck.start(this.ws, this.type);
      //console.log(event);
      this.cb(event.data);
    };
    this.ws.onclose = () => {
      console.log("ws连接关闭！" + new Date().format("yyyy-MM-dd hh:mm:ss"));
      this.reconnect();
    };
    this.ws.onerror = () => {
      console.log("ws连接错误！" + new Date().format("yyyy-MM-dd hh:mm:ss"));
      this.reconnect();
    };
  },
  heartCheck: {
    timeout: 5000,
    timer: null,
    serverTimer: null,
    reset() {
      clearTimeout(this.timer);
      clearTimeout(this.serverTimer);
    },
    start(ws,type) {
      if (ws === null) {
        console.log("ws已关闭");
        return false;
      }
      this.timer = setTimeout(() => {
        //console.log(type);
        ws.send(JSON.stringify(type));
        /*this.serverTimer = setTimeout(() => {
          ws.close();
        }, this.timeout)*/
      }, this.timeout)
    }
  },
  reconnect() {
    if (this.lockReconnect) return;
    this.lockReconnect = true;
    setTimeout(() => {
      this.createWebSocket();
      this.lockReconnect = false;
    }, 2000)
  },
  windowClose() {
    window.onbeforeunload = () => {
      this.ws.close()
    };
  },
  handClose() {
    this.ws.close();
    this.lockReconnect = true;
  }
};

Date.prototype.format = function (fmt) {
  let o = {
    "M+": this.getMonth() + 1,                 //月份
    "d+": this.getDate(),                    //日
    "h+": this.getHours(),                   //小时
    "m+": this.getMinutes(),                 //分
    "s+": this.getSeconds(),                 //秒
    "q+": Math.floor((this.getMonth() + 3) / 3), //季度
    "S": this.getMilliseconds()             //毫秒
  };
  if (/(y+)/.test(fmt)) {
    fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for (let k in o) {
    if (new RegExp("(" + k + ")").test(fmt)) {
      fmt = fmt.replace(RegExp.$1, (RegExp.$1.length === 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    }
  }
  return fmt;
};
