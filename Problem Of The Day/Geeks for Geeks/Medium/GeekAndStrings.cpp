
//https://practice.geeksforgeeks.org/problems/geek-and-strings3030/1

class Node{
      public :
          int count;
          char data;
          vector<Node*>children;
          Node(char ch){
              count=0;
              data=ch;
              children.resize(26,NULL);
          }
    };
    
    class Trie{
      public :
      Node* root;
      Trie(){
          root=new Node('\0');
      }
      
      void insert(string &word){
          auto node=root;
          for(char w:word){
              if(!node->children[w-'a'])
                  node->children[w-'a']=new Node(w);
              node=node->children[w-'a'];
              node->count++;
          }
      }
      
      int getCount(string &word){
          auto node=root;
          for(char w:word){
               if(!node->children[w-'a']) return 0;
              node=node->children[w-'a'];
          }
           return node->count;
      }
      
      
    };
public:
    vector<int> prefixCount(int N, int Q, string li[], string query[]){
       Trie t;
       for(int i=0;i<N;i++)
            t.insert(li[i]);
        vector<int>res;
        for(int i=0;i<Q;i++)
            res.push_back(t.getCount(query[i]));
        
        return res;
       
    }