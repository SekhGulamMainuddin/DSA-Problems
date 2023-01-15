
// https://practice.geeksforgeeks.org/problems/phone-directory4628/1

class TrieNode{
    public:
        char ch;
        TrieNode* children[26];
        bool isEnd;

        TrieNode(char ch){
            this->ch= ch;
            for(int i=0; i<26; i++){
                children[i]= NULL;
            }
            isEnd= false;
        }

};
class Trie {
public:
    TrieNode* root;
    string prevAns="";
    Trie() {
        root= new TrieNode('\0');
    }
    
    void insertWord(TrieNode* root, string word){

        //Word isEmpty
        if(word.length()==0){
            root->isEnd= true;
            return;
        }

        int index= word[0] - 'a';
        TrieNode* child;
        if(root->children[index] != NULL){
            child= root->children[index];
        }else{
            child= new TrieNode(word[0]);
            root->children[index]= child;
        }
        
        insertWord(child, word.substr(1));

    }

    void insert(string word) {
        insertWord(root, word);
    }

    void addAllContacts(TrieNode* root, string currAns, vector<string> &ans){
        if(root->isEnd){
            ans.push_back(currAns);
        }
        for(int i=0; i<26; i++){
            TrieNode* temp= root->children[i];
            if(temp!=NULL){
                currAns.push_back(temp->ch);
                addAllContacts(temp, currAns, ans);
                currAns.pop_back();
            }
        }
    }

    void searchPrefix(char ch, vector<string> &ans){
        if(root!=NULL){
            TrieNode* temp= NULL;
            int index=ch-'a';
            prevAns.push_back(ch);
            if(root->children[index]!=NULL)
                addAllContacts(root->children[index], prevAns, ans);
            root= root->children[index];
        }
        if(ans.size()==0)
            ans.push_back("0");
    }
    
};

class Solution{
public:
    vector<vector<string>> displayContacts(int n, string contact[], string s)
    {
        // code here
        Trie* trie=new Trie();
        for(int i=0; i<n; i++)
            trie->insert(contact[i]);
        
        vector<vector<string>> ans;
        vector<string> currAns;
        
        for(int i=0; i<s.length(); i++){
            currAns.clear();
            trie->searchPrefix(s[i], currAns);
            ans.push_back(currAns);
        }
        
        return ans;
    }
};




