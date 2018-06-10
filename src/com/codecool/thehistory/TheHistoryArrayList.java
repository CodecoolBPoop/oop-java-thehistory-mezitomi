package com.codecool.thehistory;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.*;

public class TheHistoryArrayList implements TheHistory {
    /**
     * This implementation should use a String ArrayList so don't change that!
     */
    private List<String> wordsArrayList = new ArrayList<>();

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        this.wordsArrayList = new ArrayList<>(Arrays.asList(text.split(" ")));
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        this.wordsArrayList.removeAll(new ArrayList<>(Collections.singletonList(wordToBeRemoved)));
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return this.wordsArrayList.size();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        this.wordsArrayList.clear();
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        if (!from.equals(to)) {
            for (int i = 0; i < this.wordsArrayList.size(); i++) {
                if (this.wordsArrayList.get(i).equals(from)) {
                    this.wordsArrayList.set(i, to);
                }
            }
        }
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information


    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArrayList) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

}
