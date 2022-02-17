package com.eomcs.app2.net;

public class ScoreTableException extends RuntimeException {
  private static final long serialVersionUID = 1L;

  public ScoreTableException() {
    super();
  }

  public ScoreTableException(String message, Throwable cause, boolean enableSuppression,
      boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }

  public ScoreTableException(String message, Throwable cause) {
    super(message, cause);
  }

  public ScoreTableException(String message) {
    super(message);
  }

  public ScoreTableException(Throwable cause) {
    super(cause);
  }


}
