import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTests {
  
  static int testno = 0;
  Book book;
  String myTitle1;
  String myAuthorName1;

  User u1; 
  User u2; 
  User u3; 

  Users users;

  @Before
  public void buildUp() {

    u1 = new UserImpl("Jesse");
    u1.setID(123);
    u2 = new UserImpl("Sara");
    myTitle1 = "Huckleberry Finn";
    myAuthorName1 = "Mark Twain";
    book = new BookImpl(myTitle1, myAuthorName1);
    users = new UsersImpl();

  }

  @Test
  public void testBookGetTitle() {
    System.out.println("\n\nTEST 1");
    assertEquals(book.getTitle(), myTitle1);
  }

  @Test
  public void testBookGetAuthorName() {
    System.out.println("\n\nTEST 2");
    System.out.println("TEST " + testno++);
    assertEquals(book.getAuthorName(), myAuthorName1);
  }
  
  @Test
  public void testUniqUserID() {
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
  public void testUniqUserName() {
    System.out.println("\n\nTEST 4");
    assertEquals(true, users.add(u1));
    u3 = new UserImpl("Jesse");
    u3.setID(126);
    assertEquals(false, users.add(u3));
  } 

}
