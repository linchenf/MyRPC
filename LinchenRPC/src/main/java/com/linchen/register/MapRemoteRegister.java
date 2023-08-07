package com.linchen.register;

import com.linchen.common.URL;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author 林晨
 * @Date 2023-08-06 13:38
 * @PackageName:com.linchen.register
 * @ClassName: MapRemoteRegister
 * @Description: TODO
 * @Version 1.0
 */
public class MapRemoteRegister {
    //接口名字映射实现类
    private static Map<String, List<URL>> map = new HashMap<>();

    //注册接口实现类
    public static void register(String interfaceName,URL url){
        List<URL> urls = map.get(interfaceName);
        if(urls==null){
            urls=new ArrayList<>();
        }
        urls.add(url);
        map.put(interfaceName,urls);
        saveFile();
    }

    public static List<URL> get(String interfaceName){
        map=getFile();
        return map.get(interfaceName);
    }

    private static void saveFile(){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp.txt"));
            oos.writeObject(map);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Map<String, List<URL>> getFile(){
        try {
            Map<String, List<URL>> map2 = null;
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp.txt"));
            map2 = (Map<String, List<URL>>) ois.readObject();
            return map2;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
