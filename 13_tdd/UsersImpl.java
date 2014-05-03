public class UsersImpl implements Users {

  private final int minID = 100;
  private int nextID = minID;
  User firstUser = null;

  public int getID(String name) {
    System.out.println("Searching for name " + name);

    if (firstUser == null) {
      User newUser = new UserImpl(name);
      int newID = nextID++;
      newUser.setID(newID);
      add(newUser);
      return newID;
    }

    User curUser = firstUser; 
    do {
      if (curUser.getName().equals(name)) {
        //System.out.println("Found ID " + id + " in User object with name " + curUser.getName());
        System.out.println("yoda");
        return curUser.getID();
      }
      //System.out.println("curUser: " + curUser.getName());
      curUser = curUser.getNext(); 
    } while (curUser != null); 
    System.out.println(name + " does not exist yet.");

    User newUser = new UserImpl(name);
    int newID = nextID++;
    newUser.setID(newID);
    add(newUser);
    return newID;
  }

  public boolean nameExists(String name) {
    System.out.println("Searching for name " + name);
    User curUser = firstUser; 
    do {
      if (curUser.getName().equals(name)) {
        //System.out.println("Found ID " + id + " in User object with name " + curUser.getName());
        return true;
      }
      //System.out.println("curUser: " + curUser.getName());
      curUser = curUser.getNext(); 
    } while (curUser != null); 
    System.out.println(name + " does not exist yet.");
    return false;
  }

  public boolean idExists(int id) {
    System.out.println("Searching for ID " + id);
    User curUser = firstUser; 
    do {
      if (curUser.getID() == id) {
        //System.out.println("Found ID " + id + " in User object with name " + curUser.getName());
        return true;
      }
      //System.out.println("curUser: " + curUser.getName());
      curUser = curUser.getNext(); 
    } while (curUser != null); 
    System.out.println(id + " does not exist yet.");
    return false;
  }

  public boolean add(User user) {
    String nid = user.printNameID();
    System.out.println("Trying to add user: " + nid);
    if (firstUser == null) {
      firstUser = user;
      System.out.println("User add succeeded: " + nid);
      return true;
    } 
    if (idExists(user.getID())) {
        System.out.println("Found duplicate ID: " + nid);
        System.out.println("User add failed: " + nid);
        return false;
    }
    if (nameExists(user.getName())) {
        System.out.println("Found duplicate name: " + nid);
        System.out.println("User add failed: " + nid);
        return false;
    } else {  
      user.setNext(firstUser);
      firstUser = user;
      System.out.println("User add succeeded: " + nid);
      return true;
    }
  }


}
