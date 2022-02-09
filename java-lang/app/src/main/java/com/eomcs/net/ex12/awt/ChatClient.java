package com.eomcs.net.ex12.awt;

import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClient extends Frame {
  private static final long serialVersionUID = 1L;

  public ChatClient() {
    super("계산기");
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
    this.setSize(400, 300);

    TextField addressTF = new TextField();
    this.add(addressTF);

    TextField portTF = new TextField();
    this.add(portTF);

    this.setVisible(true);
  }

  public static void main(String[] args) {
    new ChatClient();
  }
}
