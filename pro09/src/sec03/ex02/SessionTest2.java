package sec03.ex02;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/sess2")
public class SessionTest2 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        out.println("세션 아이디: " + session.getId() + "<br>");
        out.println("최초 세션 생성 시각: " + new Date(session.getCreationTime()) + "<br>");
        out.println("최근 세션 접근 시각: " + new Date(session.getLastAccessedTime()) + "<br>");
        session.setMaxInactiveInterval(5);      //세션의 유효시간을 5초로 설정
        out.println("세션 유효 시간: " + session.getMaxInactiveInterval() + "<br>");
        if(session.isNew()) {
            out.println("새 세션이 생성되었습니다.");
        }
    }
}
