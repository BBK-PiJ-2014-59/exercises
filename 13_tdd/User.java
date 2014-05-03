public interface User {
  boolean setID(int id);
  int getID();
  String getName();
  String printNameID();
  User getNext();
  void setNext(User u);
  boolean nextNotNull();
  int register(Library lib);
  String getLibrary();
}
