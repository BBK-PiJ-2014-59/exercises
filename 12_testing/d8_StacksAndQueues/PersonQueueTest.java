import org.junit.*;
import static org.junit.Assert.*;

public class PersonQueueTest {

  PersonQueue pq;
  PersonQueue pq6_2_3;
  Person p1;
  Person p2;
  Person p3;
  Person p4;
  Person p5;
  Person p6;

  @Before

  // TODO: make len settable from here
  public void buildUp() {
    //pq = new PointerPersonQueue();
    pq = new ArrayPersonQueue();
    /*
    p1 = new Person("Yoda");
    p2 = new Person("Hamish");
    p3 = new Person("Billy");
    */
    p1 = new ArrayPerson("Yoda");
    p2 = new ArrayPerson("Hamish");
    p3 = new ArrayPerson("Billy");
    p4 = new ArrayPerson("Silke");
    p5 = new ArrayPerson("Mary");
    p6 = new ArrayPerson("Darth");

    pq6_2_3 = new ArrayPersonQueue(); // 6 long, 2 left, 3 right
  

  }

  @Test
  public void testsRetrieveFromEmptyQueue() { 
    System.out.println("\n\ntestsRetrieveFromEmptyQueue");
    assertNull(pq.retrieve());
  }
  
  @Test 
  public void testsInsertAndRetrieve() { 
    System.out.println("\n\ntestsInsertAndRetrieve");
    pq.insert(p1);
    assertEquals(p1, pq.retrieve());
    assertNull(pq.retrieve());
  }

  @Test
  public void testsQueueOfOne() {
    System.out.println("\n\ntestsQueueOfOne");
    pq.insert(p1);
    pq.insert(p2);
    Person r1 = pq.retrieve();
    assertEquals(p1, r1);
    //System.out.println("RETRIEVE 2");
    Person r2 = pq.retrieve();
    assertEquals(p2, r2);
    assertNull(pq.retrieve());
  }

  @Test
  public void testsQueueOfTwo() {
    System.out.println("\n\ntestsQueueOfTwo");
    // System.out.println("YODA" + pq.getLength());
    pq.insert(p1);
    pq.insert(p2);
    pq.insert(p3);
    assertEquals(p1, pq.retrieve());
    assertEquals(p2, pq.retrieve());
    assertEquals(p3, pq.retrieve());
    assertNull(pq.retrieve());
  }

  @Test
  public void testsReserveMoreMemory() { 
    // todo: make this test any length of array
    System.out.println("\n\ntestsReservesMoreMemory");
  //  for (int i = 0; i < getPersonArrayLength(); i++) { 
    pq.insert(p1);
    pq.insert(p2);
    pq.insert(p3);
    pq.insert(p4);
    pq.insert(p5);
    pq.insert(p6);
    assertEquals(p1, pq.retrieve()); // FAILS
    // PASSES if INITIAL_ARRAY_SIZE > numTestObjects
  }

  @Test
  public void testsAlternatingInsertAndRetrieve() {
    System.out.println("\n\ntestsAlternatingInsertAndRetrieve");
    // int a = 2*pq.getPersonArrayLength();
    int a = 20;
    for (int i = 0; i < a; i++) { 
      pq.insert(p1);
      assertEquals(p1, pq.retrieve());
      assertNull(pq.retrieve());
    }
  }

  @Test
  public void testsAlternatingInsertAndRetrieve2() {
    System.out.println("\n\ntestsAlternatingInsertAndRetrieve2");
    pq.insert(p1);
    pq.insert(p2);
    pq.insert(p3);
    assertEquals(p1, pq.retrieve());
    assertEquals(p2, pq.retrieve());
    assertEquals(p3, pq.retrieve());
    assertNull(pq.retrieve());
    pq.insert(p1);
    assertEquals(p1, pq.retrieve()); 
  }

  @Test
  public void testsBeforeReserveMoreMemory() {
    System.out.println("\n\ntestsBeforeReserveMoreMemory");
  }

  @Test
  public void testsAfterReserveMoreMemory() {
    System.out.println("\n\ntestsAfterReserveMoreMemory");
  }

  @Test
  public void testsDoesntWasteSpace() { // ie if we keep alternating insert-retrieve will it shift/double?
    System.out.println("\n\ntestsDoesntWasteSpace");
  }

  /*
  @Test
  public void tests() {
    System.out.println("\n\ntests");
  }
  */
}
