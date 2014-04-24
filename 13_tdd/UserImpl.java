public class UserImpl implements User {

  private String name;
  private int ID;
  private User next;

  public UserImpl(String name) {
    this.name = name;    
    this.next = null;
  }

  public boolean setID(int ID) {
    this.ID = ID;
    return true;
  }

  public int getID() {
    return ID;
  }

  public String getName() {
    return name;
  }

  public String printNameID() {
    return "" + getName() + ", " + getID();
  }

  public void setNext(User next) {
    this.next = next;
  }

  public User getNext() {
    return next;
  }
  
  public boolean nextNotNull() {
    if (next == null) {
      return false;
    } else {
      return true;
    }
  }
  
}
