public interface Library { 
  /** 
    * get name of library
    * @return name
    */
  public String getName();
  /** 
    * generate unique User ID 
    * @return user ID number
    */
  public int getMaxBorrow();
  /** 
    * @param max number of books a User can borrow 
    */
  public void setMaxBorrow(int max);
  /** 
    * @param User to add to library 
    * @throws IllegalArgumentException if User doesn't have unique name in Library;
    * @return ID of added user
    */
  public int addUser(User u);
  /** 
    * @param name of user
    * @return user ID associated with this name, which will be new and unique if there is no user in the library with this name yet.
    */
  public int getID(String name);
}
