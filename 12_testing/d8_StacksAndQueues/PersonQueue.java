public interface PersonQueue {
  /** 
   * Adds another person to the queue. 
   */
  public void insert(Person person);

  /** 
   * Removes a person from the queue. 
   */
  public Person retrieve();
}
