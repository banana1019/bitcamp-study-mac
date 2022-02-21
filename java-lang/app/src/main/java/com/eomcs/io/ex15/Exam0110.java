// 바이너리 파일을 텍스트 형식으로 저장하기
package com.eomcs.io.ex15;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Base64;
import java.util.Base64.Encoder;

public class Exam0110 {
  public static void main(String[] args) throws Exception {

    Encoder encoder = Base64.getEncoder();
    FileInputStream in = new FileInputStream("./temp/aaa.png");
    FileWriter out = new FileWriter("./temp/aaa.txt");

    byte[] buf = new byte[1024];
    int len = 0;
    while ((len = in.read(buf)) != -1) {
      System.out.printf("읽은 바이트 수 : %d\n", len);

      // 바이트 배열에 저장된 바이너리 데이터를 텍스트로 변환하기
      String encodedStr = encoder.encodeToString(Arrays.copyOf(buf, len));
      System.out.println(encodedStr);

      // 텍스트로 변환된 데이터를 파일로 출력하기
      out.write(encodedStr);
    }

    in.close();
    out.close();
  }
}
