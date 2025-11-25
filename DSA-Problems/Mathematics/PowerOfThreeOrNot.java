// https://leetcode.com/problems/power-of-three/

class PowerOfThreeOrNot {
    public boolean isPowerOfThree(int n) {
        // double x = Math.log10(n)/Math.log10(3);

        // return x == (int)x;
        if(n<1) {
            return false;
        }
        return Math.pow(3, 19)%n == 0;
    }
}