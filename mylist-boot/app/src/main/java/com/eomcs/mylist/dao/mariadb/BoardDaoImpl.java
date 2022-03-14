package com.eomcs.mylist.dao.mariadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import javax.sql.DataSource;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.eomcs.mylist.dao.BoardDao;
import com.eomcs.mylist.dao.DaoException;
import com.eomcs.mylist.domain.Board;

// @Repository
// - 클래스에 이 애노테이션을 붙여 표시해 두면, Spring Boot가 실행될 때 이 클래스의 객체를 자동 생성한다.
// - 또한 이 객체를 원하는 곳에 자동으로 주입한다.
//
@Repository  
public class BoardDaoImpl implements BoardDao {

  @Autowired // => 스프링 부트가 보관하고 있는 객체 중에서 다음 타입의 객체가 있다면 주입해 줄 것을 지시하는 애너테이션
  DataSource dataSource;

  @Autowired
  SqlSessionFactory sqlSessionFactory; // => Mybatis: SQL 실행 도구를 만들어 주는 객체

  public BoardDaoImpl() {
    System.out.println("JdbcBoardDao 객체 생성!");
  }

  @Override
  public int countAll() {
    // DataSource에서 얻은 커넥션 객체는 close() 할 때 연결을 끊는 것이 아니라 DataSource에 반납된다.
    try (
        Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement( 
            "select count(*) from ml_board");
        ResultSet rs = stmt.executeQuery()) {

      rs.next();
      return rs.getInt(1);
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public List<Board> findAll() {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.selectList("BoardDao.sql1");
    }
  }

  @Override
  public int insert(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.insert("BoardDao.sql3", board);
    }
  }

  @Override
  public Board findByNo(int no) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
      System.out.println(sqlSession.getClass().getName());
      return sqlSession.selectOne("BoardDao.sql2", no);
    }
  }

  @Override
  public int update(Board board) {
    try (SqlSession sqlSession = sqlSessionFactory.openSession();) { // SQL을 실행시켜주는 도구를 준비
      return sqlSession.update("BoardDao.sql4", board);
    }
  }

  @Override
  public int delete(int no) {
    try (
        Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "delete from ml_board where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }

  @Override
  public int increaseViewCount(int no) {
    try (
        Connection con = dataSource.getConnection();
        PreparedStatement stmt = con.prepareStatement(
            "update ml_board set view_count=view_count + 1 where board_no=?")) {

      stmt.setInt(1, no);
      return stmt.executeUpdate();
    } catch (Exception e) {
      throw new DaoException(e);
    }
  }
}











