package com.beidou.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.lang.reflect.Array;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

public class StringUtil {

    /**
     * 判断对象是否为空<br>
     * 1,字符串(null或者"")都返回true<br>
     * 2,数字类型(null或者0)都返回true<br>
     * 3,集合类型(null或者不包含元素都返回true)<br>
     * 4,数组类型不包含元素返回true(包含null元素返回false)<br>
     * 5,其他对象仅null返回true
     *
     * @param obj
     * @return
     */
     public static boolean isEmpty(Object obj) {
         if (obj == null) {
             return true;
         }
         if (obj instanceof Number) {
             Number num = (Number) obj;
             if (num.intValue() == 0) {
                 return true;
             } else {
                 return false;
             }
         } else if (obj instanceof String) {
             String str = (String) obj;
             if ((str == null) || str.equals("")) {
                 return true;
             } else {
                 return false;
             }
         } else if (obj instanceof Collection<?>) {
             Collection<?> c = (Collection<?>) obj;
             return c.isEmpty();
         } else if (obj instanceof Map<?, ?>) {
             Map<?, ?> m = (Map<?, ?>) obj;
             return m.isEmpty();
         } else if (obj.getClass().isArray()) {
             int length = Array.getLength(obj);
             return length == 0 ? true : false;
         } else {
             return false;
         }
     }

    /**
     * 将DATE转换为String类型 format "yyyy-MM-dd"
     *
     * @param date
     * @return
     */
    public static String dateToString(Date date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String s = "";
        if (date != null) {
            s = format.format(date);
        }
        return s;
    }

    /**
     * 将字符串进行MD5加密
     *
     * @param key
     * @return
     */
    public static String encryptByMD5(String key) {
        char hexDigits[] = {
                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
        };
        try {
            byte[] btInput = key.getBytes();
            // 获得MD5摘要算法的 MessageDigest 对象
            MessageDigest mdInst = MessageDigest.getInstance("MD5");
            // 使用指定的字节更新摘要
            mdInst.update(btInput);
            // 获得密文
            byte[] md = mdInst.digest();
            // 把密文转换成十六进制的字符串形式
            int j = md.length;
            char str[] = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = md[i];
                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
                str[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(str);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符编码自定义转换类型
     *
     * @param str
     * @param oldEncode
     * @param newEncode
     * @return
     */
    public static String convertEncode(String str, String oldEncode, String newEncode) {
        if (str == null) {
            return str;
        } else {
            try {
                return new String(str.getBytes(oldEncode), newEncode);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
    }


    /**
     * BASE64解密(三次)
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptByBASE64(String key) throws Exception {
        return new String(new BASE64Decoder().decodeBuffer(new String(new BASE64Decoder().decodeBuffer(new String((new BASE64Decoder()).decodeBuffer(key))))));
    }

    /**
     * BASE64加密
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static String encryptByBASE64(String key) throws Exception {
        return new BASE64Encoder().encode(new BASE64Encoder().encode((new BASE64Encoder()).encodeBuffer(key.getBytes()).getBytes()).getBytes());
    }




}
