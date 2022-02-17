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
    try {
      out.writeUTF("insert");
      out.writeObject(score);
      out.flush();

      String status = in.readUTF();
      if (status.equals("success")) {
        return in.readInt();
      } else {
        throw new RuntimeException(in.readUTF());
      }
    } catch (Exception e) {
      throw new ScoreTableException(e);
    }
  }

  public static Score[] selectList() {
    try {

    } catch (Exception e) {
      throw new ScoreTableException(e);
    }
  }

  public static Score selectOne(int no) {
    try {

    } catch (Exception e) {
      throw new ScoreTableException(e);
    }
  }

  public static int update(int no, Score score) {
    try {

    } catch (Exception e) {
      throw new ScoreTableException(e);
    }
  }

  public static int delete(int no) {
    try {

    } catch (Exception e) {
      throw new ScoreTableException(e);
    }
  }

}
