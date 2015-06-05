public class UserImpl implements User { 
  private String name;
  private int id;
  private String libraryName;
  public UserImpl(String name) { 
    this.name = name;
  }
  public String getName() { 
    return name;
  }
  public int getID() { 
    return id;
  }
  public void setID(int id) { 
    this.id = id;
  }
  public String getLibrary() { 
    return libraryName;
  }
  public int register(Library l) { 
    libraryName = l.getName();
    //int myID = l.generateUserID();
    //int myID = l.addUser(this);
    int myID = l.getID(name);
    //setID(myID);
    return myID;
  }
}
