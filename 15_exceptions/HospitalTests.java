import org.junit.*;
import static org.junit.Assert.*;

public class HospitalTests {
  @Test
  public void Hospital_addPatient_toPatientListOfZero() {
    System.out.println("\n\nTEST 1");
    Hospital hospital = new HospitalImpl();
    hospital.addPatient("Jesse", 40);
    assertEquals("Jesse", hospital.findPatient("Jesse").getName()); 
  }

  @Test
  public void Hospital_addPatient_toPatientListOfZero_age131_throws_IllegalArgumentException() {
    System.out.println("\n\nTEST 2");
}
