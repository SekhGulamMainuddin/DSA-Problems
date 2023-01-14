
// https://leetcode.com/problems/implement-trie-prefix-tree/description/

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
    
    bool searchWord(TrieNode* root, string word){
        if(word.length()==0){
            return root->isEnd;
        }

        int index= word[0] - 'a';
        TrieNode* child;
        if(root->children[index]==NULL){
            return false;
        }
        else{
            child= root->children[index];
        }

        return searchWord(child, word.substr(1));
    }

    bool search(string word) {
        return searchWord(root, word);
    }

    bool searchPrefix(TrieNode* root, string word){
        if(word.length()==0){
            return true;
        }

        int index= word[0] - 'a';
        TrieNode* child;
        if(root->children[index]==NULL){
            return false;
        }
        else{
            child= root->children[index];
        }

        return searchPrefix(child, word.substr(1));

    }
    
    bool startsWith(string prefix) {
        return searchPrefix(root, prefix);
    }
};

/**
 * Your Trie object will be instantiated and called as such:
 * Trie* obj = new Trie();
 * obj->insert(word);
 * bool param_2 = obj->search(word);
 * bool param_3 = obj->startsWith(prefix);
 */