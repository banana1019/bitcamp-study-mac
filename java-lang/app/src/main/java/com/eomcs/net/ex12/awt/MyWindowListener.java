package com.eomcs.net.ex12.awt;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyWindowListener implements WindowListener {

  @Override
  public void windowOpened(WindowEvent e) {
    // 윈도우가 출력된 후

  }

  @Override
  public void windowClosing(WindowEvent e) {
    // 윈도우의 x 버튼을 눌렀을 때 
    System.exit(0);

  }

  @Override
  public void windowClosed(WindowEvent e) {
    // 윈도우를 닫은 후 

  }

  @Override
  public void windowIconified(WindowEvent e) {
    // 윈도우에 _ 버튼을 눌러 아이콘으로 전환되었을 때

  }

  @Override
  public void windowDeiconified(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowActivated(WindowEvent e) {
    // TODO Auto-generated method stub

  }

  @Override
  public void windowDeactivated(WindowEvent e) {
    // TODO Auto-generated method stub

  }

}
