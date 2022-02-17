package com.eomcs.app2.net;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.eomcs.app2.vo.Score;

public class ScoreTableProxy {

  Socket socket;
  ObjectOutputStream out;
  ObjectInputStream in;

  public ScoreTableProxy(String host, int port) throws Exception {
    socket = new Socket(host, port);
    out = new ObjectOutputStream(socket.getOutputStream());
    in = new ObjectInputStream(socket.getInputStream());
  }

  public void close() {
    try {out.close();} catch (Exception e) {}
    try {in.close();} catch (Exception e) {}
    try {socket.close();} catch (Exception e) {}
  }

  public int insert(Score score) {
    out.writeUTF("insert");
    out.writeObject(score);
    out.flush();

    return 1;
  }

  public static Score[] selectList() {
    return scores.toArray(new Score[0]);
  }

  public static Score selectOne(int no) {
    return scores.get(no);
  }

  public static int update(int no, Score score) {
    scores.set(no, score);
    save();
    return 1;
  }

  public static int delete(int no) {
    scores.remove(no);
    save();
    return 1;
  }

}
