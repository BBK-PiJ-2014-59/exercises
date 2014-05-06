public interface Book {
  String getTitle();
  String getAuthorName();
  void setNext(Book book);
  Book getNext();
  boolean isTaken();
  void setTaken(Boolean taken);
}
