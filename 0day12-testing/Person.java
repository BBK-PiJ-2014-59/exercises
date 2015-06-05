public class Person { 
  private String name;
  private Person nextPerson;

  public Person(String name) { 
    this.name = name;
    nextPerson = null;
  }

  public void setNext(Person p) { 
    nextPerson = p;
  }

  public Person getNext() { 
    return nextPerson;
  }
}
