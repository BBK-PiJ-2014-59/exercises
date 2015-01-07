/** Users have a name and a library-ID (an int), both of which must be
  * unique in a library. 
  * The name is set at construction time, but the library-ID is not. 
  * The class must implement methods to get the name of the person and their ID, 
  * and to set the latter.
  */
public interface User { 
  /** set library ID 
    * @param int
    */
  public void setID();
  /** get library ID */
  public void int getID();
}
