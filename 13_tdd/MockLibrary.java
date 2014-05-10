public class MockLibrary implements Library {

  private String name; 
  private int maxBooksPerUser;
  private Users users;
  private Book bookList;
  private int noBorrowerID;
  private User noBorrower;

  public MockLibrary(String name) {
    this.name = name;
    users = new UsersImpl();
    bookList = null;
    noBorrowerID = getID("noBorrower");
    noBorrower = getUserByID(noBorrowerID);
  }

  public void lendBookToUser(Book book, User user) {
    book.setBorrower(user);
    user.addToMyTitleList(book.getTitle());
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

  public User getUserByID(int userID) {
    return users.getUserByID(userID);
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

  public Book findBook(String title) {
    if (bookList == null) {
      return null;
    } else {
      Book curBook = bookList;
      do {
        if (curBook.getTitle().equals(title)) {
          return curBook;
        }
        curBook = curBook.getNext();
      } while (curBook != null);
    }
    return null;
  }

  public Book addBook(String title, String author) {
    if (bookList == null) {
      bookList = new BookImpl(title, author); 
    } else {
      Book newBook = new BookImpl(title, author);
      newBook.setNext(bookList);
      bookList = newBook;
    }
    return bookList;
  }

  public Book takeBook(String title) {
    Book curBook = null;
    if (bookList != null) {
      curBook = bookList; 
      do {
        if (curBook.getTitle().equals(title)) {
          System.out.println("Yoda");
          if (curBook.isTaken()) {
            return null;
          } else { 
            curBook.setTaken(true);
            curBook.setBorrower(noBorrower);
            return curBook;
          }
        }
        curBook = curBook.getNext();
      } while (curBook != null);
    }
    return null;
  }


  public void returnBook(Book book) {
    Book curBook = null;
    if (bookList != null) {
      curBook = bookList;
      do {
        System.out.println("YODa");
        if (curBook.equals(book)) {
          curBook.setTaken(false);
          if (curBook.getBorrower() == null) {
            System.out.println("borrower: null");
          } else {
            System.out.println("borrower: " + curBook.getBorrower().getName());
          }
          curBook.getBorrower().deleteFromMyTitleList(book.getTitle());
          curBook.setBorrower(null);
          return;
        }
        curBook = curBook.getNext();
      } while (curBook != null);
    } 
  }

  public int getReaderCount() {
    return users.count();
  }

  public int getBookCount() {
    Book curBook = bookList;    
    if (curBook == null) {
      return 0;
    }
    int total = 0;
    do {
      curBook = curBook.getNext(); 
      total++;
    } while (curBook != null);
    return total;
  }

  public int getBookBorrowedCount() {
    Book curBook = bookList;
    if (curBook == null) {
      return 0;
    }
    int total = 0;
    do {
      if (curBook.isTaken()) {
        total++;
      }
      curBook = curBook.getNext();
    } while (curBook != null);
    return total;
  }

}

