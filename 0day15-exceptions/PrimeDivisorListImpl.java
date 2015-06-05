import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

public class PrimeDivisorListImpl implements PrimeDivisorList { 
  private List<Integer> list = new ArrayList<Integer>();
  private boolean isPrime(Integer n) { 
    boolean res = true;
    if (n == 1) 
      res = false;
    else
      for (int i=2; i<n/2; ++i) { 
        if (n % i == 0) { 
          res = false;
          break;
        }
      }
    return res;
  }
  public void addInt(Integer n) { 
    if (n == null) 
      throw new NullPointerException();
    else if (!isPrime(n))
      throw new IllegalArgumentException();
    list.add(n); 
  }
  public boolean remove(Integer n) { 
    return list.remove(n);
  }
  @Override
  public String toString() { 
    Set<Integer> set = new HashSet<Integer>(list);
    int tot = 1;
    String s = "[ ";
    for (Integer n : set) { 
      int occ = Collections.frequency(list, n);
      if (occ == 1)  
        s += n + " * "; 
      else if (occ > 1)
        s += n + "^" + occ + " * ";
      tot *= Math.pow(n, occ);
    }
    if (s.endsWith("* ")) 
      s = s.substring(0,s.length()-3);
    s += " = " + tot + " ]";
    return s;
  }
}
