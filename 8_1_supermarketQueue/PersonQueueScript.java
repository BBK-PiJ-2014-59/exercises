public class PersonQueueScript {
  public static void main(String[] args) {
    PersonQueueScript script = new PersonQueueScript();
    script.launch();
  }

  public void launch() {
    PersonQueue firstInQueue = new PointerPersonQueue();
    testQueue(firstInQueue);
  }

  private void testQueue(PersonQueue firstPerson) {
    System.out.println("Testing the queue...");
    firstPerson.insert(new Person("1John"));
    firstPerson.insert(new Person("2Mary"));
    firstPerson.insert(new Person("3Jane"));
    firstPerson.insert(new Person("4Bill"));
    System.out.println();
    System.out.println(firstPerson.retrieve().getName());
    System.out.println(firstPerson.retrieve().getName());
    System.out.println(firstPerson.retrieve().getName());
    System.out.println(firstPerson.retrieve().getName());
    /**
    firstPerson.retrieve();
    firstPerson.insert(new Person("5Tom"));
    firstPerson.insert(new Person("6Dick"));
    firstPerson.insert(new Person("7Harry"));
    */
    /**
    System.out.println("Now let's see all the elements in the queue: ");
    while (!personQueue.isEmpty()) {
      System.out.println("Next element: '" + personQueue.retrieve() + "'");
    } 
    */
  }
}
