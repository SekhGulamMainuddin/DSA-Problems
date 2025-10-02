// https://leetcode.com/problems/water-bottles/

class WatterBottles1 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = 0;
        while(numBottles>=numExchange) {
            total += numExchange;
            numBottles = numBottles - numExchange +1;
        }
        total += numBottles;
        return total;
    }
}