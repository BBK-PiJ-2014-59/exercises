public class BookImpl implements Book { 
  private final String title;
  private final String author;

  public BookImpl(String title, String author) { 
    this.title = title; 
    this.author = author; 
  }

  public String getTitle() { 
    return title;
  }

  public String getAuthor() { 
    return author;
  }

  public static void main(String[] args) { 
    //Book myBook1 = new BookImpl("title1", "author1");
  }
}
