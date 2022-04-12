package com.eomcs.mylist.web.listener;

import java.io.InputStream;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.eomcs.mylist.service.BoardService;
import com.eomcs.mylist.service.MemberService;
import com.eomcs.mylist.service.impl.DefaultBoardService;
import com.eomcs.mylist.service.impl.DefaultMemberService;

// - 웹 애플리케이션이 시작될 때 서비스 객체, DAO 객체, MyBatis 객체를 준비한다.
public class ContextLoaderListener implements ServletContextListener {

  @Override
  public void contextInitialized(ServletContextEvent sce) {
    // 웹 애플리케이션이 시작되면 이 메서드가 호출될 것이다.
    System.out.println("서비스 및 DAO, MyBatis 객체 준비");

    try {
      // 1) MyBatis의 SqlSessionFactory 준비
      String resource = "com/eomcs/mylist/conf/mybatis-config.xml";
      InputStream inputStream = Resources.getResourceAsStream(resource);
      SqlSessionFactory sqlSessionFactory =
          new SqlSessionFactoryBuilder().build(inputStream);

      // 2) 서비스 객체 생성
      BoardService boardService = new DefaultBoardService(sqlSessionFactory);
      MemberService memberSerive = new DefaultMemberService(sqlSessionFactory);

      // 3) 서블릿에서 서비스 객체를 사용할 수 있도록 ServletContext 보관소에 저장한다.
      ServletContext 웹애플리케이션보관소 = sce.getServletContext();
      웹애플리케이션보관소.setAttribute("boardService", boardService);
      웹애플리케이션보관소.setAttribute("memberSerive", memberSerive);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
