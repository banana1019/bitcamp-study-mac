package com.eomcs.oop.ex11.overview.step6;

import java.util.EmptyStackException;

public class MyStack extends MyList {
  public void push(Object obj) {
    this.add(obj);
  }

  public Object pop() {
    if (size == 0) {
      throw new EmptyStackException();
    }
    return remove(size - 1);
  }

  @Override
  public Iterator iterator() {

    class StackIterator implements Iterator {

      int cursor;

      @Override
      public boolean hasNext() {
        return MyStack.this.size() > 0;
      }

      @Override
      public Object next() {
        return MyStack.this.pop();
      }
    }

    return new StackIterator();
  }

}
