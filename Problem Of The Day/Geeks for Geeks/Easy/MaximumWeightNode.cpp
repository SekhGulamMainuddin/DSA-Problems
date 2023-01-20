
// https://practice.geeksforgeeks.org/problems/b64485d3994958cca8748991bb58668204b3e4c0/1

class Solution
{
  public:
   int maxWeightCell(int N, vector<int> Edge)

  {

      vector<int>v(N,0);

      int ans=0,max_weight=INT_MIN;

      for(int i=0;i<Edge.size();i++)

      {   

          if(Edge[i]!=-1)

          {

              v[Edge[i]]=v[Edge[i]]+i;

              if(max_weight<v[Edge[i]])

              {

                  max_weight=v[Edge[i]];

                  ans=Edge[i];

              }

              if(max_weight==v[Edge[i]])

              {

                  ans=max(ans,Edge[i]);

              }

          }

 

      }

      

     return ans;

  }
};