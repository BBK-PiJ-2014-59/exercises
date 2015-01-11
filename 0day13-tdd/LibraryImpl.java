import java.util.ArrayList;
import java.util.List;

public class LibraryImpl implements Library { 
  private String name;
  private int maxBorrow;
  private List<User> users;
  private int nextUserID = 500;

  public LibraryImpl(String name) { 
    this.name = name;
    maxBorrow = 5;
    users = new ArrayList<User>();
  }
  private int generateUserID() { 
    return nextUserID++;
  }
  public String getName() { 
    return name;
  }
  public int getMaxBorrow() { 
    return maxBorrow;
  }
  public void setMaxBorrow(int max) { 
    maxBorrow = max;
  }

  public int addUser(User u) { 
    if (!nameIsUniqueInUsers(u.getName())) { 
      throw new IllegalArgumentException("User name exists already.");
    } else { 
      int id = generateUserID();
      u.setID(id);
      if (!idIsUniqueInUsers(u.getID())) { 
        throw new IllegalArgumentException("User ID not unique.");
      } else { 
        users.add(u);
        return id;
      }
    }
  }

  private boolean nameIsUniqueInUsers(String name) { 
    boolean result = true;
    for (User user : users) { 
      if (user.getName().equals(name)) result = false; 
    }
    return result;  
  }


  private User getUser(String name) { 
    for (User user : users) { 
      if (user.getName().equals(name)) 
        return user; 
    }
    return null;  
  }
  
  private boolean idIsUniqueInUsers(int id) { 
    boolean result = true;
    for (User user : users) { 
      if (user.getID() == id) result = false; 
    }
    return result;  
  }

  public int getID(String userName) { 
    int result;
    User u;
    if ((u = getUser(userName)) == null) { 
      result = addUser(new UserImpl(userName));
    } else { 
      result = u.getID();
    }
    return result;
  }
}
