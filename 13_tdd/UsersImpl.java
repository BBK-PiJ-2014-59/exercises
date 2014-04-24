public class UsersImpl implements Users {

  User firstUser = null;

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
