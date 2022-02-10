package com.eomcs.oop.ex11.overview.step1;

public class Test2 {
  public static void main(String[] args) {
    MyStack myStack = new MyStack();
    myStack.add("홍길동");
    myStack.add("임꺽정");
    myStack.add("유관순");
    myStack.add("안중근");    
    myStack.add("윤봉길");    
    myStack.add("김구");

    for (int i = 0; i < myStack.size(); i++) {
      System.out.println(myStack.get(i));
    }
  }
}
