package com.eomcs.oop.ex11.h.test;

public class Test {

  public static void main(String[] args) {
    LinkedList list = new LinkedList();
    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");
    list.add("김구");
    System.out.println(list.size());

    printList(list);

    Node deleted = list.get(0);

    list.remove(0);
    list.remove(4);
    list.remove(2);


    printList(list);

    list.remove(0);
    list.remove(0);
    list.remove(0);
    list.add("박보검");
    printList(list);

    list.add("홍길동");
    list.add("임꺽정");
    list.add("유관순");
    list.add("안중근");
    list.add("윤봉길");
    printList(list);

    list.add(0, "김구");
    list.add(0, "안창호");
    printList(list);

    list.add(7, "김상옥");
    printList(list);

    list.set(4, "오호라");
    printList(list);
  }

  static void printList(LinkedList list) {
    for (int i = 0; i < list.size(); i++) {
      System.out.print(list.get(i) + ",");
    }
    System.out.println();
    System.out.println("------------------------------------------");
  }

}
