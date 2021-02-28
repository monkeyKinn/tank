package com.jinshengcong.tank;

import java.io.IOException;
import java.util.Properties;

/**
 * 配置文件管理类
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class PropertyMgr {
    static Properties props = new Properties();;
    static {
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object getValue(String key){
        if (props == null) {
            return "";
        }
        return props.get(key);
    }
}
