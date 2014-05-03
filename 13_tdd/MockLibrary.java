public class MockLibrary implements Library {

  private String name; 
  private int maxBooksPerUser;
  private Users users;

  public MockLibrary(String name) {
    this.name = name;
    users = new UsersImpl();
  }

  public String getName() {
    return name; 
  }
  public int getMaxBooksPerUser() {
    return maxBooksPerUser;
  }
  public void setMaxBooksPerUser(int max) {
    maxBooksPerUser = max;
  }
  public int getID(String userGivenName) {
    return users.getID(userGivenName);
  }
}

// new Library.getID("x") -> users.getID("x) -> adds
