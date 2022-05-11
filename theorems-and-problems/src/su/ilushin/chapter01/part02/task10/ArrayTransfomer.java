package su.ilushin.chapter01.part02.task10;

import java.util.Arrays;

public class ArrayTransfomer {

  public static void reversSubArray(long[] arr, int firstIndex, int lastIndex) {
    long temp;

    long len = lastIndex - firstIndex + 1;


    for (int i = 0; i <= len / 2 - 1; i++) {
      temp = arr[firstIndex + i];
      arr[firstIndex + i] = arr[lastIndex - i];
      arr[lastIndex - i] = temp;
    }

  }

  public static void reversArray(long[] arr) {

    reversSubArray(arr, 0, arr.length - 1);

  }


  /**
   * Perform swap two joined [A,B] --> [B,A]
   * without supplementary arrays
   * complexity N
   * <p>
   * alg:<p>
   * A' - revers A<p>
   * 1. [A,B] - [A',B]<p>
   * 2. [A',B] - [A',B']<p>
   * 3. [A',B'] - [A',B']' = [B,A]<p>
   *
   * @param arr         - two joined subArrays A,B
   * @param firstArrLen
   */
  public static void swapSubArrays(long[] arr, int firstArrLen) {
    reversSubArray(arr, 0, firstArrLen - 1);
    reversSubArray(arr, firstArrLen, arr.length - 1);
    reversArray(arr);

  }

  private static void swapTwoEqualSubArray(long[] arr,
                                           int arr1StartIndex,
                                           int arr2StartIndex,
                                           int len) {
    long temp;

    for (int i = 0; i < len; i++) {
      temp = arr[arr1StartIndex + i];
      arr[arr1StartIndex + i] = arr[arr2StartIndex + i];
      arr[arr2StartIndex + i] = temp;
    }

  }

  /**
   * Perform swap two joined [A,B] --> [B,A]
   * without supplementary arrays
   * complexity N
   * <p>
   * alg:<p>
   * lets A.len <= B.len <p>
   * B1.len=A.len, B2 - reminder B=[B1,B2] <p>
   * <p>
   * [A,B1,B2] --> [B1,A,B2] --> repeat alg for part [...,A,B2]<p>
   * or <p>
   * [A1,A2,B] --> [A1,B,A2] -->  repeat alg for part [A1,B,...]<p>
   *
   * @param arr         - two joined subArrays A,B
   * @param firstArrLen
   */
  public static void swapSubArrays3(long[] arr, int firstArrLen) {

    int s1 = 0, f1 = firstArrLen - 1;
    int s2 = firstArrLen, f2 = arr.length - 1;
    while ((s1 <= f1) && (s2 <= f2)) {

      int len1 = f1 - s1 + 1;
      int len2 = f2 - s2 + 1;
      if ((len1) <= (len2)) {
        swapTwoEqualSubArray(arr, s1, s2, len1);
        s1 = s1 + len1;
        f1 = f1 + len1;
        s2 = f1 + 1;
      } else {
        swapTwoEqualSubArray(arr, s1 + len1 - len2, s2, len2);
        f1 = f1 - len2;
        s2 = s2 - len2;
        f2 = f2 - len2;
      }

    }

  }


  public static void run() {

    long[] arr;

    System.out.println();
    arr = new long[]{};
    System.out.println("before revers: " + Arrays.toString(arr));
    reversArray(arr);
    System.out.println("after revers: " + Arrays.toString(arr));

    System.out.println();
    arr = new long[]{1};
    System.out.println("before revers: " + Arrays.toString(arr));
    reversArray(arr);
    System.out.println("after revers: " + Arrays.toString(arr));

    System.out.println();
    arr = new long[]{1, 2, 3, 4, 5, 6, 7};
    System.out.println("before revers: " + Arrays.toString(arr));
    reversArray(arr);
    System.out.println("after revers: " + Arrays.toString(arr));

    System.out.println();
    arr = new long[]{1, 2, 3, 4, 5, 6, 7, 8};
    System.out.println("before revers: " + Arrays.toString(arr));
    reversArray(arr);
    System.out.println("after revers: " + Arrays.toString(arr));


    System.out.println();
    arr = new long[]{1, 2, 3, 4, 5, 6, 7, 8, 11, 12, 13};
    System.out.println("before swap: " + Arrays.toString(arr));
    swapSubArrays3(arr, 8);
    System.out.println("after swap: " + Arrays.toString(arr));

  }
}
