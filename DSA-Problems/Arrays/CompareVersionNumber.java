// https://leetcode.com/problems/compare-version-numbers

class CompareVersionNumber {
    public int compareVersion(String v1, String v2) {
        int v1L = v1.length();
        int v2L = v2.length();
        int i=0, j=0;
        StringBuilder subV1 = new StringBuilder();
        StringBuilder subV2 = new StringBuilder();

        while(i<v1L || j<v2L) {
            subV1.setLength(0);
            subV2.setLength(0);
            while(i<v1L && v1.charAt(i)!='.') {
                subV1.append(v1.charAt(i));
                i++;
            }
            while(j<v2L && v2.charAt(j)!='.') {
                subV2.append(v2.charAt(j));
                j++;
            }

            if(i<=v1L && j<=v2L) {
                int subV1Value = Integer.parseInt(subV1.toString());
                int subV2Value = Integer.parseInt(subV2.toString());

                if(subV1Value<subV2Value) {
                    return -1;
                } else if (subV1Value>subV2Value) {
                    return 1;
                }
            } else if (i<=v1L && !subV1.isEmpty()) {
                int value = Integer.parseInt(subV1.toString());
                if(value!=0) {
                    return 1;
                }
            } else if (j<=v2L && !subV2.isEmpty()) {
                int value = Integer.parseInt(subV2.toString());
                if(value!=0) {
                    return -1;
                }
            }

            i++;
            j++;
        }

        return 0;
    }
}