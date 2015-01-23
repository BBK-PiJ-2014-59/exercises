import java.util.List;
import java.util.ArrayList;

public class PrimeDivisorListImpl implements PrimeDivisorList { 
  private List list = new ArrayList();
  public void addInt(Integer n) { 
    if (n == null) 
      throw new NullPointerException();
    list.add(n); 
  }
  public Integer removeLast() { 
    return null;
  }
  @Override
  public String toString() { 
    return null;
  }
}
