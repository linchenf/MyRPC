package com.linchen;

import com.linchen.common.Invocation;
import com.linchen.protocol.HttpClient;
import com.linchen.proxy.ProxyFactory;

/**
 * @Author 林晨
 * @Date 2023-08-06 11:49
 * @PackageName:com.linchen
 * @ClassName: Consumer
 * @Description: TODO
 * @Version 1.0
 */
public class Consumer {
    public static void main(String[] args) {
        HelloService helloService = ProxyFactory.getProxy(HelloService.class);
        String result2 = helloService.sayHello("linchen2");
        System.out.println(result2);
    }
}
