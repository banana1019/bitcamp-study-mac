package com.eomcs.mylist.controller.board;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.domain.Member;
import com.eomcs.mylist.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/add") 
public class BoardAddController extends HttpServlet {

  BoardService boardService;

  @Override
  public void init() throws ServletException {
    // BoardService 객체를 웹애플리케이션 보관소에서 꺼낸다.
    ServletContext 웹애플리케이션보관소 = this.getServletContext();
    boardService = (BoardService) 웹애플리케이션보관소.getAttribute("boardService");
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    request.getRequestDispatcher("/jsp/board/form.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    try {
      // 웹브라우저가 POST 요청으로 문자열을 보낼 때 어떤 문자집합으로 인코딩 했는지 알려줘야 한다.
      // 그래야만 getParameter() 메서드에서 웹브라우저가 보낸 파라미터 값을 올바르게 꺼낼 수 있다.
      // 즉 웹브라우저에서 웹서버에게 데이터를 보낼 때 UTF-8 로 인코딩 해서 보낸다.
      // 그렇게 인코딩 해서 보낸 문자열을 자바에서 사용하는 UTF-16 으로 바꿔서 리턴하는 것이다.
      // 주의!
      // 반드시 getParaemeter() 호출하기 전에 설정해야 한다. 
      // 단 한 번이라도 getParameter() 호출한 후 설정하게 되면 이 설정은 무시된다.
      request.setCharacterEncoding("UTF-8");

      Board board = new Board();
      board.setTitle(request.getParameter("title"));
      board.setContent(request.getParameter("content"));

      Member loginUser = (Member) request.getSession().getAttribute("loginUser");
      board.setWriter(loginUser);

      boardService.add(board);

      response.sendRedirect("list");

    } catch (Exception e) {
      request.setAttribute("exception", e);
      // 포워드 하기 전에 출력한 콘텐트가 있다면 모두 버리고 다른 서블릿에게 책임을 위임한다.
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}












