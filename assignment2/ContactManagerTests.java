// TODO: replace Set.addAll() with Collections.addAll(). Use most generic interface possible, so you can change implementation later.

import org.junit.*;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;
import java.util.Calendar;

public class ContactManagerTests {


  static private final int JESSEID = 999;
  static private final String JESSENAME = "Jesse";
  static private final Contact JESSE = new ContactImpl(JESSEID, JESSENAME);

  static private final int CONTACTIDMIN = 100;
  static private final String USERNAME = "USERNAME";

  static private final String CONTACTNAME1 = "Bill";
  static private final String CONTACTNOTES1 = "such generous";
  static private final int CONTACTID1 = 100;

  static private final String CONTACTNAME2 = "Jane";
  static private final String CONTACTNOTES2 = "Wow";
  static private final int CONTACTID2 = 101;

  static private final String CONTACTNAME3 = "Fred";
  static private final String CONTACTNOTES3 = "amazing";
  static private final int CONTACTID3 = 102;

  static private final int MTGIDMIN = 1000;
  static private final int MTGID1 = 1001;

  static private final int FAKEMTGID = 9999;

  static private final Calendar FAKECAL = Calendar.getInstance();

  private int myId;
  private String myName;
  private Contact user;
  private String userName;
  private Contact c;
  private Set<Contact> contacts; 
  private Meeting m;
  private ContactManager cm;
  private Calendar cal = Calendar.getInstance();
  private String myMtgNote; 

  private Set<Contact> populateTestContactSet(int loId, int hiId) {
    Set <Contact> testContactSet = new HashSet<Contact>();
    for (int id=loId; id <= hiId; id++) {
      String name = "dummyContactName" + id;
      testContactSet.add(new ContactImpl(id, name));
    } 
    for (Contact ci: testContactSet) {
      System.out.println(ci.getName());
    }
    return testContactSet;
  }

  /*
  * @returns array of contact IDs containing the range requested to be added
  * @param cIdMin lowest ID in range 
  * @param cIdMax highest ID in range 
  * @throws IllegalArgumentException if cIdMin was below minimum ID allowed 
  */
  private int[] addTestContactRange(int cIdMin, int cIdMax) {
    // TODO: shouldn't be able to add below CONTACTIDMIN
    // But how to know minimum ID allowed if private to ContactManager? Redo so we just ask for a number of contacts to be added
    // to an empty ContactManager and we're given back an array of IDs to request to get this same amount of existing contacts back.
    int[] idsToRequest = new int[cIdMax-cIdMin+1];
    for (int curId = cIdMin; curId <= cIdMax; curId++) {
      String curName = "name of Contact with ID " + curId;
      String curNotes = "notes of Contact with ID " + curId;
      cm.addNewContact(curName, curNotes);
      idsToRequest[curId-cIdMin] = curId;
    }
    return idsToRequest;
  }

  @Before
  public void buildUp() {
    myId = 101; 
    userName = "JO"; 
    myName = "Jane"; 
    myMtgNote = "Wow. So meeting."; 
    c = new ContactImpl(myId, myName); // TODO: what if you try to create a Contact without both id and name?
    m = new MeetingImpl(MTGID1, cal); 
    cm = new ContactManagerImpl(); 
    contacts = new HashSet<Contact>(); 
  }

  // TODO: notes 

  @Test
  public void test_Contact_getId() {
    System.out.println("TEST 1");
    assertEquals(myId, c.getId());
  }

  @Test
  public void test_Meeting_getId() {
    System.out.println("TEST 1.1");
    assertEquals(MTGID1, m.getId());
  }

  @Test
  public void test_Meeting_getDate() {
    System.out.println("TEST 1.2");
    assertEquals(cal, m.getDate());
  }

  @Test
  public void test_Meeting_getContacts_NoContacts() {
    System.out.println("TEST 1.2.5");
    int mtgid = 1000;
    Meeting justUser = new MeetingImpl(mtgid, cal); 
    Set<Contact> sc = new HashSet<Contact>();
    sc.addAll(justUser.getContacts());
    assertEquals(1,sc.size());
  }

  @Test
  public void test_Meeting_getContacts_1Contact() {
    System.out.println("TEST 1.3");
    int mtgid = 1000;
    Set<Contact> sc = new HashSet<Contact>();
    Meeting justUser = new MeetingImpl(mtgid, cal); 
    sc.add(JESSE);
    sc.addAll(justUser.getContacts());

    Meeting userAndJesse = new MeetingImpl(mtgid, cal, sc); 
    Set<Contact> sc2 = new HashSet<Contact>(); 
    sc2 = userAndJesse.getContacts();
    assertTrue(sc.equals(sc2));
  }

  @Test
  public void test_Meeting_getContacts_2Contacts() {
    System.out.println("TEST 1.3.0");

    Meeting justUser = new MeetingImpl(FAKEMTGID, cal);

    Set<Contact> fixtureContactSet = new HashSet<Contact>();
    fixtureContactSet.addAll(justUser.getContacts()); // has just the user so far
  
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = populateTestContactSet(101,102);

    fixtureContactSet.addAll(tcs);
    
    Meeting mtg = new MeetingImpl(FAKEMTGID, cal, fixtureContactSet);
    assertEquals(fixtureContactSet, mtg.getContacts());
  }

  // TODO: parameterized test of above using number of contacts as parameter

  @Test
  public void test_getMeeting_noMeetingsYet() {
    System.out.println("TEST 1.3.1");
    assertNull(cm.getMeeting(MTGIDMIN));
  }

  @Test
  public void test_getMeeting_meetingExists_1meeting() {
    System.out.println("TEST 1.3.2");
    int[] idsToRequest = addTestContactRange(CONTACTIDMIN, CONTACTIDMIN + 100);
    Set<Contact> tcs = cm.getContacts(idsToRequest);
    cm.addNewPastMeeting(tcs, cal, myMtgNote); // TODO: get rid of cal, myMtgNote
    assertEquals(MTGIDMIN,cm.getMeeting(MTGIDMIN).getId());
  }

  @Test
  public void test_getMeeting_meetingExists_2meetings() {
    System.out.println("TEST 1.3.3");
    int[] idsToRequest = addTestContactRange(CONTACTIDMIN, CONTACTIDMIN + 100);
    Set<Contact> tcs = cm.getContacts(idsToRequest);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    assertEquals(MTGIDMIN,cm.getMeeting(MTGIDMIN).getId());
    assertEquals(MTGIDMIN+1,cm.getMeeting(MTGIDMIN+1).getId());
  }

  @Test
  public void test_getMeeting_meetingDoesntExist_2meetings() {
    System.out.println("TEST 1.3.4");
    int[] idsToRequest = addTestContactRange(CONTACTIDMIN, CONTACTIDMIN + 100);
    Set<Contact> tcs = cm.getContacts(idsToRequest);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    assertNotNull(cm.getMeeting(MTGIDMIN));
    assertNotNull(cm.getMeeting(MTGIDMIN+1));
    assertNull(cm.getMeeting(MTGIDMIN+2));
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
  // TODO: tests rely on array order - bad?
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

  @Test (expected=NullPointerException.class)
  public void test_ContactManager_addNewContact_nullName() {
    System.out.println("TEST 7.1");
    cm.addNewContact(null, CONTACTNOTES1);
  }

  @Test (expected=NullPointerException.class)
  public void test_ContactManager_addNewContact_nullNotes() {
    System.out.println("TEST 7.2");
    cm.addNewContact(CONTACTNAME1, null);
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
  public void test_ContactManager_addNewContact_100Times_getAllIds() {
    System.out.println("TEST 9");
    int numContacts = 100;
    int contactIdMax = 199;
    Set<Integer> testIdSet = new HashSet<Integer>();
    int[] idsToRequest = new int[numContacts];

    for (int curId = CONTACTIDMIN; curId <= contactIdMax; curId++) {
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

  @Test (expected=IllegalArgumentException.class) 
  public void test_ContactManager_getContacts_nonExistentContact() {
    System.out.println("TEST 10");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    int fakeId = 50;
    Set<Contact> s = cm.getContacts(fakeId);
  }

  @Test (expected=NullPointerException.class) 
  public void test_ContactManager_getContacts_nullStringParameter() {
    System.out.println("TEST 11");
    String name = null;
    Set<Contact> s = cm.getContacts(name);
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_NotFound() {
    System.out.println("TEST 12");
    String name = "foooo";
    Set<Contact> s = cm.getContacts(name);
    assertTrue(s.isEmpty());
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_FoundMatch() {
    System.out.println("TEST 13");
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    Set<Contact> s = cm.getContacts(CONTACTNAME1);
    assertFalse(s.isEmpty());
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_FoundOneMatch() {
    System.out.println("TEST 14");
    int matchesNeeded = 1; // TODO: parameterize!
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2); 
    Set<Contact> s = cm.getContacts(CONTACTNAME1);
    assertEquals(matchesNeeded, s.size());
    Object[] oa = s.toArray(); 
    Contact c = (Contact) oa[0];
    assertEquals(CONTACTNAME1,c.getName());
  }

  @Test
  public void test_ContactManager_getContacts_StringParameter_FoundTwoMatches() {
    System.out.println("TEST 15");
    int matchesNeeded = 2; // TODO: parameterize!
    String match1 = "Jesse";
    String match2 = match1 + " O";
    cm.addNewContact(CONTACTNAME1, CONTACTNOTES1); 
    cm.addNewContact(CONTACTNAME2, CONTACTNOTES2); 
    cm.addNewContact(match1, CONTACTNOTES1); 
    cm.addNewContact(match2, CONTACTNOTES2); 
    Set<Contact> s = cm.getContacts(match1);
    assertEquals(matchesNeeded, s.size());
    
    // TODO: add back in with eg SortedSet using custom Comparator.   
    // Otherwise BAD TEST. inconsistent results. Sort Object array and then run assertions. ...use Sorted Set?
    /*
    Object[] oa = s.toArray(); 
    Contact c1 = (Contact) oa[0];
    assertEquals(match1,c1.getName());
    Contact c2 = (Contact) oa[1];
    */
  }

  @Test
  public void test_getPastMeeting_NonExistentId() {
    System.out.println("TEST 16");
    assertNull(cm.getPastMeeting(MTGIDMIN)); 
  }


  @Test
  public void test_addNewPastMeeting_getPastMeeting_exists() {
    System.out.println("TEST 17");
    int[] idsToRequest = addTestContactRange(CONTACTIDMIN, CONTACTIDMIN+100);
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = cm.getContacts(idsToRequest);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    assertNotNull(cm.getPastMeeting(MTGIDMIN)); 
  }

  @Test (expected=IllegalArgumentException.class)
  public void test_addNewPastMeeting_emptyContact() {
    System.out.println("TEST 17.1");
    Set<Contact> tcs = new HashSet<Contact>();
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
  }

  @Test (expected=IllegalArgumentException.class)
  public void test_addNewPastMeeting_nonExistentContact() {
    System.out.println("TEST 17.1.1");
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = populateTestContactSet(101,102);
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
  }

  @Test (expected=NullPointerException.class)
  public void test_addNewPastMeeting_nullContactSet() {
    System.out.println("TEST 17.2");
    Set<Contact> tcs = null;
    cm.addNewPastMeeting(tcs, cal, myMtgNote); // TODO: rename cal 'testPastDate'
  }

  @Test (expected=NullPointerException.class)
  public void test_addNewPastMeeting_nullDate() {
    System.out.println("TEST 17.3");
    Set<Contact> tcs = new HashSet<Contact>(); // TODO: upscope tcs and rename 'testContactSet' 
    tcs = populateTestContactSet(101,102);
    Calendar nullCal = null; 
    cm.addNewPastMeeting(tcs, nullCal, myMtgNote); // TODO: rename 'testNote'
  }

  @Test (expected=NullPointerException.class)
  public void test_addNewPastMeeting_nullNote() {
    System.out.println("TEST 17.4");
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = populateTestContactSet(101,102);
    String nullNote = null; 
    cm.addNewPastMeeting(tcs, cal, nullNote);
    //cm.addNewPastMeeting(null, cal, "foo");
  }

  @Test
  public void test_PastMeeting_getNotes_null() {
    System.out.println("TEST 18");
    PastMeeting pm = new PastMeetingImpl(FAKEMTGID, FAKECAL); 
    assertNull(pm.getNotes());
  }

  @Test (expected=IllegalArgumentException.class)
  public void test_addMeetingNotes_nonExistentMeeting() {
    System.out.println("TEST 19");
    cm.addMeetingNotes(9999, "blah");
  }

  //@Test TODO: how to get around PastMeeting interface allowing no setter for notes?
  public void test_addMeetingNotes_meetingExists_getNotes() {
    System.out.println("TEST 20");
    int[] idsToRequest = addTestContactRange(CONTACTIDMIN, CONTACTIDMIN+100);
    Set<Contact> tcs = new HashSet<Contact>();
    tcs = cm.getContacts(idsToRequest);
    myMtgNote = "blah";
    cm.addNewPastMeeting(tcs, cal, myMtgNote);
    assertNotNull(cm.getPastMeeting(MTGIDMIN)); 
    cm.addMeetingNotes(MTGIDMIN, myMtgNote);
    assertEquals(myMtgNote, cm.getPastMeeting(MTGIDMIN).getNotes());
  }

  /* TODO: rewrite test using ContactManager.addMeetingNotes()
  @Test
  public void test_PastMeeting_getNotes_notNull() {
    PastMeeting pm = new PastMeetingImpl(FAKEMTGID, FAKECAL); 
    assertNull(pm.getNotes());
  }
  */

    /* 
    * Takes a number of contacts and a ContactManager object and returns test Set of Contact objects with IDs ranging from the minimum ID to (minimum + number IDs to add - 1). 
    */
  private Set<Contact> populateTestContactSet(int numTestContacts, ContactManager cm) {
    int[] idsToRequest = addTestContactRange(CONTACTIDMIN, CONTACTIDMIN+100);
    Set<Contact> tcs = new HashSet<Contact>();
    return cm.getContacts(idsToRequest);
  }

  @Test
  public void test_addFutureMeeting() {

    Set<Contact> tcs = populateTestContactSet(10, cm);
    assertEquals(MTGIDMIN, cm.addFutureMeeting(tcs, cal));
    assertEquals(MTGIDMIN+1, cm.addFutureMeeting(tcs, cal));
  }
  
}
