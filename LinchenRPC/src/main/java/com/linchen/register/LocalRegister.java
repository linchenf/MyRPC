package com.linchen.register;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author 林晨
 * @Date 2023-08-06 11:25
 * @PackageName:com.linchen.register
 * @ClassName: LocalRegister
 * @Description: TODO
 * @Version 1.0
 */
public class LocalRegister {
    //接口名字映射实现类
    private static Map<String,Class> map = new HashMap<>();

    //注册接口实现类
    public static void register(String interfaceName,String version,Class implClass){
        map.put(interfaceName+version,implClass);
    }

    public static Class get(String interfaceName,String version){
        return map.get(interfaceName+version);
    }
}
