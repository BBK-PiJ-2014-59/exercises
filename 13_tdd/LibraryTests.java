import org.junit.*;
import static org.junit.Assert.*;

public class LibraryTests {
  
  Book book;
  String myTitle1;
  String myAuthorName1;

  User u1; 
  User u2; 

  @Before
  public void buildUp() {

    myTitle1 = "Huckleberry Finn";
    myAuthorName1 = "Mark Twain";
    book = new BookImpl(myTitle1, myAuthorName1);

  }

  @Test
  public void testBookGetTitle() {
    assertEquals(book.getTitle(), myTitle1);
  }

  @Test
  public void testBookGetAuthorName() {
    assertEquals(book.getAuthorName(), myAuthorName1);
  }
  
  @Test
  public void testUniqUserID() {
    u1 = new User("Jesse");
    u2 = new User("Sara");
    assertEquals(u1.setID(123), true);
    assertEquals(u2.setID(123), false);
    assertEquals(u2.setID(124), true);
  } 

  @Test
  public void testUniqUserName() {
    u1 = new User("Jesse");
    u2 = new User("Jesse");
  } 

}
