public class Foo {
  ArrayPersonQueue pq2;

  public Foo() {
    pq2 = new ArrayPersonQueue();
  }

  public int hoo() {
    return 5;
  }

  public static void main(String[] args) {
    Foo f = new Foo();
    System.out.println(f.hoo());
    f.pq2.front = 2;
  }
}
