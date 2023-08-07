package com.linchen;

/**
 * @Author 林晨
 * @Date 2023-08-06 10:48
 * @PackageName:com.linchen
 * @ClassName: HelloServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
public class HelloServiceImpl implements HelloService{
    @Override
    public String sayHello(String name) {
        return "Hello: "+name;
    }
}
