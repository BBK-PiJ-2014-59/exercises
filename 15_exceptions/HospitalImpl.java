public class HospitalImpl implements Hospital {
  private Patient patientList;

  public HospitalImpl() {
    patientList = null;
  }

  public void addPatient(String name, int age) {
    patientList = new PatientImpl(name, age);
  }
  
  public Patient findPatient(String name) {
    return patientList;
  }
}
