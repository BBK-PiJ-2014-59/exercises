public class PatientImpl implements Patient {
  private int age;
  private String name;

  public PatientImpl(String name, int age) throws IllegalArgumentException {
    if (age > 130) {
      throw new IllegalArgumentException("Detected age > 130.");
    }
    this.name = name;
    this.age = age; 
  }

  public String getName() {
    return name;
  }
}
