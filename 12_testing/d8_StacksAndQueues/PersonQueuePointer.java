public class PersonQueuePointer implements PersonQueue {

  public void insert(Person person) {
  }

  public Person retrieve() {
    return null; 
  }

  public static void main(String[] args) {
    PersonQueue pq = new PersonQueuePointer();
  }
}
