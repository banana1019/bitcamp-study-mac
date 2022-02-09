package com.eomcs.net.ex12.swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import com.eomcs.io.ex09.step3.DataOutputStream;

public class ChatClient extends JFrame {
  private static final long serialVersionUID = 1L;

  Socket socket;
  JTextField addressTf = new JTextField(30);
  JTextField portTf = new JTextField(5);
  JTextArea messageListTa = new JTextArea();
  JTextField messageTf = new JTextField(35);

  public ChatClient() {
    super("계산기");
    this.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        try {
          socket.close();
        } catch (Exception ex) {}
        System.exit(0);
      }
    });
    this.setSize(500, 400);

    Container contentPane = this.getContentPane();

    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체


    topPanel.add(addressTf);


    topPanel.add(portTf);

    JButton connectBtn = new JButton("연결");

    // 1) 로컬 클래스
    //    class MyActionListener implements ActionListener {
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //      }
    //    }
    //    connectBtn.addActionListener(new MyActionListener());

    // 2) 익명 클래스
    //    connectBtn.addActionListener(new ActionListener() {
    //      @Override
    //      public void actionPerformed(ActionEvent e) {
    //      }
    //    });

    // 3) 람다(lambda) 문법
    //    connectBtn.addActionListener(e -> System.out.println("연결 버튼 눌렀음!"));

    // 4) 메서드 레퍼런스
    connectBtn.addActionListener(this::connectChatServer);
    topPanel.add(connectBtn);

    contentPane.add(topPanel, BorderLayout.NORTH);


    contentPane.add(messageListTa, BorderLayout.CENTER);

    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT)); // 기본 레이아웃 관리자를 교체


    bottomPanel.add(messageTf);

    JButton sendBtn = new JButton("보내기");
    sendBtn.addActionListener(this::sendMessage);
    bottomPanel.add(sendBtn);

    contentPane.add(bottomPanel, BorderLayout.SOUTH);

    this.setVisible(true);
  }

  public static void main(String[] args) throws Exception {
    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
    //    UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
    //    UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
    //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
    //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
    //    System.out.println(UIManager.getSystemLookAndFeelClassName());
    new ChatClient();
  }

  public void connectChatServer(ActionEvent e) {
    System.out.println("서버에 연결하기");
    System.out.println(addressTf.getText());
    System.out.println(portTf.getText());

    try {
      socket = new Socket(
          addressTf.getText(), 
          Integer.parseInt(portTf.getText()));

      DataInputStream in = new DataInputStream(socket.getInputStream());
      DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    } catch (Exception ex) {
      JOptionPane.showMessageDialog(this, "서버에 연결 중 오류 발생!", "실행 오류!", JOptionPane.ERROR_MESSAGE);
    }
  }

  public void sendMessage(ActionEvent e) {
    System.out.println("메시지 보내기");
    System.out.println(messageTf.getText());
  }
}
