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
  /**
    * @return list (or an array) with the titles of all the books they are borrowing at the moment
    *
    */
  Book getListOfBooksOut(); // QUESTION: does it return a) a reference to the actual object or b) a copy of it? must be a ref to the actual.
  int getNumberBooksOut();

}
