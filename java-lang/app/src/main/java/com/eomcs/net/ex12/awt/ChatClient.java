package com.eomcs.net.ex12.awt;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient {
  public static void main(String[] args) {

    class MyWindowListener extends WindowAdapter {
      @Override
      public void windowClosing(WindowEvent e) {
        // 윈도우의 x 버튼을 눌렀을 때 
        System.exit(0);
      }
    }

    Frame f = new Frame("계산기");
    f.addWindowListener(new MyWindowListener());
    f.setSize(400, 300);
    f.setVisible(true);
  }
}
