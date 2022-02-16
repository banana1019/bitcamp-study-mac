package com.eomcs.app2.table;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import com.eomcs.app2.vo.Score;

public class ScoreTable {

  static ArrayList<Score> scores = new ArrayList<>();

  static {
    try (BufferedReader in = new BufferedReader(new FileReader("./score.csv"));) {
      String line;
      while ((line = in.readLine()) != null) {
        scores.add(Score.fromCSV(line));
      }
    } catch (Exception e) {
      System.out.println("데이터 로딩 중 오류 발생!");
    }
  }

  private static void save() {
    try (PrintWriter out = new PrintWriter(new FileWriter("./score.csv"));) {
      for (Score score : scores) {
        out.println(score.toCSV());
      }
    } catch (Exception e) {
      System.out.println("데이터 저장 중 오류 발생!");
    }
  }

  public static int insert(Score score) {
    scores.add(score);
    return 0;
  }

  public static Score[] selectList() {
    // TODO Auto-generated method stub
    return null;
  }

  public static Score selectOne(int readInt) {
    // TODO Auto-generated method stub
    return null;
  }

  public static int update(int no, Score score) {
    // TODO Auto-generated method stub
    return 0;
  }

  public static int delete(int no) {
    // TODO Auto-generated method stub
    return 0;
  }


}
