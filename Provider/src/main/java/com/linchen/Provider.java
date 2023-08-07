package com.linchen;

import com.linchen.common.URL;
import com.linchen.protocol.HttpServer;
import com.linchen.register.LocalRegister;
import com.linchen.register.MapRemoteRegister;

/**
 * @Author 林晨
 * @Date 2023-08-06 10:48
 * @PackageName:com.linchen
 * @ClassName: Provider
 * @Description: TODO
 * @Version 1.0
 */
public class Provider {
    public static void main(String[] args) {
        //本地接口注册
        LocalRegister.register(HelloService.class.getName(),"1.0",HelloServiceImpl.class);
        LocalRegister.register(HelloService.class.getName(),"2.0",HelloServiceImpl2.class);

        //注册中心注册
        URL url = new URL("localhost",8080);
        MapRemoteRegister.register(HelloService.class.getName(),url);

        HttpServer httpServer = new HttpServer();
        httpServer.start("localhost",8080);
    }
}
