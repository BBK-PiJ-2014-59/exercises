import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class LibraryTests { 
  private String myTitle1;
  private String myAuthor1;
  private Book myBook1;
  private User myUser1;
  private String myName1;
  private int myID1;
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

    myLibrary1 = mock(Library.class);
    myLibraryName1 = "Library name";
  }

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
    when(myLibrary1.getName()).thenReturn(myLibraryName1);
    myUser1.register(myLibrary1);
    assertEquals(myLibraryName1, myUser1.getLibrary());
  }

  @Test
  public void registerReturnsUserID() { 
    System.out.println("TEST 7");
    when(myLibrary1.generateUserID()).thenReturn(myID1);
    assertEquals(myID1, myUser1.register(myLibrary1));
  }

/*
  // some Library tests to write later...

  @Test (expected = Exception.class)
  public void addingUserWithNonUniqueIDFails() { 
    System.out.println("TEST ");
    
  }
  @Test (expected = Exception.class)
  public void addingUserWithNonUniqueNameFails() { 
    System.out.println("TEST ");
    
  }
*/

}
