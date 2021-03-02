package com.jinshengcong.dp.cor;

import java.util.ArrayList;
import java.util.List;

/**
 * 责任链
 *
 * @author 金聖聰
 * @version v1.0
 * @email jinshengcong@163.com
 */
public class Main {
    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("大家好:),<scrip>,欢迎访问: baidu.com,大家都是996,996,:)");
        // 责任链 把过了器放到list中去
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter())
                .add(new SensitiveFilter());

        FilterChain filterChain1 = new FilterChain();
        filterChain1.add(new FaceFilter());

        filterChain.add(filterChain1);

        filterChain.doFilter(msg);
        System.out.println(msg.toString());
    }
}

class Msg {
    String name;
    String msg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }

}

interface Filter {
    boolean doFilter(Msg msg);
}

class HtmlFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("<", "[");
        r = r.replaceAll(">", "]");
        msg.setMsg(r);
        return true;
    }
}

class SensitiveFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll("996", "***");
        msg.setMsg(r);
        return false;
    }
}

class FaceFilter implements Filter {
    @Override
    public boolean doFilter(Msg msg) {
        String r = msg.getMsg();
        r = r.replaceAll(":\\)", ":(");
        msg.setMsg(r);
        return true;
    }
}

// 实现filter接口 为了自己类型加自己类型
class FilterChain implements Filter {
    List<Filter> filters = new ArrayList<>();

    // 小技巧: 返回本身,方便 链式编程
    public FilterChain add(Filter filter) {
        filters.add(filter);
        return this;
    }

    public boolean doFilter(Msg msg) {
        for (Filter filter : filters) {
            // 只要有一个是false,就返回false
            if (!filter.doFilter(msg)) {
                return false;
            }
        }
        return true;
    }
}