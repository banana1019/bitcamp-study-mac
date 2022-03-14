package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Book;

@Mapper // => Mybatis는 다음 인터페이스의 구현체를 자동으로 생성한다.
public interface BookDao {

  // 인터페이스는 객체의 메서드 호출 규칙을 정의하는 것이기 때문에
  // 메서드를 작성할 때 메서드 몸체(method body)를 작성하지 말아야 한다.
  // 메서드 바디가 없는 메서드를 "추상 메서드(abstract method)"라 부른다.

  int countAll();

  List<Book> findAll();

  void insert(Book book);

  Book findByNo(int no);

  int update(Book book);

  int delete(int no);

}
