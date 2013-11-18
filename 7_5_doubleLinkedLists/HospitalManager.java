public class HospitalManager {
  private Patient patientListStart = null;

  public void showPatients(Patient list) {
    while (list != null) {
      list.showPatient();
      list = list.getNext();
    } 
  }

  public int size(Patient patient) {
    int count = 0;
    while (patient != null) {
      patient = patient.getNext();
      ++count;
    }
    return count;
  }

  // delete Nth element

  public void launch() {
    Patient firstPatient = new Patient("1John", 33, "Tuberculosis");
    patientListStart = firstPatient;
    patientListStart.addPatient(new Patient("2Jane", 72, "liver cancer"));
    patientListStart.addPatient(new Patient("3Jim", 25, "HIV"));
    patientListStart.addPatient(new Patient("4Paul", 55, "Flu"));
    patientListStart.addPatient(new Patient("5Mary", 85, "Broken hip"));
    patientListStart.addPatient(new Patient("6Shep", 45, "Broken leg"));
    patientListStart.addPatient(new Patient("7Bob", 41, "Diabetes"));
    showPatients(patientListStart);
    System.out.println();
    patientListStart.nth(size(patientListStart)).printBackwards();
    System.out.println();
    // System.out.println(size(patientListStart));
    // patientListStart.nth(7).showPatient();
    // patientListStart.nth(7).printBackwards();
    // patientListStart.showNth(1);
    //System.out.println(size(patientListStart));
    patientListStart.deleteNthPatient(3);
    showPatients(patientListStart);
    System.out.println();
    patientListStart.nth(size(patientListStart)).printBackwards();
    System.out.println();
    // patientListStart.showNth(1); // why doesn't this work? draw picture.
    // patientListStart = patientListStart.nth(2); 
    // System.out.println(size(patientListStart));
    // patientListStart.showNth(1);
    // patientListStart.showNth(2);
  }

  public static void main(String[] args) {
    HospitalManager hm = new HospitalManager();
    hm.launch();
  }
}
