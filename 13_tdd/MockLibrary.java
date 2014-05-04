public class MockLibrary implements Library {

  private String name; 
  private int maxBooksPerUser;
  private Users users;
  private Book bookList;

  public MockLibrary(String name) {
    this.name = name;
    users = new UsersImpl();
    bookList = null;
  }

  public String getName() {
    return name; 
  }
  public int getMaxBooksPerUser() {
    return maxBooksPerUser;
  }
  public void setMaxBooksPerUser(int max) {
    maxBooksPerUser = max;
  }
  public int getID(String userGivenName) {
    return users.getID(userGivenName);
  }
  public Book findBook(String title, String author) {
    if (bookList == null) {
      return null;
    } else {
      Book curBook = bookList;
      do {
        System.out.println(curBook.getTitle());
        if (curBook.getTitle().equals(title) && curBook.getAuthorName().equals(author)) { 
          return curBook;
        }
        curBook = curBook.getNext();
      } while (curBook != null);
    }
    return null;
  }
  public void addBook(String title, String author) {
    if (bookList == null) {
      bookList = new BookImpl(title, author); 
    } else {
      Book newBook = new BookImpl(title, author);
      newBook.setNext(bookList);
      bookList = newBook;
    }
  }

}

