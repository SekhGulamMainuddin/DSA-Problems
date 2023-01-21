
// https://practice.geeksforgeeks.org/problems/1fc4278adf2a36780f637c7b4cd06391dd1487e4/1

class Solution {
  public:
    int minVal(int a, int b) {
        // code here

        int sum=a;
        int cnta=0;
        int cntb=0;

        for(int i=0;i<32;i++)
        {
            if((1<<i)&a)
            {
                cnta++;
            }
            if((1<<i)&b)
            {
                cntb++;
            }
        }
        if(cnta==cntb)
        {
            return a;
        }
        else if(cnta>cntb)
        {
            int sum=a;
            for(int i=0;i<32;i++)
            {
                if((1<<i)&a)
                {
                    sum=sum^(1<<i);
                    cnta--;
                    if(cnta==cntb)
                    {
                        return sum;
                    }
                }
            }
        }
        else 
        {
            int sum=a;
            for(int i=0;i<32;i++)
            {
                if(((1<<i)&a)==0)
                {
                    sum=sum|(1<<i);
                    cnta++;
                    if(cnta==cntb)
                    {
                        return sum;
                    }
                }
            }
        }
    }
};