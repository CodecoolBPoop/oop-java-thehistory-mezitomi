package com.codecool.thehistory;

import java.util.Arrays;

import static jdk.nashorn.internal.objects.NativeString.indexOf;
import static jdk.nashorn.internal.objects.NativeString.trim;

public class TheHistoryArray implements TheHistory {

    /**
     * This implementation should use a String array so don't change that!
     */
    private String[] wordsArray = new String[0];

    @Override
    public void add(String text) {
        //TODO: check the TheHistory interface for more information
        String[] textToArray = text.split("\\s+");
        String[] unitedArray = new String[this.size() + textToArray.length];
        System.arraycopy(this.wordsArray, 0, unitedArray, 0, this.size());
        System.arraycopy(textToArray, 0, unitedArray, this.size(), textToArray.length);
        this.wordsArray = unitedArray;
    }

    @Override
    public void removeWord(String wordToBeRemoved) {
        //TODO: check the TheHistory interface for more information
        int position = indexOf(this.wordsArray, wordToBeRemoved);
        while (position > -1) {
            String[] newWordsArray = new String[size() - 1];
            System.arraycopy(this.wordsArray, 0, newWordsArray, 0, position);
            System.arraycopy(this.wordsArray, position + 1, newWordsArray, position,
                    newWordsArray.length - position);
            this.wordsArray = newWordsArray;
            position = indexOf(this.wordsArray, wordToBeRemoved);
        }
    }

    @Override
    public int size() {
        //TODO: check the TheHistory interface for more information
        return wordsArray.length;
    }

    @Override
    public void replaceMoreWords(String[] fromWords, String[] toWords) {
        //TODO: check the TheHistory interface for more information

        while (true) {

            boolean foundExpression = false;
            int startingIndex = -1;
            for (int i = 0; i < (this.size() - fromWords.length - 1); i++) {
                if (this.wordsArray[i].equals(fromWords[0])) {
                    foundExpression = true;
                    for (int j = 1; j < fromWords.length; j++) {
                        if (!this.wordsArray[i + j].equals(fromWords[j])) {
                            foundExpression = false;
                            break;
                        }
                    }
                    if (foundExpression) {
                        startingIndex = i;
                        break;
                    }
                }
            }
            if (foundExpression) {

                String[] newArray = new String[this.size() - fromWords.length + toWords.length];
                System.arraycopy(this.wordsArray, 0, newArray, 0, startingIndex);
                System.arraycopy(toWords, 0, newArray, startingIndex, toWords.length);
                System.arraycopy(this.wordsArray, startingIndex + fromWords.length, newArray,
                        startingIndex + toWords.length, this.size() - startingIndex - fromWords.length);
                this.wordsArray = newArray;

            } else {
                break;
            }


        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String word : wordsArray) {
            sb.append(word).append(" ");
        }
        if (sb.length() > 0) sb.deleteCharAt(sb.length() - 1); // last space char
        return sb.toString();
    }

    @Override
    public void clear() {
        //TODO: check the TheHistory interface for more information
        wordsArray = new String[0];
    }

    @Override
    public void replaceOneWord(String from, String to) {
        //TODO: check the TheHistory interface for more information
        for (int i = 0; i < this.size(); i++) {
            if (this.wordsArray[i].equals(from)) {
                this.wordsArray[i] = to;
            }
        }
    }
}
