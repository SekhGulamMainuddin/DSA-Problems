// https://leetcode.com/problems/roman-to-integer/

public class RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        char[] cArray = s.toCharArray();

        int i = 0;

        while(i<cArray.length) {
            sum+=getValue(cArray[i]);
            if(i!=cArray.length-1) {
                int addOn = getAddon(cArray[i], cArray[i+1]);
                if(addOn!=0) {
                    sum-=getValue(cArray[i]);
                    sum+=addOn;
                    i++;
                }
            }
            i++;
        }

        return sum;
    }

    private int getValue(char c) {
        switch(c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }

    private int getAddon(char c, char n) {
        if(c=='I' && (n=='V' || n=='X')) {
            if(n=='V') {
                return 4;
            }
            return 9;
        } else if (c=='X' && (n=='L' || n=='C')) {
            if(n=='L') {
                return 40;
            }
            return 90;
        } else if (c=='C' && (n=='D' || n=='M')) {
            if(n=='D') {
                return 400;
            }
            return 900;
        }
        return 0;
    }
}