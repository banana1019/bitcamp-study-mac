package com.eomcs.mylist.controller.board;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.eomcs.mylist.domain.Board;
import com.eomcs.mylist.service.BoardService;

@SuppressWarnings("serial")
@WebServlet("/board/list") 
public class BoardListController extends HttpServlet {

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

    try {
      // 1) 입력 데이터 가공 
      int pageNo = 1;
      int pageSize = 5;
      int totalPageSize = 0;

      try { // pageSize 파라미터 값이 있다면 기본 값을 변경한다.
        pageSize = Integer.parseInt(request.getParameter("pageSize"));
        if (pageSize < 5 || pageSize > 100) {
          pageSize = 5;
        }
      } catch (Exception e) {}

      //게시글 전체 개수를 알아내서 페이지 개수를 계산한다.
      int boardSize = boardService.size(); 
      totalPageSize = boardSize / pageSize; // 예: 게시글개수 / 페이지당개수 = 16 / 5 = 3 
      if ((boardSize % pageSize) > 0) {
        totalPageSize++;
      }

      try { // pageNo 파라미터 값이 있다면 기본 값을 변경한다.
        pageNo = Integer.parseInt(request.getParameter("pageNo"));
        if (pageNo < 1 || pageNo > totalPageSize) {// pageNo 유효성 검증
          pageNo = 1;
        }
      } catch (Exception e) {}

      // 2
      List<Board> boards = boardService.list(pageSize, pageNo);

      //3)
      request.setAttribute("list", boards);
      request.setAttribute("pageNo", pageNo);
      request.setAttribute("pageSize", pageSize);
      request.setAttribute("totalPageSize", totalPageSize);

      // 4)
      RequestDispatcher 요청배달자 = request.getRequestDispatcher("/jsp/board/list.jsp");
      요청배달자.forward(request, response);
    } catch (Exception e) {
      request.setAttribute("exception", e);
      // 포워드 하기 전에 출력한 콘텐트가 있다면 모두 버리고 다른 서블릿에게 책임을 위임한다.
      request.getRequestDispatcher("/jsp/error.jsp").forward(request, response);
    }
  }
}






