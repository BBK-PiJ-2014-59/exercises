public interface Library { 
  /** 
    * get name of library
    * @return name
    */
  public String getName();
  /** 
    * @return maximum number of books a user can borrow 
    */
  public int getMaxBorrow();
  /** 
    * @param max number of books a User can borrow 
    */
  public void setMaxBorrow(int max);
  /** 
    * Adds a user of this name if one doesn't exist or returns the ID if one does.
    * @param user name 
    * @return user ID 
    */
  public int getID(String name);
    /**
      * Adds a new book to the list of books in this library.
      * @param book title
      * @param book author
      */
  public void addBook(String title, String author);
    /**
      * If the book is not taken, marks the book as taken and returns it. If the book is taken,
      * null is returned.
      * @param book title
      * @return book
      */
  public Book takeBook(String title);
    /**
      * Marks the book as not taken.
      * @param book
      * @return whether book was returned
      */
  public boolean returnBook(Book book);
  /**
    * @return number of users registered in this library.
    */
  public int getReaderCount();

  /**
    * @return number of books in this library.
    */
  public int getBookCount();

  /**
    * @return number of borrowed books in this library.
    */
  public int getBookBorrowedCount();
}
