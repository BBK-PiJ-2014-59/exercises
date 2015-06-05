public class ListPersonQueue implements PersonQueue { 
  
  Person firstPerson;

  public ListPersonQueue() { 
    firstPerson = null;
  }

  @Override
  public void insert(Person person) { 
    System.out.println("INSERT");
    if (firstPerson == null)
      firstPerson = person;
    else { 
      System.out.println("hamish");
      person.setNext(firstPerson);
    }
  }

  @Override
  public Person retrieve() { 
    System.out.println("RETRIEVE");
    Person result;
    result = firstPerson;
    if (result != null) { 
      System.out.println("yoda");
      firstPerson = firstPerson.getNext();
      result.setNext(null);
    }
    System.out.println("hamish");
    return result;
  }
}
