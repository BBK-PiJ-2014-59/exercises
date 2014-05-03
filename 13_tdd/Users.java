public interface Users {
  boolean idExists(int ID);
  boolean nameExists(String name);
  int getID(String name);
  boolean add(User user);
}
