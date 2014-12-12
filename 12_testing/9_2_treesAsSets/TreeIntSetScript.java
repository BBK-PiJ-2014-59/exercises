public class TreeIntSetScript {
  public static void main(String[] args) {
    TreeIntSetScript tiss = new TreeIntSetScript();
    tiss.launch();
  }  

  public void launch() {
    TreeIntSet root = new TreeIntSet(15);
    /**
    root.add(14);
    root.add(13);
    root.add(12);
    root.add(11);
    root.add(10);
    */
    root.add(4);
    root.add(49);
    root.add(10);
    root.add(44);
    root.add(41);
    root.add(37);
    root.add(38);
    root.add(3);
    root.add(51);
    root.add(1);
    root.add(2);
    root.add(60);
    /**
    root.add(61);
    root.add(71);
    root.add(81);
    root.add(91);
    */
    root.toString2();

    System.out.println();

    System.out.println(root.containsVerbose(100));
    // System.out.println(root.getMax());
    // System.out.println(root.getMin());
  }
}
