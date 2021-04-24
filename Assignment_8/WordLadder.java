package INFO6205.Assignment_8;

import java.util.*;

public class WordLadder {
    public static int ladderLength(String beginWord, String endWord, List<String> wordList){
        if(beginWord == null || endWord == null || beginWord.length() == 0 || endWord.length() ==0){
            return 0;
        }
        Set<String> wordListSet = new HashSet<>();
        boolean isPresent = false;
        for(String word : wordList){
            wordListSet.add(word);
        }
        if(!wordListSet.contains(endWord)){
            return 0;
        }
        wordListSet.remove(beginWord);
        Queue<String> eachWordQ = new LinkedList<String>();
        eachWordQ.add(beginWord);
        int depth = 1;
        while(!eachWordQ.isEmpty()){
            int wSize = eachWordQ.size();
            isPresent = false;
            while(wSize-- !=0){
                String currentWord = eachWordQ.remove();
                for(int i =0; i < currentWord.length(); i++ ){
                    for(char c ='a'; c <= 'z'; c++){
                        StringBuilder tempWord1 = new StringBuilder(currentWord);
                        tempWord1.setCharAt(i,c);
                        String tempWord = tempWord1.toString();

                        if(tempWord.equals(endWord)){
                            return depth+1;
                        }
                        if(wordListSet.contains(tempWord)){
                            eachWordQ.add(tempWord);
                            wordListSet.remove(tempWord);
                            isPresent = true;
                        }
                    }
                }
            }
            if(isPresent){
                depth++;
            }
        }
        return 0;
    }
    public static void main(String[] args){
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordListArray = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = new LinkedList<>();
        Collections.addAll(wordList,wordListArray);
        System.out.println(ladderLength(beginWord,endWord,wordList));

    }
}
