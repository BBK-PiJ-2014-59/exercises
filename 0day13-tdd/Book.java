/** Books have authors and titles. 
  * The class should implement getters for both author name
  * and title, but these must be set at construction time and 
  * never be modified afterwards. 
  */
public interface Book { 
  /** @return author */
  public String getAuthor();
  /** @return title */
  public String getTitle();
}
