public class TitleImpl implements Title {

  private String title;
  private Title next;

  public TitleImpl(String title) {
    this.title = title;
  }

  public String getTitle() {
    return title;
  }

  public Title getNext() {
    return next;
  }

  public void setNext(Title t) {
    next = t;
  }

  public static void main(String[] args) {
    
  }
}
