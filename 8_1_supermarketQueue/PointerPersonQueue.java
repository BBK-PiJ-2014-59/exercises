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

  private Person queueFront;

  public PointerPersonQueue() {
    queueFront = null;
  } 

  public void insert (Person person) {
  /** Adds another person to the queue. */
  // stack: >>(push) <<(pop) * -> * -> * 
  // queue: >>(insert) * -> * -> * >>(retrieve) 
    if (queueFront != null) {
      person.setNext(queueFront);
    } 
    queueFront = person;
  }

  public Person retrieve() {
  /** Removes a person from the queue. */
  //    2*      1*
  //    1*
    Person cur = queueFront;
    Person last = null;
    if (cur.getNext() == null) {
      queueFront = null; 
      return cur;
    }
    else do {
      // System.out.println(cur.getName());
      last = cur;
      cur = cur.getNext();
    } while (cur.getNext() != null);
    last.setNext(null);
    return cur;
  }
}
