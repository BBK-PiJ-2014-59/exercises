public interface Library {
  String getName();
  int getMaxBooksPerUser();
  void setMaxBooksPerUser(int max);
  int getID(String userGivenName);
  void addBook(String title, String author);
  Book findBook(String title, String author);
  //Book takeBook(String title);
  //void returnBook(Book book);
}
