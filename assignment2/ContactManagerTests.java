import org.junit.*;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;



public class ContactManagerTests {

  private int myId;
  private String myName;
  private Contact c;
  private ContactManager cm;

  static private final int CONTACTIDMIN = 100;

  static private final String CONTACTNAME1 = "Bill";
  static private final String CONTACTNOTES1 = "such generous";
  static private final int CONTACTID1 = 100;

  static private final String CONTACTNAME2 = "Jane";
  static private final String CONTACTNOTES2 = "Wow";
  static private final int CONTACTID2 = 101;

  static private final String CONTACTNAME3 = "Fred";
  static private final String CONTACTNOTES3 = "amazing";
  static private final int CONTACTID3 = 102;

  @Before
  public void buildUp() {
    myId = 101; // TODO: what if a non-int is given?
    myName = "Jane"; // TODO: what if a non-String is given?
    c = new ContactImpl(myId, myName); // TODO: what if you try to create a Contact without both id and name?
    cm = new ContactManagerImpl(); 
  }

  @Test
  public void test_Contact_getId() {
    System.out.println("TEST 1");
    assertEquals(myId, c.getId());
  }

  @Test
  public void test_Contact_getName() {
    System.out.println("TEST 2");
    assertEquals(myName, c.getName());
  }

  @Test
  public void test_Contact_getNotes_nothingAddedYet() {
    System.out.println("TEST 3");
    assertEquals("",c.getNotes());
  }

  @Test
  public void test_Contact_getNotes_hasNotes() {
    System.out.println("TEST 4");
    String note = "note text";
    c.addNotes(note);
    assertEquals(note,c.getNotes());
  }

  // TODO: Contact specification says id should be unique. But the interface doesn't specify throwing any exceptions, so assume Contact constructors can't throw any, as it would be poor design to throw exceptions that weren't specified in the interface. How then to have Contact guarantee id-uniqueness? It seems the best way would be rewrite the interface to allow the constructor to throw an IllegalArgumentException. But in a real-world situation, could you get away with this? Assume that the interface can't be changed, so we need to manage Contact uniqueness from ContactManager.

  @Test 
  public void test_ContactManager_addNewContact_firstContact() {
    System.out.println("TEST 5");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    Set<Contact> s = cm.getContacts(CONTACTID1);
    Object[] oa = s.toArray(); 
    Contact c = (Contact) oa[0];
    assertEquals(CONTACTNAME1,c.getName());
  }

  @Test 
  public void test_ContactManager_addNewContact_twice_getContacts_singleId() {
    System.out.println("TEST 6");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    Set<Contact> s1 = cm.getContacts(CONTACTID1);
    Set<Contact> s2 = cm.getContacts(CONTACTID2);
    Object[] a1 = s1.toArray(); 
    Object[] a2 = s2.toArray(); 
    Contact c1 = (Contact) a1[0];
    Contact c2 = (Contact) a2[0];
    assertEquals(CONTACTNAME1,c1.getName());
    assertEquals(CONTACTNAME2,c2.getName());
  }

  @Test 
  public void test_ContactManager_addNewContact_twice_IdsDifferent() {
    System.out.println("TEST 7");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    Set<Contact> s = cm.getContacts(CONTACTID1, CONTACTID2);
    Object[] oa = s.toArray(); 
    Contact c0 = (Contact) oa[0];
    Contact c1 = (Contact) oa[1];
    assertNotEquals(c0.getId(),c1.getId());
  }

  @Test 
  public void test_ContactManager_addNewContact_threeTimes_getFirstTwoIds() {
    System.out.println("TEST 8");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    cm.addNewContact(CONTACTNAME3, CONTACTNOTES3);
    Set<Integer> testIdSet = new HashSet<Integer>();
    testIdSet.add(100);  
    testIdSet.add(101);  
    Set<Contact> s = cm.getContacts(CONTACTID1, CONTACTID2);
    Set<Integer> returnedIdSet = new HashSet<Integer>();
    for (Contact c : s) {
      returnedIdSet.add(c.getId());  
    }  
    assertTrue(testIdSet.equals(returnedIdSet));
  }
    
  @Test 
  public void test_ContactManager_addNewContact_threeTimes_getAllIds() {
    System.out.println("TEST 9");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1);
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2);
    cm.addNewContact(CONTACTNAME3, CONTACTNOTES3);
    Set<Integer> testIdSet = new HashSet<Integer>();
    testIdSet.add(100);  
    testIdSet.add(101);  
    testIdSet.add(102);  
    int[] idsToRequest = { 100, 101, 102 };
    //Set<Contact> s = cm.getContacts(CONTACTID1, CONTACTID2, CONTACTID3);
    //Set<Contact> s = cm.getContacts();
    //Integer[] ia = (Integer[])testIdSet.toArray();
    //int[] inta = (int[])ia;
    Set<Contact> s = cm.getContacts(idsToRequest);
    Set<Integer> returnedIdSet = new HashSet<Integer>();
    for (Contact c : s) {
      returnedIdSet.add(c.getId());  
    }  
    assertTrue(testIdSet.equals(returnedIdSet));
  }

  @Test 
  public void test_ContactManager_addNewContact_100Times_getAllIds() {
    System.out.println("TEST 10");
    int numContacts = 100;
    int contactIdMax = 199;
    Set<Integer> testIdSet = new HashSet<Integer>();
    int[] idsToRequest = new int[numContacts];
    for (int curId = CONTACTIDMIN; curId < contactIdMax; curId++) {
      String curName = "CONTACTNAME" + curId;  
      String curNotes = "CONTACTNOTES" + curId;  
      cm.addNewContact(curName, curNotes); 
      testIdSet.add(curId);  
      idsToRequest[curId-CONTACTIDMIN] = curId;
    }
    Set<Contact> s = cm.getContacts(idsToRequest);
    Set<Integer> returnedIdSet = new HashSet<Integer>();
    for (Contact c : s) {
      returnedIdSet.add(c.getId());  
    }  
    assertTrue(testIdSet.equals(returnedIdSet));
  }
}
