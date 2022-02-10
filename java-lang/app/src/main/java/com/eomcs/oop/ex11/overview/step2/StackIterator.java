package com.eomcs.oop.ex11.overview.step2;

public class StackIterator implements Iterator {
  MyStack stack;
  int cursor;

  public StackIterator(MyStack stack) {
    this.stack = stack;
  }

  @Override
  public boolean hasNext() {
    if (cursor >= stack.size()) {
      return false;
    }
    return true;
  }

  @Override
  public Object next() {
    return stack.pop();
  }
}
