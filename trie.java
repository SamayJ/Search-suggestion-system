import java.util.*;

class TrieNode{
    TrieNode[] childNode;
    boolean eow;
    
    TrieNode(){
        childNode = new TrieNode[26];
        eow = false;
    }
}

class Trie{
    TrieNode root ;

    Trie(){
        root = new TrieNode();
    }

    void insert(String word){
        TrieNode currentNode = root;
        for(char c:word.toCharArray()){
            int index = c-'a';
            if(currentNode.childNode[index] == null){
                currentNode.childNode[index] = new TrieNode();
            }
            currentNode = currentNode.childNode[index];
        }
        currentNode.eow = true;
    }

    public boolean search(String key){
        TrieNode currentNode = root;
        for(int i = 0; i<key.length();i++){
            int idx =key.charAt(i) -'a';
            if(currentNode.childNode[idx] == null){
                return false;
            }
            
            if(i == key.length() &&currentNode.childNode[idx].eow == false){
                return false;
            }
            currentNode = currentNode.childNode[idx];
        }
        return true;
    }

}
