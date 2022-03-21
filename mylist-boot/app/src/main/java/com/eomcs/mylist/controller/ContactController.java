package com.eomcs.mylist.controller;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.eomcs.mylist.dao.ContactDao;
import com.eomcs.mylist.domain.Contact;
import com.eomcs.mylist.domain.ContactTel;
import com.eomcs.mylist.service.ContactService;

@RestController 
public class ContactController {

  @Autowired
  ContactService contactService;

  @Autowired
  ContactDao contactDao;

  @Autowired
  TransactionTemplate transactionTemplate;

  @RequestMapping("/contact/list")
  public Object list() {
    return contactService.list();
  }

  @RequestMapping("/contact/add")
  public Object add(Contact contact, String[] tel) throws Exception {

    // 요청 파라미터 분석 및 가공
    ArrayList<ContactTel> telList = new ArrayList<>();
    for (int i = 0; i < tel.length; i++) {
      String[] value = tel[i].split("_");
      if (value[1].length() == 0) {
        continue;
      }
      ContactTel contactTel = new ContactTel(Integer.parseInt(value[0]), value[1]);
      telList.add(contactTel);
    }
    contact.setTels(telList);

    // 서비스 객체 실행
    return contactService.add(contact);

    /*
      class ContactAddTransaction implements TransactionCallback {
        @Override
        public Object doInTransaction(TransactionStatus status) {
          // 1) 트랜잭션으로 묶어서 실행할 작업을 정의
          // => 스프링 프레임워크에서 정한 규칙에 따라 정의해야 한다.
          contactDao.insert(contact);
          for (int i = 0; i < tel.length; i++) {
            String[] value = tel[i].split("_");
            if (value[1].length() == 0) {
              continue;
            }
            contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
          }
          return 1;
        }
      }

      // 2) 트랜잭션 작업을 수행한다.
      return transactionTemplate.execute(new ContactAddTransaction());
     */
  }

  @RequestMapping("/contact/get")
  public Object get(int no) {
    Contact contact = contactService.get(no);
    if (contact == null) {
      return ""; // 컨트롤러는 서비스 객체의 리턴 값에 따라 응답 데이터를 적절히 가공하여 리턴한다.
    }
    return contact;
  }

  @RequestMapping("/contact/update")
  public Object update(Contact contact, String[] tel) throws Exception {
    int count = contactDao.update(contact);
    if (count > 0) {
      contactDao.deleteTelByContactNo(contact.getNo());
      for (int i = 0; i < tel.length; i++) {
        String[] value = tel[i].split("_");
        if (value[1].length() == 0) {
          continue;
        }
        contactDao.insertTel(new ContactTel(contact.getNo(), Integer.parseInt(value[0]), value[1]));
      }
    }
    return count;
  }

  @RequestMapping("/contact/delete")
  public Object delete(int no) throws Exception {
    contactDao.deleteTelByContactNo(no);
    return contactDao.delete(no);
  }

}




