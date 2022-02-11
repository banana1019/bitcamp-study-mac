// anonymous class - 익명 클래스가 놓이는 장소: 파라미터
package com.eomcs.oop.ex11.e;

public class Exam0450 {
  // 인터페이스의 경우 static으로 선언하지 않아도 스태틱 멤버에서 사용할 수 있다.
  interface A {
    void print();
  }

  static A create1() {
    class X implements A {
      @Override
      public void print() {
        System.out.println("Hello!");
      }
    }
    return new X();
  }

  static A create2() {
    return new A() {
      @Override
      public void print() {
        System.out.println("Hello2!");
      }
    };
  }

  static A create3() {
    return () ->System.out.println("Hello2!");
  }

  public static void main(String[] args) {
    A obj1 = create1();
    obj1.print();

    A obj2 = create2();
    obj2.print();

    A obj3 = create3();
    obj3.print();
  }
}
