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
  public int generateUserID();
  /** 
    * @return max number of books a User can borrow 
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
}
