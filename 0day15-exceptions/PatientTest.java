import java.util.ArrayList;
import java.util.List;
/**
  * More patients Write a class that asks for data (name and year of birth) about new patients in a hospital and keeps them in a list of Patient. The constructor of Patient must throw an IllegalArgumentException if the age of the patient is negative or greater than 130.
  */
public class PatientTest { 
  private List<Patient> patients = new ArrayList<Patient>();
  public void addPatient() { 
    System.out.print("Name: ");
    String name = System.console().readLine(); 
    System.out.print("Age: ");
    int age = Integer.parseInt(System.console().readLine()); 
    patients.add(new Patient(name, age));
  }

  public static void main(String[] args) { 
    PatientTest pt = new PatientTest();  
    pt.addPatient();
    pt.addPatient();
    System.out.println(pt.patients);
  }
}

class Patient { 
  private String name;
  private int age;
  public Patient(String name, int age) { 
    this.name = name;
    this.age = age;
    if (age > 130 || age < 0) 
      throw new IllegalArgumentException();
  }
}
