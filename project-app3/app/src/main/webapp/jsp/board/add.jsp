<%@page import="com.eomcs.mylist.domain.Member"%>
<%@page import="com.eomcs.mylist.domain.Board"%>
<%@page import="com.eomcs.mylist.service.BoardService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
  Board board = new Board();
  board.setTitle(request.getParameter("title"));
  board.setContent(request.getParameter("content"));

  Member loginUser = (Member) session.getAttribute("loginUser");
  board.setWriter(loginUser);

  BoardService boardService = (BoardService) application.getAttribute("boardService");
  boardService.add(board);

  response.sendRedirect("list.jsp"); // 게시물 목록 페이지를 다시 요청하라고 클라이언트에게 명령한다.
%>
