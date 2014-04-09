/**
 * Implementation of interface PersonQueue using an array as support. 
 */
public class ArrayPersonQueue implements PersonQueue {

  public static void main(String[] args) {
    // Person p = new ArrayPerson("Yoda");
    // PersonQueue q = new ArrayPersonQueue(); 
    // q.insert(p); 
    // p = q.retrieve(); 
    // System.out.println(hoo());
  }

  public ArrayPersonQueue() {
    personArray = new ArrayPerson[INITIAL_ARRAY_SIZE];
    front = 0;
    back = 0;
  }

  /**
   * The array that contains the people. When full, a new one
   * is created.
   */
  // private Person[] personArray; // TODO: create separate PersonArray class so you can have elem setter for testing purposes (as you don't want to make personArray public) and define length (as you don't want to make INITIAL_ARRAY_SIZE public). 
  public Person[] personArray; // TODO: create separate PersonArray class so you can have elem setter for testing purposes (as you don't want to make personArray public) and define length (as you don't want to make INITIAL_ARRAY_SIZE public). 

  /**
   * index of the front of the queue (ie where to take from) 
   */
  //private int front;
  public int front;
  /**
   * index of the back of the queue (ie where to put one) 
   */
  //private int back; 
  public int back; 
  /**
   * The initial personArray.length of the array.
   */
  private static int INITIAL_ARRAY_SIZE = 6;



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

  public int getLength() {
    return personArray.length;
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

  //  0 1 2 3 4
  // |R|a| |2|9| 
  //    f b     
  // |2|9|R|a| | | | | | |
  //        f           b 
  
  //  0 1 2 3 4
  // | |g|T|9|3|
  //  b       f
  // |g|T|9|3| | | | | | |
  //        f           b

  //  0 1 2 3 4
  // |7|g|T|9| |
  //        f b 
  // |7|g|T|9| | | | | | |
  //        f           b


  private void reserveMoreMemory() {
    System.out.println("START RESERVE");
    System.out.println("back 1: " + back);
    System.out.println("front 1: " + front);
    Person[] biggerArray = new ArrayPerson[personArray.length*2];
    System.out.println("big length: " + biggerArray.length);
    
    int newFront = 0;
    int i = 0;
      
    // loop1 
    if (back < personArray.length - 1) {
      //for (i = back+1, j = 0; i < personArray.length; i++, j++) {
      for (i = back+1, newFront = 0; i < personArray.length; i++, newFront++) {
        biggerArray[newFront] = personArray[i];
        System.out.println("i, newFront: " + i + ", " + newFront);
      }
      System.out.println("newFront 1: " + newFront);
    }

    // loop2 
    if (back > front) {
      for (; i <= front; i++) {
        biggerArray[i] = personArray[i];
      }
      System.out.println("newFront 2: " + newFront);
    }

    front = newFront;
    personArray = biggerArray;
    back = personArray.length - 1;
    System.out.println("back 2: " + back);
    System.out.println("front 2: " + front);
    System.out.println("END RESERVE");
  }

  private boolean isEmpty() {
    return front == back;
  }
}
