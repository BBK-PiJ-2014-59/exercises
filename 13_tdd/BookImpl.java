public class BookImpl implements Book {

  private final String title;
  private final String authorName;

  public BookImpl(String title, String authorName) {
    this.title = title;
    this.authorName = authorName;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthorName() {
    return authorName;
  }

}
