
//https://leetcode.com/problems/string-compression/


class Solution {
    public int compress(char[] chars) {
        char c=chars[0];
        int count=1;
        int j=0;
        for(int i=1;i<chars.length;i++){
            if(c==chars[i]){
                count++;
            }else{
                chars[j++]=c;
                if(count!=1){
                    if(count>9){
                        String ct=String.valueOf(count);
                        for(int k=0;k<ct.length();k++){
                            chars[j++]=ct.charAt(k);
                        }
                    }
                    else{
                        chars[j++]=Character.forDigit(count,10);
                    }
                }
                c=chars[i];
                count=1;
            }
        }
        chars[j++]=c;
        if(count!=1){
            if(count>9){
                String ct=String.valueOf(count);
                for(int k=0;k<ct.length();k++){
                    chars[j++]=ct.charAt(k);
                }    
            }
            else{
                chars[j++]=Character.forDigit(count,10);
            }
        }
        return j;
    }
}


// class Solution {
//     public int compress(char[] chars) {
//         String s="";
//         int count=1;
//         int l=chars.length;
//         for(int i=0;i<l-1;i++){
//             if(chars[i]==chars[i+1]){
//                 count++;
//             }else{
//                 if(count==1){
//                     s=s+chars[i];
//                 }else{
//                     s=s+chars[i]+String.valueOf(count);
//                 }
//                 count=1;
//             }
//         }
//         if(count==1){
//             s=s+chars[l-1];
//         }else{
//             s=s+chars[l-1]+String.valueOf(count);
//         }
//         for(int i=0;i<s.length();i++){
//             chars[i]=s.charAt(i);
//         }
//         return s.length();
//     }
// }