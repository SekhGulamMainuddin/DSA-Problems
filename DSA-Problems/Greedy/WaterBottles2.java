// https://leetcode.com/problems/water-bottles-ii/

class WaterBottles2 {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int total = 0;
        while(numBottles>=numExchange) {
            total += numExchange;
            numBottles = numBottles - numExchange +1;
            numExchange++;
        }
        total += numBottles;
        return total;
    }
}