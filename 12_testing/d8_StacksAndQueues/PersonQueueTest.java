import org.junit.*;
import static org.junit.Assert.*;

public class PersonQueueTest {

  PersonQueue pq;
  Person p1;
  Person p2;

  @Before
  public void buildUp() {
    pq = new PersonQueuePointer();
    p1 = new Person("Yoda");
    p2 = new Person("Hamish");
  }

  @Test
  public void testsInsertAndRetrieve() {
    assertNull(pq.retrieve());

    pq.insert(p1);
    assertEquals(p1, pq.retrieve());
    assertNull(pq.retrieve());

    /*
    pq.insert(p1);
    pq.insert(p2);
    assertEquals(p1, pq.retrieve());
    assertEquals(p2, pq.retrieve());
    assertNull(pq.retrieve());
    */
  }

}
