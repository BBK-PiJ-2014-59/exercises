public class ArrayCopier {
  void launch() {
    int[] src = {1, 5, 10, 9, 22, -10};
    int[] dst; 
    dst = new int[7];
    copy(src, dst);
    for (int i = 0; i < src.length; ++i) {
      System.out.println(src[i]);
    }
    for (int i = 0; i < dst.length; ++i) {
      System.out.println(dst[i]);
    }
  }

  void copy(int[] src, int[] dst) {
    if (src.length <= dst.length) {
      for (int i = 0; i < src.length; ++i) {
        dst[i] = src[i];
      } 
    } else {
      for (int i = 0; i < dst.length; ++i) {
        dst[i] = src[i];
      }
    }
  }

  public static void main(String[] args) {
    ArrayCopier ac = new ArrayCopier();
    ac.launch();
  }
}