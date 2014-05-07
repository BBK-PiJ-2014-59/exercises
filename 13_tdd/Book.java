/**
  * A library book
  */
public interface Book {
  String getTitle();
  String getAuthorName();
  void setNext(Book book);
  Book getNext();
  boolean isTaken();
  void setTaken(Boolean taken);
  /**
    * @return User currently borrowing or null if not checked out.
    */
  User getBorrower();
  /**
    * @param User to check book out to.
    */
  void setBorrower(User user);
}
