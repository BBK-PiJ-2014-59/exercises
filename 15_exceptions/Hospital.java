/**
  * asks for data (name and year of birth) about new patients in a 
  * hospital and keeps them in a list of Patient. 
  * The constructor of Patient must throw an IllegalArgumentException if the age of the patient is
  * negative or greater than 130.
  */
public interface Hospital {
  /**
    * Add a patient
    */
    void addPatient(String name, int age);
  /**
    * Find a patient
    */
    Patient findPatient(String name);

  /**
    * Prompt for name
    * @return name
    */
    
    //String promptForName();
  /**
    * Prompt for age
    * @return age
    */
    //int promptForAge();
  

}
