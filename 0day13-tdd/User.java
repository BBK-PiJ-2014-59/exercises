/** Users have a name and a library-ID (an int), both of which must be
  * unique in a library. 
  * The name is set at construction time, but the library-ID is not. 
  * The class must implement methods to get the name of the person and their ID, 
  * and to set the latter.
  */
public interface User { 
  /** set library ID 
    * @param id library-ID, unique in the library
    */
  public void setID(int id);
  /** 
    * get library ID
    * @return library-ID
    */
  public int getID();
  /** 
    * get user name 
    * @return name 
    */
  public String getName();
  /** 
    * register with Library 
    * @return library-ID that is unique to library
    */
  public int register(Library l);
  /** 
    * get name of Library registered with
    * @return name 
    */
  public String getLibrary();
}
