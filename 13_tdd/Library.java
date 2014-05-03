public interface Library {
  String getName();
  int getMaxBooksPerUser();
  void setMaxBooksPerUser(int max);
  int getID(String userGivenName);
}
