package com.eomcs.net.ex12.awt;

import java.awt.Frame;

public class ChatClient {
  public static void main(String[] args) {
    Frame f = new Frame("계산기");
    f.addWindowListener(new MyWindowListener());
    f.setSize(400, 300);
    f.setVisible(true);
  }
}
