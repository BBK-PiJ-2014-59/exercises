public class BookImpl implements Book {

  private final String title;
  private final String authorName;
  private Book next;
  private boolean taken;

  public BookImpl(String title, String authorName) {
    this.title = title;
    this.authorName = authorName;
    next = null;
    taken = false;
  }

  public User getBorrower() {
    return null;
  }

  public String getTitle() {
    return title;
  }

  public String getAuthorName() {
    return authorName;
  }

  public void setNext(Book book) {
    next = book;
  }

  public Book getNext() {
    return next;
  }

  public boolean isTaken() {
    return taken;
  }

  public void setTaken(Boolean taken) {
    this.taken = taken;
  }
}
