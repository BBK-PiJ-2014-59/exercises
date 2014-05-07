public interface Users {
  boolean idExists(int ID);
  boolean nameExists(String name);
  int getID(String name);
  int count();
  boolean add(User user);
  User getUserByID(int ID);
}
