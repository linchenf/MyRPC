package com.linchen.loadBalance;

import com.linchen.common.URL;

import java.util.List;
import java.util.Random;

/**
 * @Author 林晨
 * @Date 2023-08-06 13:57
 * @PackageName:com.linchen.loadBalance
 * @ClassName: LoadBalance
 * @Description: 模拟负载均衡算法
 * @Version 1.0
 */
public class LoadBalance {
    public static URL random(List<URL> urlList){
        Random random = new Random();
        return urlList.get(random.nextInt(urlList.size()));
    }
}
