import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryTests { 

  // test Book
  private String myTitle1;
  private String myAuthor1;
  private Book myBook1;

  // test User
  private User myUser1;
  private String myName1;
  private int myID1;

  // test mock Library
  private Library myMockLibrary1;
  private String myMockLibraryName1;

  // test Library
  private Library myLibrary1;
  private String myLibraryName1;

  @Before
  public void buildUp() { 
    myTitle1 = "title1";
    myAuthor1 = "author1";
    myBook1 = new BookImpl("title1", "author1");

    myName1 = "Jesse";
    myUser1 = new UserImpl(myName1);
    myID1 = 13;

    myMockLibrary1 = mock(Library.class);
    myMockLibraryName1 = "mock Library name";

    myLibraryName1 = "Library name";
    myLibrary1 = new LibraryImpl(myLibraryName1);
  }

/*
  // some Library tests to maybe write later...

  @Test (expected = Exception.class)
  public void addingUserWithNonUniqueIDFails() { 
    System.out.println("TEST ");
    
  }
  @Test (expected = Exception.class)
  public void addingUserWithNonUniqueNameFails() { 
    System.out.println("TEST ");
    
  }
*/
  @Test
  public void getTitleReturnsTitle() { 
    System.out.println("TEST 1");
    assertEquals(myTitle1, myBook1.getTitle());     
  }

  @Test
  public void getAuthorReturnsAuthor() { 
    System.out.println("TEST 2");
    assertEquals(myAuthor1, myBook1.getAuthor());     
  }

  @Test
  public void getNameReturnsName() { 
    System.out.println("TEST 4");
    assertEquals(myName1, myUser1.getName());     
  }

  @Test
  public void getIDReturnsID() { 
    System.out.println("TEST 5");
    myUser1.setID(myID1);
    assertEquals(myID1, myUser1.getID());     
  }

  @Test
  public void getLibraryReturnsLibraryName() { 
    System.out.println("TEST 6");
    when(myMockLibrary1.getName()).thenReturn(myMockLibraryName1);
    myUser1.register(myMockLibrary1);
    assertEquals(myMockLibraryName1, myUser1.getLibrary());
  }

  @Test
  public void registerReturnsUserID() { 
    System.out.println("TEST 7");
    //when(myMockLibrary1.generateUserID()).thenReturn(myID1);
    //assertEquals(myID1, myUser1.register(myMockLibrary1));
    int myID1 = 500;
    assertEquals(myID1, myUser1.register(myLibrary1));
  }

  @Test
  public void getNameReturnsLibraryName() { 
    System.out.println("TEST 8");
    assertEquals(myLibraryName1, myLibrary1.getName());

  }

  @Test
  public void testSetMaxBorrow() { 
    System.out.println("TEST 10");
    int newMax = myLibrary1.getMaxBorrow() + 1;
    myLibrary1.setMaxBorrow(newMax);
    assertEquals(newMax, myLibrary1.getMaxBorrow()); 
  }

/*
  @Test (expected = IllegalArgumentException.class)
  public void userNameNotUniqueThrowsException() { 
    System.out.println("TEST 11");
    myLibrary1.addUser(new UserImpl("Joe"));
    myLibrary1.addUser(new UserImpl("Joe"));
  }
*/

/*
  @Test
  public void addingUserWithUniqueNamesReturnsUniqueUserIDs() { 
    System.out.println("TEST 12");
    User u1 = new UserImpl("name 1");
    User u2 = new UserImpl("name 2");
    int id1 = myLibrary1.addUser(u1);
    int id2 = myLibrary1.addUser(u2);
    assertTrue(id1 != id2);
  }
*/

  @Test
  public void libraryGetIdAlwaysReturnsSameIdForParticularName() { 
    System.out.println("TEST 13");
    String name1 = "name 1";
    int id1 = myLibrary1.getID(name1);
    int id2 = myLibrary1.getID(name1);
    assertEquals(id1, id2);
  }

  @Test
  public void libraryGetIDReturnsUniqueIDsforUniqueNames() { 
    System.out.println("TEST 14");
    String name1 = "name 1";
    String name2 = "name 2";
    int id1 = myLibrary1.getID(name1);
    int id2 = myLibrary1.getID(name2);
    assertTrue(id1 != id2);
  }

  @Test
  public void canTakeAvailableBook() { 
    System.out.println("TEST 16");
    myLibrary1.addBook(myTitle1, myAuthor1);
    //Book b = myLibrary1.takeBook(myTitle1);
    //if (b == null) System.out.println("yoda");
    assertEquals(myTitle1, myLibrary1.takeBook(myTitle1).getTitle());
  }

  @Test
  public void cantTakeTakenBook() { 
    System.out.println("TEST 17");
    myLibrary1.addBook(myTitle1, myAuthor1);
    myLibrary1.takeBook(myTitle1);
    assertNull(myLibrary1.takeBook(myTitle1)); 
  }

  @Test
  public void canTakeReturnedBook() { 
    System.out.println("TEST 18");
    myLibrary1.addBook(myTitle1, myAuthor1);
    Book book = myLibrary1.takeBook(myTitle1);
    assertNull(myLibrary1.takeBook(myTitle1)); 
    myLibrary1.returnBook(book);
    assertEquals(book, myLibrary1.takeBook(myTitle1));
    assertNull(myLibrary1.takeBook(myTitle1)); 
  }

  @Test
  public void canReturnABook() { 
    System.out.println("TEST 19");
    myLibrary1.addBook(myTitle1, myAuthor1);
    Book book = myLibrary1.takeBook(myTitle1);
    assertTrue(myLibrary1.returnBook(book));
  }

  @Test
  public void getReaderCountReturnsCorrectSize() { 
    System.out.println("TEST 20");
    int count = 50;
    for(int i=0; i<count; ++i) { 
      myLibrary1.getID("name" + i);
    }
    assertEquals(count, myLibrary1.getReaderCount());
  }

  @Test
  public void getBookCountReturnsCorrectSize() { 
    System.out.println("TEST 21");
    int count = 50;
    for(int i=0; i<count; ++i) { 
      myLibrary1.addBook("title" + i, "author" + 1);
    }
    assertEquals(count, myLibrary1.getBookCount());
  }

  @Test
  public void getBorrowedBookCountReturnsCorrectSize() { 
    System.out.println("TEST 22");
    int count = 50;
    for(int i=0; i<count; ++i) { 
      String title = "title" + i;
      String author = "author" + i;
      // System.out.println("adding: " + title + ", " + author);
      myLibrary1.addBook(title, author);
    }
    int count2 = 25;
    for(int j=0; j<count2; ++j) { 
      System.out.println("yoda: " + j);
      String title = "title" + j;
      myLibrary1.takeBook(title);
    }
    assertEquals(count2, myLibrary1.getBookBorrowedCount());
  }
}
