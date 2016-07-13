package com.estsoft.practice_algo.stack;

public class FreeLink<E> {
  private E element;
  private FreeLink<E> next;

  public FreeLink(E el, FreeLink<E> nextLink) {
    this.element = el;
    this.next = nextLink;
  }

  public FreeLink(FreeLink<E> nextLink) {
    this(null, nextLink);
  }

  public E element() {
    return this.element;
  }

  public E setElement(E el) {
    return this.element = el;
  }

  public FreeLink<E> next() {
    return this.next;
  }

  public FreeLink<E> setNext(FreeLink<E> nextLink) {
    return this.next = nextLink;
  }

  //
  @SuppressWarnings("rawtypes")
  private static FreeLink freeStack = null;

  @SuppressWarnings("unchecked")
  public static <E> FreeLink<E> get(E el, FreeLink<E> nextLink) {
    if (freeStack == null) return new FreeLink<E>(el, nextLink);
    FreeLink<E> temp = freeStack;
    freeStack = freeStack.next();
    temp.element = el;
    temp.next = nextLink;
    return temp;
  }

  @SuppressWarnings("unchecked")
  public void release() {
    this.element = null;
    this.next = freeStack;
    freeStack = this;
  }
}
