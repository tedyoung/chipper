package com.jitterpig.chipper.domain;

/**
 *
 */
public class ChipEntry {
  public String _chipJournalType;
  public int _chipChangeAmount;
  public BookEntry _bookEntry = new BookEntry();

  public static ChipEntry entry() {
    return new ChipEntry();
  }

  public ChipEntry addChips(int chipAmountToAdd) {
    _chipChangeAmount = chipAmountToAdd;
    _chipJournalType = "add";
    return this;
  }

  public ChipEntry readMinutes(int minutesRead) {
    _bookEntry._minutes = minutesRead;
    return this;
  }

  public ChipEntry readBook(String title) {
    _bookEntry._title = title;
    return this;
  }

  public ChipEntry readPages(int pagesRead) {
    _bookEntry._pages = pagesRead;
    return this;
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder("ChipEntry: ");
    sb.append("chipJournalType='").append(_chipJournalType).append('\'');
    sb.append(", chipChangeAmount=").append(_chipChangeAmount);
    sb.append(", bookEntry=").append(_bookEntry);
    return sb.toString();
  }
}
