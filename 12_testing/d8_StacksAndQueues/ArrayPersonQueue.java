/**
 * Implementation of interface PersonQueue using an array as support. 
 */
public class ArrayPersonQueue implements PersonQueue {

  /**
   * The array that contains the string. When full, a new one
   * is created.
   */
  //private ArrayPerson[] personArray;
  private Person[] personArray;

  /**
   * index of the front of the queue (ie where to take from) 
   */
  private int front;
  /**
   * index of the back of the queue (ie where to put one) 
   */
  private int back; 
  /**
   * The initial personArray.length of the array.
   */
  private static int INITIAL_ARRAY_SIZE = 5;

  public ArrayPersonQueue() {
    personArray = new ArrayPerson[INITIAL_ARRAY_SIZE];
    front = 0;
    back = 0;
  }

  protected int getPersonArrayLength() {
    return personArray.length;
  }

  /* 
  NOTE: how to implement? If insert to left, then must shift all to the right? Or reserve an array with
  space on both ends? Would this obviate shift need? Or as circular array? 
  */
  // public void insert(ArrayPerson person) {
  public void insert(Person person) {
    System.out.println("INSERT");
    if (isAlmostFull()) {
      reserveMoreMemory();
    }
    personArray[back] = person;
//return list.getHead() == null ? true : false;
    System.out.println("back 1: " + back);
    back = nextBack(); 
    System.out.println("back 2: " + back);
  }

  /*

  |  |  |  |  | 
   bf 

  |1 |  |  |  | 
   f        b 

  |1 |  |  |2 | 
   f     b 

  |  |  |  |2 | 
         b  f 

  */

  private int nextBack() {
    return back == 0 ? personArray.length - 1 : back - 1;
  }

  public Person retrieve() {
    System.out.println("RETRIEVE");
    if (isEmpty()) {
      return null;
    }
    Person result = personArray[front];
    personArray[front] = null;
    
    System.out.println("front 1: " + front);
    front = front > 0 ? front - 1 : personArray.length - 1; 
    System.out.println("front 2: " + front);
    return result;
  }

  // | |D|K|2|9| 
  //  b       f
  //
  // |R| |K|2|9| 
  //  f b      
  //
  // so if the next place b would go is f we're almost full...

  private boolean isAlmostFull() {
    return nextBack() == front ? true : false; 
  }

  private void reserveMoreMemory() {
    Person[] biggerArray = new ArrayPerson[personArray.length*2];
    for (int i = 0; i < personArray.length; i++) {
      biggerArray[i] = this.personArray[i];
    }
      this.personArray = biggerArray;
  }

  private boolean isEmpty() {
    return front == back;
  }

}
