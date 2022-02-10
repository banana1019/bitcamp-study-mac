package com.eomcs.oop.ex11.overview.step1;

import java.util.Arrays;

public class MyList {
  Object[] arr = new Object[10];

  int size;

  public void add(Object obj) {
    if (size == arr.length) {
      arr = Arrays.copyOf(arr, arr.length + (arr.length >> 1));
    }
    arr[size++] = obj;
  }

  public Object get(int i) throws ArrayIndexOutOfBoundsException {
    if (i < 0 || i >= size) {
      throw new ArrayIndexOutOfBoundsException();
    }
    return arr[i];
  }
}
