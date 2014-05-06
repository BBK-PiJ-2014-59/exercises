/** 
  * A library - has users and books.
  */
public interface Library {
  String getName();
  int getMaxBooksPerUser();
  void setMaxBooksPerUser(int max);
  int getID(String userGivenName);
  void addBook(String title, String author);
  Book findBook(String title, String author);
  /**
    * If the book is not taken, marks the book as taken and returns it. If the book is taken, null is returned.
    * @param title
    * @param author 
    * @return book if taken. If the book is already taken, returns null.
    */
  Book findBook(String title);
  /**
    * If the book is not taken, marks the book as taken and returns it. If the book is taken, null is returned.
    * @param title
    * @return book if taken. If the book is already taken, returns null.
    */
  Book takeBook(String title);
  /**
    * Marks the book as not taken
    * @param Book
    */
  void returnBook(Book book);
}
