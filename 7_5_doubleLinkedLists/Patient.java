public class Patient {
  private String name;
  private int age;
  private String illness;
  private Patient nextPatient;
  private Patient prevPatient;

  public Patient(String name, int age, String illness) {
   this.name = name;
   this.age = age;
   this.illness = illness;
   this.nextPatient = null;
   this.prevPatient = null;
  }

  public Patient getNext() { return nextPatient; }
  public Patient getPrev() { return prevPatient; }
  public void setNext(Patient p) { nextPatient = p; }
  public void setPrev(Patient p) { prevPatient = p; }
  public void showPatient() {
    System.out.println(name + ", " + age + ", " + illness);
  }

  // print patient, return patient.prevPatient;
  public void printBackwards() {
    Patient temp = this;
    while (temp != null) {
      temp.showPatient();
      temp = temp.getPrev(); 
    }
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
    // this.nextPatient.showPatient();
    // System.out.println("yoda");
    
    if (this.nextPatient == null) { 
      // this is last node (or there are none?)
      this.prevPatient.nextPatient = null;
      return true;
    } else if (this.nextPatient.name.equals(patient.name)) {
      // System.out.println("hamish");
      // this.showPatient();
      // System.out.println("hamish");
      this.nextPatient.prevPatient = this;
      this.nextPatient = nextPatient.nextPatient;
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
