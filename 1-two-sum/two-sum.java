import java.util.HashMap;

class Solution {
  public static int[] twoSum(int[] nums, int target) {
      // 1. Iterate over every possible number pair
      for (int i = 0; i < nums.length; i++) {
          // j is always ahead of i so that we don't re-evaluate already evaluated sums
          for (int j = i + 1; j < nums.length; j++) {
              // 2. Check if a given pair adds up to our target
              if (nums[i] + nums[j] == target) {
                  // Return the indices when a pair has been found
                  return new int[]{i, j};
              }
          }
      }
      // Return an empty array if no pair is found
      return new int[]{};
  }
}