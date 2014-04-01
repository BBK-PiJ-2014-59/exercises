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
   * current size of the array 
   */
  private int size; 

  /**
   * The initial size of the array.
   */
  private static int INITIAL_ARRAY_SIZE = 5;

  public ArrayPersonQueue() {
    personArray = new ArrayPerson[INITIAL_ARRAY_SIZE];
    front = 0;
    back = 0;
    size = personArray.length;
  }
  /* 
  NOTE: how to implement? If insert to left, then must shift all to the right? Or reserve an array with
  space on both ends? Would this obviate shift need? Or as circular array? 
  */
  // public void insert(ArrayPerson person) {
  public void insert(Person person) {
    /* if (isAlmostFull()) {
    reserveMoreMemory();
    }
    */
    personArray[back] = person;
//return list.getHead() == null ? true : false;
    back = back == 0 ? 0 : size - 1; 
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

  public Person retrieve() {
    /*
    if (isEmpty()) {
      return null;
    }
    */
    Person result = personArray[front];
    personArray[front] = null;
    
    front = front > 0 ? front - 1 : size - 1; 
    return result;
  }

  private boolean isAlmostFull() {
    if (personArray.length - front < 1) {
      return true;
    } else {
      return false;
    }
  }

}
