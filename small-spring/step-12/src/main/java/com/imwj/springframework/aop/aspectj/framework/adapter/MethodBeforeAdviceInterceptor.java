package com.imwj.springframework.aop.aspectj.framework.adapter;

import com.imwj.springframework.aop.MethodAfterAdvice;
import com.imwj.springframework.aop.MethodBeforeAdvice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 方法Before处理拦截器
 * @author wj
 * @create 2022-12-07 11:18
 */
public class MethodBeforeAdviceInterceptor implements MethodInterceptor {

    /**
     * 方法Before处理
     */
    private MethodBeforeAdvice beforeAdvice;
    private MethodAfterAdvice afterAdvice;

    public MethodBeforeAdviceInterceptor() {
    }

    public MethodBeforeAdviceInterceptor(MethodBeforeAdvice beforeAdvice, MethodAfterAdvice afterAdvice){
        this.beforeAdvice = beforeAdvice;
        this.afterAdvice = afterAdvice;
    }

    /**
     * 拦截后的处理方法
     * @param methodInvocation the method invocation joinpoint
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        // 执行方法before的处理
        this.beforeAdvice.before(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        // 执行真正的业务方法
        Object result = methodInvocation.proceed();
        // 执行方法的after的处理
        this.afterAdvice.after(methodInvocation.getMethod(), methodInvocation.getArguments(), methodInvocation.getThis());
        return result;
    }

    public MethodBeforeAdvice getBeforeAdvice() {
        return beforeAdvice;
    }

    public void setBeforeAdvice(MethodBeforeAdvice beforeAdvice) {
        this.beforeAdvice = beforeAdvice;
    }

    public MethodAfterAdvice getAfterAdvice() {
        return afterAdvice;
    }

    public void setAfterAdvice(MethodAfterAdvice afterAdvice) {
        this.afterAdvice = afterAdvice;
    }
}
