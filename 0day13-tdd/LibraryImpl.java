import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

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

  public boolean returnBook(Book book) { 
    boolean result = false;
    Iterator it = booksOut.iterator();
    while (it.hasNext()) { 
      Book b = (Book) it.next();
      if (b.equals(book)) { 
        it.remove();
        result = true;
      }
    }
    return result;
  }

  
  /*
  private boolean haveTitle(String title) { 
    for (Book b : books) { 
      if (b.getTitle().equals(title)) { 
    
  }
  */

  private Book haveBook(String title) { 
    System.out.println("Seeing if library has: " + title);
    Book result = null;
    for (Book b : books) { 
      if (title.equals(b.getTitle()))  { 
        result = b;
        System.out.println("FOUND: " + title);
        break;
      }
    }
    return result;
  }

  public Book takeBook(String title) { 
    System.out.println("trying to take out: " + title);
    Book result = haveBook(title);

    boolean out = false;
    if (booksOut.contains(result)) { 
      out = true;
      result = null;
      System.out.println("checked out already");
    }
    if (result != null) { 
      //System.out.println("adding " + result.getTitle() + " to booksOut.");
      booksOut.add(result);
      System.out.println("added " + result.getTitle() + " to booksOut. booksOut.size(): " + booksOut.size());
    }
    return result; 
  }


  public void addBook(String title, String author) { 
    //System.out.print("\nADDBOOK\n");
    books.add(new BookImpl(title, author));
    //for (Book b : books) { 
    //  System.out.print(b.getTitle() + " ");
    //}
  }
  
  public int getReaderCount() { 
    return users.size();
  }

  public int getBookCount() { 
    return books.size();
  }
  public int getBookBorrowedCount() { 
    //for (Book b : booksOut)
      //System.out.println(b.getTitle() + " " + b.getAuthor());
    return booksOut.size();
  }
}
