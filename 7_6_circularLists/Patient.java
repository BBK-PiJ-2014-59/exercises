public class Patient {
  private String name;
  private int age;
  private String illness;
  private Patient nextPatient;

  public Patient(String name, int age, String illness) {
   this.name = name;
   this.age = age;
   this.illness = illness;
   this.nextPatient = null;
  }

  public Patient getNext() { return nextPatient; }
  public void setNext(Patient p) { nextPatient = p; }
  public String getName() { return name; }

  public void insertAfter(Patient newPatient) {
    if (this.nextPatient == this) {
      // this means this is the only patient in the list
      this.nextPatient = newPatient;
      newPatient.nextPatient = this;
    } else {
      newPatient.nextPatient = this.nextPatient;   
      this.nextPatient = newPatient; 
    }
  } 
}
