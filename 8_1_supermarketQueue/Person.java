// 1 Supermarket queue
// Use the interface PersonQueue that represents a queue of people waiting at the supermarket and then implement it. You can use the definition and the implementations of StringStack as a guide. You can reuse any version of class Person from past days. For example, depending on your implementation, you may want to use a version of Person with or without internal pointers.  Then create a class Supermarket that has two methods: addPerson(Person) and servePerson(). These methods must call the appropriate methods of PersonQueue.

public class Person {
  String name;
  Person next;
  
  public Person(String name) {
    this.name = name;
    next = null;
  }

  public String getName() { return name; }
  public void setNext(Person person) { next = person; }
  public Person getNext() { return next; }

} 
