package sec02.ex01;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Date;

@WebServlet("/set")
public class SetCookieValue extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        Date d = new Date();

        //쿠키 객체를 생성한 후 cookieTest 이름으로 한글 정보를 인코딩해서 쿠키에 저장한다.
        Cookie c = new Cookie("cookieTest", URLEncoder.encode("JSP Progroamming", "utf-8"));

        //c.setMaxAge(24*60*60); // 유효 기간을 1일로 설정한다. - Persistence Cookie
        c.setMaxAge(-1);        // 유효 시간을 음수로 지정한다. - Session Cookie

        response.addCookie(c); //생성된 쿠키를 브라우저로 전송한다.

        out.println("현재 시간 : " + d);
        out.println("문자열을 Cookie에 저장한다.");
    }
}
