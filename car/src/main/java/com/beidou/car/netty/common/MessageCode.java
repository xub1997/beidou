package com.beidou.car.netty.common;

public class MessageCode {
    //1.终端通用应答
    public static final int 终端通用应答 = 0x0001;
    //2.平台通用应答
    public static final int 平台通用应答 = 0x8001;
    //3.终端心跳
    public static final int 终端心跳 = 0x0002;
    //4.补传分包请求
    public static final int 补传分包请求 = 0x8003;
    //5.终端注册
    public static final int 终端注册 = 0x0100;
    //6.终端注册应答
    public static final int 终端注册应答 = 0x8100;
    //7.终端注销
    public static final int 终端注销 = 0x0003;
    //8.终端鉴权
    public static final int 终端鉴权 = 0x0102;
    //9.设置终端参数
    public static final int 设置终端参数 = 0x8103;
    //10.查询终端参数
    public static final int 查询终端参数 = 0x8104;
    //11.查询终端参数应答
    public static final int 查询终端参数应答 = 0x0104;
    //12.终端控制
    public static final int 终端控制 = 0x8105;
    //13.查询指定终端参数
    public static final int 查询指定终端参数 = 0x8106;
    //14.查询终端属性
    public static final int 查询终端属性 = 0x8107;
    //15.查询终端属性应答
    public static final int 查询终端属性应答 = 0x0107;
    //16.下发终端升级包
    public static final int 下发终端升级包 = 0x8108;
    //17.终端升级结果通知
    public static final int 终端升级结果通知 = 0x0108;
    //18.位置信息汇报
    public static final int 位置信息汇报 = 0x0200;
    //19.位置信息查询
    public static final int 位置信息查询 = 0x8201;
    //20.位置信息查询应答
    public static final int 位置信息查询应答 = 0x0201;
    //21.临时位置跟踪控制
    public static final int 临时位置跟踪控制 = 0x8202;
    //22.人工确认报警消息
    public static final int 人工确认报警消息 = 0x8203;
    //23.文本信息下发
    public static final int 文本信息下发 = 0x8300;
    //24.事件设置
    public static final int 事件设置 = 0x8301;
    //25.事件报告
    public static final int 事件报告 = 0x0301;
    //26.提问下发
    public static final int 提问下发 = 0x8302;
    //27.提问应答
    public static final int 提问应答 = 0x0302;
    //28.信息点播菜单设置
    public static final int 信息点播菜单设置 = 0x8303;
    //29.信息点播取消
    public static final int 信息点播取消 = 0x0303;
    //30.信息服务
    public static final int 信息服务 = 0x8304;
    //31.电话回拨
    public static final int 电话回拨 = 0x8400;
    //32.设置电话本
    public static final int 设置电话本 = 0x8401;
    //33.车辆控制
    public static final int 车辆控制 = 0x8500;
    //34.车辆控制应答
    public static final int 车辆控制应答 = 0x0500;
    //35.设置圆形区域
    public static final int 设置圆形区域 = 0x8600;
    //36.删除圆形区域
    public static final int 删除圆形区域 = 0x8601;
    //37.设置矩形区域
    public static final int 设置矩形区域 = 0x8602;
    //38.删除矩形区域
    public static final int 删除矩形区域 = 0x8603;
    //39.设置多边形区域
    public static final int 设置多边形区域 = 0x8604;
    //40.删除多边形区域
    public static final int 删除多边形区域 = 0x8605;
    //41.设置路线
    public static final int 设置路线 = 0x8606;
    //42.删除路线
    public static final int 删除路线 = 0x8607;
    //43.行驶记录仪数据采集命令
    public static final int 行驶记录仪数据采集命令 = 0x8700;
    //44.行驶记录仪数据上传
    public static final int 行驶记录仪数据上传 = 0x0700;
    //45.行驶记录仪参数下传命令
    public static final int 行驶记录仪参数下传命令 = 0x8701;
    //46.电子运单上报
    public static final int 电子运单上报 = 0x0701;
    //47.驾驶员身份信息采集上报
    public static final int 驾驶员身份信息采集上报 = 0x0702;
    //48.上报驾驶员身份信息请求
    public static final int 上报驾驶员身份信息请求 = 0x8702;
    //49.定位数据批量上传
    public static final int 定位数据批量上传 = 0x0704;
    //50.CAN总线数据上传
    public static final int CAN总线数据上传 = 0x0705;
    //51.多媒体事件信息上传
    public static final int 多媒体事件信息上传 = 0x0800;
    //52.多媒体数据上传
    public static final int 多媒体数据上传 = 0x0801;
    //53.多媒体数据上传应答
    public static final int 多媒体数据上传应答 = 0x8800;
    //54.摄像头立即拍摄命令
    public static final int 摄像头立即拍摄命令 = 0x8801;
    //55.摄像头立即拍摄命令应答
    public static final int 摄像头立即拍摄命令应答 = 0x0805;
    //56.存储多媒体数据检索
    public static final int 存储多媒体数据检索 = 0x8802;
    //57.存储多媒体数据检索应答
    public static final int 存储多媒体数据检索应答 = 0x0802;
    //58.存储多媒体数据上传命令
    public static final int 存储多媒体数据上传命令 = 0x8803;
    //59.录音开始命令
    public static final int 录音开始命令 = 0x8804;
    //60.单条存储多媒体数据检索上传命令
    public static final int 单条存储多媒体数据检索上传命令 = 0x8805;
    //61.数据下行透传
    public static final int 数据下行透传 = 0x8900;
    //62.数据上行透传
    public static final int 数据上行透传 = 0x0900;
    //63.数据压缩上报
    public static final int 数据压缩上报 = 0x0901;
    //64.平台RSA公钥
    public static final int 平台RSA公钥 = 0x8A00;
    //65.终端RSA公钥
    public static final int 终端RSA公钥 = 0x0A00;
    //66.平台下行消息保留
    public static final int 平台下行消息保留 = 0x8F00 - 0x8FFF;
    //67.终端上行消息保留
    public static final int 终端上行消息保留 = 0x0F00 - 0x0FFF;
}
