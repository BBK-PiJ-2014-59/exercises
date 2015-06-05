public class Initials { 

	public String getInitials(String fullName) { 
	
	  String result = "";
	  String[] words = fullName.split(" +");
	  for (int i = 0; i < words.length; i++) { 
	
	    String nextInitial = "" + words[i].charAt(0);
	    result = result + nextInitial.toUpperCase();
	  }
	  return result;
	}

  public static void main(String[] args) { 
    Initials in = new Initials();
    System.out.println(in.getInitials("Jesse  Oldershaw"));

  }
}
