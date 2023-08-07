package com.linchen.protocol;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author 林晨
 * @Date 2023-08-06 11:11
 * @PackageName:com.linchen.protocol
 * @ClassName: DispatcherServlet
 * @Description: TODO
 * @Version 1.0
 */
public class DispatcherServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new HttpServerHandler().handler(req,resp);
    }

}
