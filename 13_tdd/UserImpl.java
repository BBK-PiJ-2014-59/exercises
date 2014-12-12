public class UserImpl implements User {

  private String name;
  private int ID;
  private User next;
  private Library library;
  private Title myTitleList;


  public UserImpl(String name) {
    this.name = name;    
    this.next = null;
    this.library = null;
  }

  public UserImpl(User u) {
    this.name = u.getName();
    this.ID = u.getID();
    this.next = null;
    this.library = null; 
    this.myTitleList = null;
  }

  public void deleteFromMyTitleList(String title) {
    if (myTitleList == null) {
      System.out.println("YOOOODA");
    }
    if (myTitleList.getTitle() == title) {
      Title deleteMe = myTitleList; 
      myTitleList = myTitleList.getNext(); 
      deleteMe.setNext(null);
    }
  }

  public void addToMyTitleList(String title) {
    System.out.println("adding " + title);
    Title newTitle;
    newTitle = new TitleImpl(title);  
    if (myTitleList == null) {
      myTitleList = newTitle;
    } else {
      newTitle.setNext(myTitleList);
      myTitleList = newTitle;
    }
  }

  public Title getTitles() {
    return myTitleList;
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
  
  public int register(Library library) {
    this.library = library;
    return library.getID(getName()); 
  }

  public String getLibrary() {
    if (library != null) {
      return library.getName();
    } else {
      return "NOT REGISTERED";
    }
  }

  public int getNumberBooksOut() {
    return 0;
  }
}
