public interface Users {
  boolean idExists(int ID);
  boolean nameExists(String name);
  boolean add(User user);
}
