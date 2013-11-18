// 5 Doubly-linked lists A doubly-linked list is a dynamic list in which each element is connected to two other elements instead of just one.  The one before and the one after it. In this exercise, you must create a doubly-linked list using the “hospital and patients” example as a starting point.  1. Create the doubly-linked list and add several elements to it (around 10 is fine).  2. Traverse it forwards and backwards printing out the content of each element.  3. Delete a couple of elements from the list.  4. Traverse it forwards and backwards printing out the content of each element.  5. Add a new element to the list. Try to delete an element that is NOT in the list.  6. Traverse it forwards and backwards printing out the content of each element.  Hint: First you need to add a new field to Patient for the pointer going “backwards”. Then you need to modify the add and delete methods to make sure you do not have loose pointers.

public class Patient {
  private String name;
  private int age;
  private String illness;
  private Patient nextPatient;
  private Patient prevPatient;

  public Patient getNext() { return nextPatient; }
  public Patient getPrev() { return prevPatient; }
  public void setNext(Patient p) { nextPatient = p; }
  public void setPrev(Patient p) { prevPatient = p; }


  // print patient, return patient.prevPatient;
  public void printBackwards() {
    Patient temp = this;
    while (temp != null) {
      temp.showPatient();
      temp = temp.getPrev(); 
    }
  }

  public Patient(String name, int age, String illness) {
   this.name = name;
   this.age = age;
   this.illness = illness;
   this.nextPatient = null;
   this.prevPatient = null;
  }

  public void showPatient() {
    System.out.println(name + ", " + age + ", " + illness);
  }

  public void showNth(int position) {
    nth(position).showPatient();
  }

//  public void addPatient(Patient newPatient) {
//    if (this.nextPatient == null) {
//      this.nextPatient = newPatient;
//    } else {
//      this.nextPatient.addPatient(newPatient);
//    } 
//  }
  
  // append newPatient
  public void addPatient(Patient newPatient) { 
    if (this.nextPatient == null) {
      this.nextPatient = newPatient;
      this.nextPatient.prevPatient = this;
    } else {
      this.nextPatient.addPatient(newPatient);
      this.nextPatient.nextPatient.prevPatient = this.nextPatient;
    } 
  }
  
  // how about a method insertAfterPosition(int position) ??

  public void deleteNthPatient(int position) {
    deletePatient(nth(position));
  }

//  public boolean deletePatient(Patient patient) {
//    if (this.nextPatient == null) {
//      return false;
//    } else if (this.nextPatient.name.equals(patient.name)) {
//      this.nextPatient = nextPatient.nextPatient;
//      return true;
//    } else {
//      return this.nextPatient.deletePatient(patient);
//    }
//  }

  public boolean deletePatient(Patient patient) {
    if (this.nextPatient == null) { 
      // this is last node (or there are none?)
      this.prevPatient.nextPatient = null;
      return true;
    } else if (this.nextPatient.name.equals(patient.name)) {
      this.nextPatient = nextPatient.nextPatient;
      this.nextPatient.prevPatient = this;
      return true;
    } else {
      return this.nextPatient.deletePatient(patient);
    }
  }

  public Patient nth(int position) { // counting from 1
    if (position == 1) {
      return this;
    } else if ((position < 1) || (nextPatient == null)) {
      return null;
    } else {
      return nextPatient.nth(position - 1);
    }
  }
}
