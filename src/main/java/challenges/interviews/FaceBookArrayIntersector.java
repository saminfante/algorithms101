package challenges.interviews;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * The type Face book array intersector.
 */
public class FaceBookArrayIntersector {

  /**
   * Instantiates a new Face book array intersector.
   */
  public FaceBookArrayIntersector() {
  }

  /**
   * Utility method to convert int[] array to List<Integer> array
   */
  private static ArrayList<Integer> convertIntArrayToList(int[] input) {
    ArrayList<Integer> list = new ArrayList<>();
    for(int i : input) {
      list.add(i);
    }
    return list;
  }

  /**
   * Solution 2 - Binary Search, Time= O(n log(n)), Space= O(n)
   */
  private int[] intersection(int[] array1, int[] array2) {
    Arrays.sort(array1);
    Arrays.sort(array2);
    ArrayList<Integer> list = new ArrayList<>();

    for(int i = 0; i < array1.length; i++) {
      if(i == 0 || array1[i] != array1[i - 1]) {
        if(Arrays.binarySearch(array2, array1[i]) > -1) {
          list.add(array1[i]);
        }
      }
    }

    int[] result = new int[list.size()];
    int k = 0;
    for(int i : list) {
      result[k++] = i;
    }
    return result;
  }

  /**
   * Find the intersection of two int[] arrays and return it as an ArrayList.
   *
   * @param array1 the array 1
   * @param array2 the array 2
   * @return the array list returned, as ArrayList<Integer> collector
   */
  public ArrayList<Integer> intersect(int[] array1, int[] array2) {
    ArrayList<Integer> collector; // you try... scroll down to see solution below

    // Sam's Solution:
    int[] myList = intersection(array1, array2);
    collector = convertIntArrayToList(myList);

    return collector;
  }


  /**
   * Intersect brute force array list.
   *
   * @param array1 the array 1
   * @param array2 the array 2
   * @return the array list
   */
  public ArrayList<Integer> intersectBruteForce(int[] array1, int[] array2) {
    ArrayList<Integer> collector = new ArrayList<>();

    // O(n)
    for(int i : array1) {
      // O(m)
      for(int j : array2) {
        if(i == j) {
          collector.add(i);
        }
      }
    }

    return collector;
  }

  /**
   * Intersect elegant array list.
   *
   * @param array1 the array 1
   * @param array2 the array 2
   * @return the array list
   */
  public ArrayList<Integer> intersectElegant(int[] array1, int[] array2) {
    // array1: i length m
    // array2: i length n

    // loop through both arrays
    // if one element is less than the other ... there can be no intersection
    //  - increment the lower pointer
    //  - if elements are equal collect
    //    - then increment either of the pointers

    int i = 0;
    int m = array1.length;
    int j = 0;
    int n = array2.length;

    ArrayList<Integer> collector = new ArrayList<>();

    // O(n or m)
    while(i < m && j < n) {
      if(array1[i] < array2[j]) {
        i++;
      } else if(array2[j] < array1[i]) {
        j++;
      } else { // equal
        collector.add(array1[i]);
        i++;
      }
    }
    return collector;
  }
}
