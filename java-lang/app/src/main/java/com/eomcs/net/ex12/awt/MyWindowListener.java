package com.eomcs.net.ex12.awt;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWindowListener extends WindowAdapter {

  @Override
  public void windowClosing(WindowEvent e) {
    // 윈도우의 x 버튼을 눌렀을 때 
    System.exit(0);
  }

}
