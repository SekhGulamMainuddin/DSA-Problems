// https://leetcode.com/problems/integer-to-roman/

public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] romanValues = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romanSymbol = {"M", "CM", "D", "CD", "C", "XC", "L","XL", "X", "IX", "V", "IV", "I"};
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<romanValues.length; i++) {
            int divisionValue = romanValues[i];
            int value = num/divisionValue;
            if(value!=0) {
                for(int j=0; j<value; j++) {
                    ans.append(romanSymbol[i]);
                }
                num = num%divisionValue;
            }
        }

        return ans.toString();
    }
}
