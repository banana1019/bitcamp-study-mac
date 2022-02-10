package com.eomcs.oop.ex11.overview.step2;

public class QueueIterator implements Iterator {
  MyQueue queue;
  int cursor;

  public QueueIterator(MyQueue queue) {
    this.queue = queue;
  }

  @Override
  public boolean hasNext() {
    return queue.size() > 0;
  }

  @Override
  public Object next() {
    return queue.poll();
  }
}
