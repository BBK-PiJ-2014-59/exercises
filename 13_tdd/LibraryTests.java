import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTests {
  
  Book book;
  String myTitle1;
  String myAuthorName1;

  User u1; 
  User u2; 
  User u3; 
  User u4; 

  Users users;

  Library myLibrary;
  String myLibName;

  @Before
  public void buildUp() {

    u1 = new UserImpl("Jesse");
    u1.setID(123);
    u2 = new UserImpl("Sara");
    myTitle1 = "Huckleberry Finn";
    myAuthorName1 = "Mark Twain";
    book = new BookImpl(myTitle1, myAuthorName1);
    users = new UsersImpl();
    myLibName = "UCL Library";
    myLibrary = new MockLibrary(myLibName);
    
  }

  @Test
  public void testBookGetTitle() {
    System.out.println("\n\nTEST 1");
    assertEquals(book.getTitle(), myTitle1);
  }

  @Test
  public void testBookGetAuthorName() {
    System.out.println("\n\nTEST 2");
    assertEquals(book.getAuthorName(), myAuthorName1);
  }
  
  @Test
  public void testUsersUniqUserID() {
    System.out.println("\n\nTEST 3");

    assertEquals(true, users.add(u1));

    u2.setID(123);
    assertEquals(false, users.add(u2));

    u3 = new UserImpl("Craig");
    u3.setID(124);
    assertEquals(true, users.add(u3));

    u2 = new UserImpl("Sara");
    u2.setID(125);
    assertEquals(true, users.add(u2));

    /*
    u2.setID(124);
    assertEquals(124, u2.getID());
    assertEquals(true, users.add(u2));
    */
  } 

  @Test
  public void testUsersUniqUserName() {
    System.out.println("\n\nTEST 4");
    assertEquals(true, users.add(u1));
    u3 = new UserImpl("Jesse");
    u3.setID(126);
    assertEquals(false, users.add(u3));
    u4 = new UserImpl("Craig");
    assertEquals(true, users.add(u4));
  } 

  @Test 
  public void testLibraryGetID_NoUsers() {
    System.out.println("\n\nTEST 7");
    assertEquals(100, myLibrary.getID("Bobby")); 
  }
  @Test
  public void testLibraryGetID_OneUser_Found() {
    System.out.println("\n\nTEST 8");
    myLibrary.getID("Bobby"); 
    assertEquals(100, myLibrary.getID("Bobby")); 
  }
  @Test
  public void testLibraryGetID_OneUser_NotFound() {
    System.out.println("\n\nTEST 9");
    myLibrary.getID("Bobby"); 
    assertEquals(101, myLibrary.getID("Jane")); 
    assertEquals(100, myLibrary.getID("Bobby")); 
    assertEquals(101, myLibrary.getID("Jane")); 
  }
  @Test
  public void testLibraryGetID_TwoUsers_NotFound() {
    System.out.println("\n\nTEST 10");
    myLibrary.getID("Bobby"); 
    assertEquals(101, myLibrary.getID("Jane")); 
    assertEquals(100, myLibrary.getID("Bobby")); 
    assertEquals(101, myLibrary.getID("Jane")); 
    assertEquals(102, myLibrary.getID("Cooter")); 
    assertEquals(102, myLibrary.getID("Cooter")); 
  }

}
