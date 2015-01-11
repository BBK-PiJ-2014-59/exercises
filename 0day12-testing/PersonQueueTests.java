import org.junit.*;
import static org.junit.Assert.*;

public class PersonQueueTests { 

  PersonQueue myPersonQueue; 
  Person myPerson;
  String myName;

  Person myPerson2;
  String myName2;

  @Before
  public void buildUp() { 
    myPersonQueue = new ListPersonQueue();
    myName = "Jesse";
    myPerson = new Person(myName);
    myName2 = "Fred";
    myPerson2 = new Person(myName2);
  }

  @Test
  public void retrieveFromNewQueueReturnsNull() { 
    System.out.println("TEST 1");
    assertNull(myPersonQueue.retrieve());
  }

  @Test
  public void retrieveFromEmptiedQueueReturnsNull() { 
    System.out.println("TEST 2");
    myPersonQueue.insert(myPerson);
    myPersonQueue.retrieve();
    assertNull(myPersonQueue.retrieve());
  }

  @Test
  public void insertOnePersonIntoNewQueueAndGetSamePersonBack() { 
    System.out.println("TEST 3");
    myPersonQueue.insert(myPerson);
    assertEquals(myPerson,myPersonQueue.retrieve());
  }

  @Test
  public void insertTwoPeopleAndGetThemBackInRightOrder() { 
    System.out.println("TEST 4");
    myPersonQueue.insert(myPerson);
    myPersonQueue.insert(myPerson2);
    assertEquals(myPerson,myPersonQueue.retrieve());
    assertEquals(myPerson2,myPersonQueue.retrieve());
    assertNull(myPersonQueue.retrieve());
  }

}
