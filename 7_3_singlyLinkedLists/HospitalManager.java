public class HospitalManager {
  private Patient patientListStart = null;

  public void showPatients(Patient list) {
    while (list != null) {
      list.showPatient();
      list = list.getNext();
    } 
  }

  public void launch() {
    Patient firstPatient = new Patient("John", 33, "Tuberculosis");
    patientListStart = firstPatient;
    patientListStart.addPatient(new Patient("Jane", 72, "liver cancer"));
    patientListStart.addPatient(new Patient("Jim", 25, "HIV"));
    patientListStart.addPatient(new Patient("Paul", 55, "Flu"));
    patientListStart.addPatient(new Patient("Mary", 85, "Broken hip"));
    patientListStart.addPatient(new Patient("Shep", 45, "Broken leg"));
    patientListStart.addPatient(new Patient("Bob", 41, "Diabetes"));
    showPatients(patientListStart);
  }

  public static void main(String[] args) {
    HospitalManager hm = new HospitalManager();
    hm.launch();
  }
}
