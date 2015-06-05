public interface PrimeDivisorList {
  /**
    * add Integer
    * @param Integer
    * @throws NullPointerException if passed null
    * @throws IllegalArgumentException if passed non-prime or non-Integer
    */
  boolean add(Integer integer);
  /**
    * remove Integer
    * @param Integer
    * @throws NullPointerException if passed null
    * @throws IllegalArgumentException if passed non-prime, non-Integer
    * or anything not in the list.
    * @returns true if underlying List.add() was successful // SMELL: interface not concealing underlying mechanism 
    */
  void remove(Integer integer);
  /**
    * @returns String like [ 2 * 3^2 * 7 = 126 ] (for a list containing one 2, two 3, and one 7).  
    */
  @Override
  String toString(); 
}
