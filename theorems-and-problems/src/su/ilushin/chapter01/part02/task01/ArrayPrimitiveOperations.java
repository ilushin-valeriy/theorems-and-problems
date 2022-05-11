package su.ilushin.chapter01.part02.task01;

import su.ilushin.common.Pair;

import java.util.Arrays;
import java.util.stream.LongStream;

public class ArrayPrimitiveOperations {

  public static long[] createZeros(int n) {

    long[] result = new long[n];
    //it is already filled with 0 by java - standards but lets do loop

    for (int i = 0; i < n; i++) result[i] = 0;

//    Arrays.setAll(result,r->0);
//    Arrays.fill(result,0);

    return result;


  }

  public static long getZeroCount(long[] array) {
    long result = 0;

    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) result++;
    }

//    result = Arrays.stream(array).filter(a -> a == 0).count();

    return result;
  }

  public static void copy(long[] source, long[] destination) {

    for (int i = 0; i < source.length; i++) {
      destination[i] = source[i];
    }

//    System.arraycopy(source, 0, destination, 0, source.length);

  }

  public static long getDistinctCountInOrdered(long[] orderedArray) {
    long result = 0;
    if (orderedArray.length == 0) return 0;

    long prev = orderedArray[0];
    result++;
    for (int i = 1; i < orderedArray.length; i++) {
      if (prev != orderedArray[i]) {
        result++;
        prev = orderedArray[i];
      }
    }

    return result;
  }

  public static long getDistinctCount(long[] array) {
    //sorts alg we will implement later
    return getDistinctCountInOrdered(Arrays.stream(array).sorted().toArray());
  }

  /**
   * complexity array.length+maxValue
   *
   * @param array - 1<=array[i]<=maxValue
   * @return number of distinct elements
   */
  public static long getDistinctCount2(long[] array) {
    if (array.length == 0) return 0;

    long maxValue = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > maxValue) maxValue = array[i];
    }
//    maxValue=Arrays.stream(array).max().getAsLong()

    long[] supplementaryArr = new long[(int) maxValue];

    for (int i = 0; i < array.length; i++) {
      supplementaryArr[(int) array[i] - 1] = 1;
    }


    long result = 0;

    for (int i = 0; i < supplementaryArr.length; i++) {
      result += supplementaryArr[i];
    }

//    result = Arrays.stream(supplementaryArr).sum();
//    result = Arrays.stream(supplementaryArr).filter(a->a==1).count();


    return result;
  }



  public static void run() {

    long[] arr = {0, 1, 2, 34, 5, 0, 5, 6, 0};

    System.out.println("getZeroCount: " + getZeroCount(arr));

    long[] arr2 = {7, 1, 2, 34, 5, 7, 5, 6, 7};
    System.out.println("getDistinctCount: " + getDistinctCount(arr2));
    System.out.println("getDistinctCount2: " + getDistinctCount2(arr2));


  }

}
