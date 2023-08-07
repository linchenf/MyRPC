package com.linchen.proxy;

import com.linchen.common.Invocation;
import com.linchen.common.URL;
import com.linchen.loadBalance.LoadBalance;
import com.linchen.protocol.HttpClient;
import com.linchen.register.MapRemoteRegister;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

/**
 * @Author 林晨
 * @Date 2023-08-06 13:26
 * @PackageName:com.linchen.proxy
 * @ClassName: ProxyFactory
 * @Description: TODO
 * @Version 1.0
 */
public class ProxyFactory {
    public static <T> T getProxy(Class interfaceClass){
        Object proxyInstance = Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //服务提供方尚未开发完成的处理：mock
                String mock = System.getProperty("mock");
                if(mock.startsWith("return")){
                    String result = mock.replaceAll("return:", "");
                    return result;
                }

                Invocation invocation = new Invocation(interfaceClass.getName(),
                        method.getName(), method.getParameterTypes(), args);
                HttpClient httpClient = new HttpClient();

                //服务发现，得到可能的多台服务提供方
                List<URL> urlList = MapRemoteRegister.get(interfaceClass.getName());
                //服务调用
                String result = null;
                //调用过程可能存在重试
                int max = 0;
                while(max!=3){
                    try{
                        //负载均衡
                        URL url = LoadBalance.random(urlList);
                        result = httpClient.send(url.getHostname(), url.getPort(), invocation);
                    }catch (Exception e){
                        //重试
                        if(max++ !=3){
                            System.out.println("第"+max+"次调用失败");
                            continue;
                        }
                        System.out.println("服务调用过程失败");
                    }
                }
                return result;
            }
        });
        return (T) proxyInstance;
    }
}
