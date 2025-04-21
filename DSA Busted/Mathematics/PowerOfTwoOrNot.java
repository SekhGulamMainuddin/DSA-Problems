
//https://leetcode.com/problems/power-of-two/submissions/

/**
 * Checks whether a given integer is a power of two.
 * 
 * Explanation:
 * - Case 1: Zero and negative numbers cannot be powers of two.
 * - Case 2: For a number to be a power of two, only one bit should be set in its binary representation.
 *   Example:
 *     - 16 (2^4)  => 10000
 *     - 256 (2^8) => 100000000
 * 
 *   For such numbers:
 *     - (n - 1) will have all lower bits set. For example:
 *         n = 16 => n - 1 = 15 => 01111
 *     - (n | (n - 1)) will set all lower bits as well, giving (2n - 1)
 *     - So: (n | (n - 1)) ^ ((2 * n) - 1) == 0 for powers of 2
 * 
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */

public class PowerOfTwoOrNot {
    
    public boolean isPowerOfTwo(int n) {
        // Zero or negative numbers are not powers of two
        if (n <= 0) {
            return false;
        }

        // For powers of 2, this expression will evaluate to true
        return ((n | (n - 1)) ^ ((n * 2) - 1)) == 0;
    }
}
