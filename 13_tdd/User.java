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
  Title getTitles();
  /**
    * add title of book being borrowed to myTitleList
    */
  void addToMyTitleList(String title);
  void deleteFromMyTitleList(String title);

}
