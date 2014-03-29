public class Person {
  String name;
  Person next;

  public Person(String name) {
    this.name = name;
  }

  public void setNext(Person person) {
    this.next = person;
  }

  public Person getNext() {
    return this.next;
  }

  public String getName() {
    return name;
  }
}
