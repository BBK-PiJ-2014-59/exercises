/**
  * Book Title, for purpose of creating Title lists
  */
public interface Title {
  String getTitle();
  Title getNext();
  void setNext(Title t);
}
