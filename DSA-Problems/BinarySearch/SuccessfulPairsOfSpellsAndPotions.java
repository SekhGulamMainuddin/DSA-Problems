import java.util.Arrays;

// https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

public class SuccessfulPairsOfSpellsAndPotions {
    static class Pair implements Comparable<Pair> {
        final int index;
        final int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public int[] successfulPairs(int[] spellsArr, int[] potions, long success) {
        Pair[] spells = new Pair[spellsArr.length];
        for(int i=0; i<spellsArr.length; i++) {
            spells[i] = new Pair(i, spellsArr[i]);
        }
        Arrays.sort(spells);
        Arrays.sort(potions);
        int j = 0;
        int[] ans = new int[spells.length];

        for (int i = spells.length-1; i>=0; i--) {
            if (j < potions.length) {
                int s=j, e=potions.length-1;
                int mid = s+(e-s)/2;
                long product;
                j = potions.length;
                while (s<=e) {
                    mid = s+(e-s)/2;
                    product = (long) spells[i].value * (long) potions[mid];
                    if (product>=success) {
                        j=mid;
                        e=mid-1;
                    } else {
                        s=mid+1;
                    }
                }
            }

            ans[spells[i].index] = potions.length - j;
        }
        return ans;
    }
}

/// Two Pointer
class SuccessfulPairsOfSpellsAndPotionsTwoPointer {
    static class Pair implements Comparable<Pair> {
        final int index;
        final int value;

        Pair(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.value, o.value);
        }
    }

    public int[] successfulPairs(int[] spellsArr, int[] potions, long success) {
        Pair[] spells = new Pair[spellsArr.length];
        for(int i=0; i<spellsArr.length; i++) {
            spells[i] = new Pair(i, spellsArr[i]);
        }
        Arrays.sort(spells);
        Arrays.sort(potions);
        int j = 0;
        int[] ans = new int[spells.length];

        for (int i = spells.length-1; i>=0; i--) {
            if (j < potions.length) {
                long product;
                while (true) {
                    product = (long) spells[i].value * (long) potions[j];
                    j++;
                    if(product >= success) {
                        j--;
                        break;
                    } else if (j==potions.length) {
                        break;
                    }
                }
            }

            ans[spells[i].index] = potions.length - j;
        }
        return ans;
    }
}