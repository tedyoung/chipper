package com.jitterpig.chipper.domain;

/**
 *
 */
public class BookEntry {
  public int _minutes;
  public String _title;
  public int _pages;

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("BookEntry: ");
    sb.append("minutes=").append(_minutes);
    sb.append(", title='").append(_title).append('\'');
    sb.append(", pages=").append(_pages);
    return sb.toString();
  }
}
