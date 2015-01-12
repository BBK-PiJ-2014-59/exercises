import java.util.ArrayList;
import java.util.List;

public class LibraryImpl implements Library { 
  private String name;
  private int maxBorrow;
  private List<User> users;
  private int nextUserID;
  private List<Book> books;
  private List<Book> booksOut;

  public LibraryImpl(String name) { 
    this.name = name;
    maxBorrow = 5;
    users = new ArrayList<User>();
    nextUserID = 500;
    books = new ArrayList<Book>();
    booksOut = new ArrayList<Book>();
  }

  private int generateUserID() { 
    return nextUserID++;
  }
  public String getName() { 
    return name;
  }
  public int getMaxBorrow() { 
    return maxBorrow;
  }
  public void setMaxBorrow(int max) { 
    maxBorrow = max;
  }

  private int addUser(User u) { 
    if (!nameIsUniqueInUsers(u.getName())) { 
      throw new IllegalArgumentException("User name exists already.");
    } else { 
      int id = generateUserID();
      u.setID(id);
      if (!idIsUniqueInUsers(u.getID())) { 
        throw new IllegalArgumentException("User ID not unique.");
      } else { 
        users.add(u);
        return id;
      }
    }
  }

  private boolean nameIsUniqueInUsers(String name) { 
    boolean result = true;
    for (User user : users) { 
      if (user.getName().equals(name)) result = false; 
    }
    return result;  
  }


  private User getUser(String name) { 
    for (User user : users) { 
      if (user.getName().equals(name)) 
        return user; 
    }
    return null;  
  }
  
  private boolean idIsUniqueInUsers(int id) { 
    boolean result = true;
    for (User user : users) { 
      if (user.getID() == id) result = false; 
    }
    return result;  
  }

  public int getID(String userName) { 
    int result;
    User u;
    if ((u = getUser(userName)) == null) { 
      result = addUser(new UserImpl(userName));
    } else { 
      result = u.getID();
    }
    return result;
  }

  public void returnBook(Book book) { 
  }

  
  /*
  private boolean haveTitle(String title) { 
    for (Book b : books) { 
      if (b.getTitle().equals(title)) { 
    
  }
  */

  public Book takeBook(String title) { 
    Book result = null;
    for (Book book: books) { 
      if (book.getTitle().equals(title)); { 
        result = book; 
        break;
      }
    }
    boolean out = false;
    for (Book book : booksOut) { 
      if (book.equals(result)); { 
        out = true;
        result = null;
      }
    }
    if (result != null)
      booksOut.add(result);
    return result; 
  }


  public void addBook(String title, String author) { 
    books.add(new BookImpl(title, author));
  }
}
