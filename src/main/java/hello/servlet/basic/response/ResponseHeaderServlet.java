package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");
        PrintWriter writer = response.getWriter();
        writer.println("ok");

        content(response);
        cookie(response);

    }

    private static void cookie(HttpServletResponse response) {
        Cookie cookie = new Cookie("myCookie","good");
        cookie.setMaxAge(600);
        response.addCookie(cookie);
    }

    private static void content(HttpServletResponse response) {
//        response.setContentType("text/plain");
//        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
    }

}
