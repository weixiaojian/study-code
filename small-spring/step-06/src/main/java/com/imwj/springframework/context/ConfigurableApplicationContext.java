package com.imwj.springframework.context;

import com.imwj.springframework.beans.BeansException;
import com.imwj.springframework.context.support.AbstractApplicationContext;

/**
 * 可配置应用上下文
 * @author wj
 * @create 2022-11-04 15:39
 */
public interface ConfigurableApplicationContext extends ApplicationContext {

    /**
     * 刷新容器
     *
     * @throws BeansException
     */
    void refresh() throws BeansException;

}
