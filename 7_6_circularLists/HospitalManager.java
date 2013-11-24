// 6 Circular lists A circular list is a dynamic list in which there is a beginning but there is no end: the last element is pointing back to the first element. Circular lists can be singly- or doubly-linked. In this exercise, you must create a singly-linked circular list using the “hospital and patients” example as a starting point.

public class HospitalManager {
  private Patient patientListStart = null;

  public void traverse(Patient p) {
    Patient start = p;
    do {
      printPat(p);
      p = p.getNext();
    } while (p != start);
    System.out.println();
  }

  public boolean delNext(Patient p) {
    if (p == null) {
      return false;
    } else if (p.getNext() == p) {
      p.setNext(null);
      p = null;
    } else {
      p.setNext(p.getNext().getNext());
    }  
    return true;
  }

  public boolean del(Patient p, Patient first) {
    if (first == null) {
      return false;
    } else {
      Patient temp = first;
      do {
        if (temp.getNext() == p) {
          return delNext(temp);
        } else {
          temp = temp.getNext(); 
        } 
      } while (temp != first);
    }
    return false;
  }

  public void printPat(Patient p) {
    System.out.println(p.getName()); 
  }

  public void launch() {
  
    // 1. Create the circular list and add several elements to it (around 10 is fine).
    Patient firstPatient = new Patient("1John", 33, "tuberculosis");
    patientListStart = firstPatient;
    patientListStart.setNext(patientListStart);
    patientListStart.insertAfter(new Patient("6Billy", 39, "snakebite"));
    patientListStart.insertAfter(new Patient("5Roxette", 29, "broken heart"));
    patientListStart.insertAfter(new Patient("4Bob", 44, "stiff neck"));
    patientListStart.insertAfter(new Patient("3Judy", 22, "chicken pox"));
    patientListStart.insertAfter(new Patient("2Bubba", 52, "smallpox"));

    // 2. Traverse it forwards for one complete loop. While you go around the list, print out the content of each element.  How do you know that you have reached the end of the list when you never find a null pointer?
    traverse(patientListStart);

    // 3. Delete a couple of elements from the list.
    delNext(patientListStart);
    delNext(patientListStart);

    // 4. Traverse it again printing out the content of each element.
    traverse(patientListStart);

    // 5. Add a new element to the list. Try to delete an element that is NOT in the list.
    patientListStart.insertAfter(new Patient("3Judy", 22, "chicken pox"));
    traverse(patientListStart);
    del(null, patientListStart);

    // 6. Traverse it again printing out the content of each element
    traverse(patientListStart);

  }

  public static void main(String[] args) {
    HospitalManager hm = new HospitalManager();
    hm.launch();
  }
}
