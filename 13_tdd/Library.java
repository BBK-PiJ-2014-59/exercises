/** 
  * A library - has users and books.
  */
public interface Library {
  String getName();
  int getMaxBooksPerUser();
  void setMaxBooksPerUser(int max);
  int getID(String userGivenName);
  // User getUserByName(String userGivenName);
  /**
    * @param Book
    * @param User 
    */
  void lendBookToUser(Book book, User user);
  User getUserByID(int ID);
  /**
    * @param title
    * @param author 
    * @return book added 
    */
  Book addBook(String title, String author);
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
  /**
    * @return the number of users registered in this library.
    */
  int getReaderCount();
  /**
    * @return number of books in this library.
    */
  int getBookCount();
  /**
    * @return number of borrowed books in this library.
    */
  int getBookBorrowedCount();

}
