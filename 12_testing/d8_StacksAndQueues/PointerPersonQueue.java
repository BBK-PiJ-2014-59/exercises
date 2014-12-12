/** 
    * 1 Supermarket queue
    * Use the interface PersonQueue that represents a queue of people 
    * waiting at the supermarket and then implement it. You can use the 
    * definition and the implementations of StringStack as a guide. 
    * You can reuse any version of class Person from past days. For 
    * example, depending on your implementation, you may want to use 
    * a version of Person with or without internal pointers.  Then 
    * create a class Supermarket that has two methods: 
    * addPerson(Person) and servePerson(). These methods must call 
    * the appropriate methods of PersonQueue.
*/

public class PointerPersonQueue implements PersonQueue {

  private Person queueBack; 
  private Person queueFront; 

  public PointerPersonQueue() {
    queueBack = null;
    queueFront = null;
  } 

  public void insert (Person person) {
    /** Adds another person to the queue. */
    // stack: >>(push) <<(pop) * -> * -> * 
    // queue: >>(insert) * -> * -> * >>(retrieve) 
    if (queueBack == null) {
      queueBack = person;
      queueFront = person;
    } else {
      person.setNext(queueBack);
      queueBack = person;
    } 
  }

  public Person retrieve() {
    Person ret = null;
    if (queueFront == queueBack) {
      ret = queueFront;
      queueFront = null;
      queueBack = null;
    } else if (queueFront == null) {
      ret = null;
    } else {
      ret = queueFront;
      //queueFront = queueBack;
      Person cur = queueBack;
      while (cur.getNext() != queueFront) {
        System.out.println("YODA");
        cur = cur.getNext();
      }
      queueFront = cur;
    }
    //System.out.println("retrieved: " + ret.getName());
    if (ret != null) {
      System.out.println("retrieved: " + ret.getName());
    } else { 
      System.out.println("retrieved: " + null);
    }
    return ret;
  }

  public static void main(String[] args) {
    PersonQueue pq = new PersonQueuePointer();
    Person p1;
    Person p2;
    Person p3;
    p1 = new Person("Yoda");
    p2 = new Person("Hamish");
    p3 = new Person("Billy");
    pq.insert(p1);
    pq.insert(p2);
    Person r1 = pq.retrieve();
    System.out.println(r1);
  }

}
