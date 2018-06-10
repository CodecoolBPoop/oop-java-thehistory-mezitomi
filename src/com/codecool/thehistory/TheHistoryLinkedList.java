package com.codecool.thehistory;

import java.util.*;

public class TheHistoryLinkedList implements TheHistory {
    /**
     * This implementation should use a String LinkedList so don't change that!
     */
    private List<String> wordsLinkedList = new LinkedList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        this.wordsLinkedList.addAll(Arrays.asList(text.split("\\s+")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        this.wordsLinkedList.removeAll(Collections.singletonList(wordToBeRemoved));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsLinkedList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        this.wordsLinkedList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
       while (this.wordsLinkedList.contains(from)) {
           this.wordsLinkedList.set(this.wordsLinkedList.indexOf(from), to);
       }

    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information

        ListIterator<String> listIter = wordsLinkedList.listIterator();
        while (listIter.hasNext()) {
            int matchingWordCount = 0;
            try {
                for (String fromWord : fromWords) {
                    String nextWord = listIter.next();
                    if (nextWord.equals(fromWord)) {
                        matchingWordCount++;
                    } else {
                        break;
                    }
                }
            } catch(Exception e) {
                break;
            }
            if (matchingWordCount == fromWords.length) {
                for (String ignored : fromWords) {
                    listIter.previous();
                    listIter.next();
                    listIter.remove();
                }
                for (String toWord : toWords) {
                    listIter.add(toWord);
                }
            } else {
                for (int j=0; j < matchingWordCount; j++) {
                    listIter.previous();
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsLinkedList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
