package com.imwj.springframework.beans;

/**
 * bean异常处理类
 * @author wj
 * @create 2022-10-09 17:42
 */
public class BeansException extends RuntimeException {
    public BeansException(String msg, Exception e) {
        System.out.println(msg + "，e:" + e);
    }

    public BeansException(String msg) {
        System.out.println(msg);
    }
}
