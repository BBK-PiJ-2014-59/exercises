import org.junit.*;
import static org.junit.Assert.*;

public class PersonQueueTest {

  PersonQueue pq;
  ArrayPersonQueue pq2; // FOR TESTING ONLY 
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

    pq2 = new ArrayPersonQueue(); // 6 long, 2 left, 3 right
    //pq2.personArray = {p1, p2, null, p3, p4, p5}; 
    pq2.personArray[0] = p1;
    pq2.personArray[1] = p2;
    pq2.personArray[2] = null;
    pq2.personArray[3] = p3;
    pq2.personArray[4] = p4;
    pq2.personArray[5] = p5;
    pq2.front = 1;
    pq2.back = 2; 

    /*
    pq2:
     0  1  2  3  4  5
    |p1|p2|  |p3|p4|p5|
        f  b
    */
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
    /*
    pq2:
     0  1  2  3  4  5
    |p1|p2|  |p3|p4|p5|
        f  b
    */
    assertEquals(p2, pq2.retrieve()); 
    /*
    |p1|  |  |p3|p4|p5|
     f     b
    */
    assertEquals(pq2.personArray[0], p1);
    pq2.insert(p2); 
    /*
    |p1|  |p2|p3|p4|p5|
     f  b
    */
    assertEquals(pq2.personArray[0], p1);
    assertEquals(pq2.personArray[1], null);
    assertEquals(pq2.personArray[2], p2);
    assertEquals(pq2.personArray[3], p3);
    assertEquals(pq2.personArray[4], p4);
    assertEquals(pq2.personArray[5], p5);
    pq2.insert(p6); 
    /*
    after reserve:
     0  1  2  3  4  5  6  7  8  9  10 11
    |p2|p3|p4|p5|p1|  |  |  |  |  |  |  |
                 f                    b 

    after insert:
     0  1  2  3  4  5  6  7  8  9  10 11
    |p2|p3|p4|p5|p1|  |  |  |  |  |  |p6|
                 f                 b 
    */
    assertEquals(pq2.personArray[0], p2);
    assertEquals(pq2.personArray[1], p3);
    assertEquals(pq2.personArray[2], p4);
    assertEquals(pq2.personArray[3], p5); 
    assertEquals(pq2.personArray[4], p1); 
    assertEquals(pq2.front, 4); // FAIL
    assertEquals(p1, pq2.retrieve());
    assertEquals(p5, pq2.retrieve());
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
