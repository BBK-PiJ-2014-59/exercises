import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LibraryTests { 
  String myTitle1;
  String myAuthor1;
  Book myBook1;

  @Before
  public void buildUp() { 
    myTitle1 = "title1";
    myAuthor1 = "author1";
    myBook1 = new BookImpl("title1", "author1");
  }

  @Test
  public void getTitleReturnsTitle() { 
    assertEquals(myTitle1, myBook1.getTitle());     
  }
}
