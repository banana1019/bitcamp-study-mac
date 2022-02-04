package com.eomcs.app1;

public class CommandHandler {
  void doHelp() {
    System.out.println("add   [값1] [값2]      더하기 계산을 수행한다.");
    System.out.println("minus [값1] [값2]      빼기 계산을 수행한다.");
    System.out.println("help                   도움말을 출력한다.");
  }

  void doAdd(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("add 명령어 입력 형식이 올바르지 않습니다.");
      System.out.println("형식: add 값1 값2");
      System.out.println("예) add 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d + %d = %d\n", v1, v2, (v1 + v2));
    }
  }

  void doMinus(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("minus 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식: minus 값1 값2");
      System.out.println("예) minus 100 200");
    } else {
      int v1 = command.getInt(0);
      int v2 = command.getInt(1);
      System.out.printf("%d - %d = %d\n", v1, v2, (v1 - v2));
    }
  }

  void doDivide(Command command) {
    if (command.getParamSize() != 2) {
      System.out.println("divide 명령어 입력 형식이 옳지 않습니다.");
      System.out.println("형식: divide 값1 값2");
      System.out.println("예) divide 100 200");
    } else {
      try {
        // 예외가 발생할만한 코드를 try 블록 안에 가둔다.
        int v1 = command.getInt(0);
        int v2 = command.getInt(1);
        System.out.printf("%d / %d = %d\n", v1, v2, (v1 / v2));
      } catch (Exception e) { // try 블록에서 발생된 예외를 잡는 블록을 준비한다.
        // 예외에 대한 적절한 조치를 취하는 코드를 이 블록에 둔다.
        System.out.println("나누기 연산 중 오류 발생!");
      }
    }
  }
}

