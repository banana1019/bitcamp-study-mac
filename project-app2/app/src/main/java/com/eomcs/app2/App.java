package com.eomcs.app2;

import java.util.Scanner;

public class App {

  Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    new App().service();
  }

  public void service() {

    while (true) {
      printMenu();

      String input = prompt("명령> ");

      if (checkQuit(input)) {
        break;
      }

      try {
        switch (input) {
          case "1": createScore(); break;
          case "2": listScore(); break;
          case "3": detailScore(); break;
          case "4": updateScore(); break;
          case "5": deleteScore(); break;
          default:
            System.out.println("올바른 메뉴 번호를 입력하세요!");
        }
      } catch (Exception e) {
        System.out.println("실행 중 오류 발생 :" + e.getMessage());
      }
      System.out.println();
    }

    System.out.println("종료!");
    keyScan.close();
  }

  private void printMenu() {
    System.out.println("메뉴: ");
    System.out.println("1. 등록");
    System.out.println("2. 목록");
    System.out.println("3. 상세");
    System.out.println("4. 변경");
    System.out.println("5. 삭제");
  }

  private String prompt(String title) {
    System.out.print(title);
    return keyScan.nextLine();
  }

  private int promptInt(String title) {
    return Integer.parseInt(prompt(title));
  }

  private boolean checkQuit(String input) {
    return input.equals("quit") || input.equals("exit");
  }

  private void createScore() {
    String name = prompt("이름? ");
    int kor = promptInt("국어? ");
    int eng = promptInt("영어? ");
    int math = promptInt("수학? ");
  }

  private void listScore() {

  }

  private void detailScore() {

  }

  private void updateScore() {

  }

  private void deleteScore() {

  }
}
