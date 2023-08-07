package com.linchen.protocol;

import com.linchen.common.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @Author 林晨
 * @Date 2023-08-06 11:57
 * @PackageName:com.linchen.protocol
 * @ClassName: HttpClient
 * @Description: TODO
 * @Version 1.0
 */
public class HttpClient {
    public String send(String hostname, Integer port, Invocation invocation) throws Exception{

        URL url = new URL("http",hostname,port,"/");
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setDoOutput(true);

        //配置
        OutputStream outputStream = httpURLConnection.getOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        oos.writeObject(invocation);
        oos.flush();
        oos.close();

        InputStream inputStream = httpURLConnection.getInputStream();
        String result = IOUtils.toString(inputStream);
        return result;
    }
}














