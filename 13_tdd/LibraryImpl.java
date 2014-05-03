public class LibraryImpl implements Library {
  private String name;
  public LibraryImpl(String name) {
    this.name = name; 
  }
  public String getName() {
    return name;
  } 
  public int getFreeID() {
    return 13;
  }
}
