import java.util.*;

class Main {

  // First Solution : time - 0(n) space 0(1) using two pointer approach

  private static int[] targetSum(int[] arr, int sum) {
    int left = 0;
    int right = arr.length - 1;

    while (left < right) {
      int currentSum = arr[left] + arr[right];
      if (currentSum == sum) {
        return new int[] { left, right };
      }
      if (currentSum > sum) {
        right--;
      } else {
        left++;
      }
    }

    return new int[] { -1, -1 };
  }

    // second Solution : time - 0(n) space 0(n) using hashmap


  private static int[] targetSum2(int[] arr, int sum) {
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      if (map.containsKey(sum - arr[i])) {
        return new int[] { map.get(sum - arr[i]), i };
      } else {
        map.put(arr[i], i);
      }
    }

    return new int[] { -1, -1 };
  }

  public static void main(String[] args) {
    int[] result = Main.targetSum(new int[] { 1, 2, 3, 4, 6 }, 6);
    System.out.println("[" + result[0] + " , " + result[1] + " ]");
    int[] result2 = Main.targetSum2(new int[] { 2, 5, 9, 11 }, 11);
    System.out.println("[" + result2[0] + " , " + result2[1] + " ]");
  }

}