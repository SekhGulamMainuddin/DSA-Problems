// https://leetcode.com/problems/power-of-four/

class PowerOfFourOrNot {
    public boolean isPowerOfFour(int n) {
        if (n == 1 || n == 4) {
            return true;
        } else if (n < 16) {
            return false;
        }
        boolean isEven = ((n & (n - 1)) == 0);
        if(isEven && (n%10 == 4 || n%10 == 6)) {
            return true;
        }
        return false;
    }
}