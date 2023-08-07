package com.linchen.common;

import java.io.Serializable;

/**
 * @Author 林晨
 * @Date 2023-08-06 13:36
 * @PackageName:com.linchen.common
 * @ClassName: URL
 * @Description: TODO
 * @Version 1.0
 */
public class URL implements Serializable {
    private String hostname;
    private Integer port;

    public URL() {
    }

    public URL(String hostname, Integer port) {
        this.hostname = hostname;
        this.port = port;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }
}
