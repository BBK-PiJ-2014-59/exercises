/** 
  * A library - has users and books.
  */
public interface Library {
  String getName();
  int getMaxBooksPerUser();
  void setMaxBooksPerUser(int max);
  int getID(String userGivenName);
  /** 
    * return the name of the person that is borrowing a specific given title at the moment; 
    * if nobody is borrowing the book, or the book does not exist in the library,
    * you must return null (not an empty String).
    * @param Title of book
    * @return name of User borrowing book
    */
  String getBorrower(Title t);
  /** 
    * return a list (or an array) with all the users, borrowing or not.
    */
  User getUsers();
  /** 
    * return a list (or an array) with all the users that are borrowing books at the moment. 
    */
  User getBorrowers();
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
