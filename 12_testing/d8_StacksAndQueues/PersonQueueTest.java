import org.junit.*;
import static org.junit.Assert.*;

public class PersonQueueTest {

  PersonQueue pq;
  Person p1;
  Person p2;
  Person p3;

  @Before
  public void buildUp() {
    pq = new PointerPersonQueue();
    p1 = new Person("Yoda");
    p2 = new Person("Hamish");
    p3 = new Person("Billy");
  }

  @Test
  public void testsEmptyQueue() { 
    assertNull(pq.retrieve());
    pq.insert(p1);
    assertEquals(p1, pq.retrieve());
    assertNull(pq.retrieve());
  }

  @Test
  public void testsQueueOfOne() {
    pq.insert(p1);
    pq.insert(p2);
    System.out.println("RETRIEVE 1");
    Person r1 = pq.retrieve();
    assertEquals(p1, r1);
    System.out.println("RETRIEVE 2");
    Person r2 = pq.retrieve();
    assertEquals(p2, r2);
    assertNull(pq.retrieve());
  }

  @Test
  public void testsQueueOfTwo() {
    pq.insert(p1);
    pq.insert(p2);
    pq.insert(p3);
    assertEquals(p1, pq.retrieve());
    assertEquals(p2, pq.retrieve());
    assertEquals(p3, pq.retrieve());
    assertNull(pq.retrieve());
  }



    /*
    pq.insert(p1);
    pq.insert(p2);
    assertEquals(p1, pq.retrieve());
    assertEquals(p2, pq.retrieve());
    assertNull(pq.retrieve());
    */

}
