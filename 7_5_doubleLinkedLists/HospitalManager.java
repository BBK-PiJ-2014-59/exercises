// 5 Doubly-linked lists A doubly-linked list is a dynamic list in which each element is connected to two other elements instead of just one.  The one before and the one after it. In this exercise, you must create a doubly-linked list using the “hospital and patients” example as a starting point.  





// Hint: First you need to add a new field to Patient for the pointer going “backwards”. Then you need to modify the add and delete methods to make sure you do not have loose pointers.

public class HospitalManager {
  private Patient patientListStart = null;

  public void showPatients(Patient list) {
    while (list != null) {
      list.showPatient();
      list = list.getNext();
    } 
  }

  public Patient getEnd(Patient p) {
    while (p.getNext() != null) {
      p = p.getNext();
    }
    // p.showPatient();
    return p;
  }

  public Patient nthPat(int pos, Patient first) {
    int s = size(first);
    if (pos > s || first == null) {
      return null;
    } else {
      int i = 1;
      while (i < pos) {
        first = first.getNext(); 
        ++i;
      }
    }
    return first;
  }

  public int size(Patient patient) {
    int count = 0;
    while (patient != null) {
      patient = patient.getNext();
      ++count;
    }
    return count;
  }

  public boolean delPat(Patient p) {
    if (p == null) { // I'm null
      return false;
    } else if (p.getPrev() == null && p.getNext() == null) { // just me left - BROKEN?
        // HospitalManager.patientListStart = null; 
        p = null; 
    } else if (p.getNext() != null && p.getPrev() == null) { // someone ahead of me but not behind me
      patientListStart = p.getNext(); 
      p.getNext().setPrev(null);
      p.setNext(null);
    } else if (p.getNext() != null && p.getPrev() != null) { // someone ahead of and behind me
      p.getPrev().setNext(p.getNext());
      p.getNext().setPrev(p.getPrev());
      p.setNext(null);
      p.setPrev(null); 
    } else if (p.getPrev() != null && p.getNext() == null) { // someone behind me but not ahead of me
      p.getPrev().setNext(null);
      p.setPrev(null);
    }
    return true;
  }

  public void launch() {

    // 1. Create the doubly-linked list and add several elements to it (around 10 is fine).  

    Patient firstPatient = new Patient("1John", 33, "Tuberculosis");
    Patient endPatient = null;
    patientListStart = firstPatient;
    patientListStart.addPatient(new Patient("2Jane", 72, "liver cancer"));
    patientListStart.addPatient(new Patient("3Jim", 25, "HIV"));
    patientListStart.addPatient(new Patient("4Paul", 55, "Flu"));
    patientListStart.addPatient(new Patient("5Mary", 85, "Broken hip"));
    patientListStart.addPatient(new Patient("6Shep", 45, "Broken leg"));
    patientListStart.addPatient(new Patient("7Bob", 41, "Diabetes"));
    patientListStart.addPatient(new Patient("8Matilda", 42, "Dog bite"));
    patientListStart.addPatient(new Patient("9Maggy", 22, "Stroke"));
    patientListStart.addPatient(new Patient("10Izzy", 22, "Cirrhosis"));
    patientListStart.addPatient(new Patient("11Kirk", 42, "Brain tumor"));
    patientListStart.addPatient(new Patient("12Larry", 62, "Lung tumor"));

    // 2. Traverse it forwards and backwards printing out the content of each element.  
    System.out.println("Traverse and print forwards:\n");
    showPatients(patientListStart);
    System.out.println();
    System.out.println("Print backwards:\n");
    endPatient = getEnd(patientListStart);
    endPatient.printBackwards();
    System.out.println();

    // 3a. Delete a couple of elements from end of list.  
    boolean deleted = delPat(endPatient);
    endPatient = getEnd(patientListStart);
    deleted = delPat(endPatient);

    // 3b. Delete a couple elements at the beginning.
    deleted = delPat(patientListStart);
    deleted = delPat(patientListStart);

    // 3c. Delete a couple elements n elements into the list.
    int s = size(patientListStart);
    nthPat(2, patientListStart).showPatient();
    nthPat(3, patientListStart).showPatient();
    deleted = delPat(nthPat(2, patientListStart));
    deleted = delPat(nthPat(2, patientListStart));
    System.out.println("size: " + s);

    // 4. Traverse it forwards and backwards printing out the content of each element.  
    if (deleted) {
      System.out.println("Traverse and print forwards:\n");
      showPatients(patientListStart);
      System.out.println();
      System.out.println("Print backwards:\n");
      endPatient = getEnd(patientListStart);
      endPatient.printBackwards();
      System.out.println();
    }

    // 5a. Add a new element to end of list. 
    // 5b. Try to delete an element that is NOT in the list.  
    // 5c. Add a new element at beginning. 
    // 5d. Add a new element a few in. 

    // 6. Traverse it forwards and backwards printing out the content of each element.  

  }

  public static void main(String[] args) {
    HospitalManager hm = new HospitalManager();
    hm.launch();
  }
}
