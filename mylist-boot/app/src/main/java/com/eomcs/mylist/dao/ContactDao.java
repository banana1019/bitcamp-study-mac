package com.eomcs.mylist.dao;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;

@Mapper
public interface ContactDao {

  int countAll(); // ==> <select id="com.eomcs.mylist.dao.ContactDao.countAll">...</select> 

  List<Contact> findAll();

  int insert(Contact contact);

  Contact findByNo(int no);

  Contact findByEmail(String email);

  List<Contact> findByName(String name);

  int update(Contact contact);

  int delete(int no);

  List<ContactTel> findByContactNo(int contactNo);

  int addTel(ContactTel tel);

  int updateTel(ContactTel tel);

  int removeTel(int telNo);
}











