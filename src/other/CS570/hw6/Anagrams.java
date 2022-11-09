package other.CS570.hw6;
/*
 * other.CS570 Homework 6
 *
 * author: Songhan Yu
 * CWID: 10470449
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Anagrams {
  final Integer[] primes = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101};  // used to set up the letterTable
  Map<Character, Integer> letterTable;
  Map<Long, ArrayList<String>> anagramTable;  // hold the main working hash table

  public Anagrams() {
    letterTable = new HashMap<Character,Integer>();
    buildLetterTable();
    anagramTable = new HashMap<Long,ArrayList<String>>();
  }

  // receives the name of a text file containing words, one per line, and builds the hash table anagramTable
  public void processFile(String s) throws IOException {
    FileInputStream fstream = new FileInputStream(s);
    BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
    String aLineStr;
    while (( aLineStr = br.readLine()) != null ) {
      this.addWord(aLineStr);
    }
    br.close();
  }

  // invoked by the constructor for the class Anagrams and should build the hash table letterTable
  private void buildLetterTable() {
    Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    // map letter to the corresponding number
    for (int i = 0; i < 26; i++) {
      letterTable.put(alphabet[i], primes[i]);
    }
  }

  // given a string s, should compute its hash code
  private Long myHashCode(String s) {
    int i = 0;
    long key = 1;
    while (i < s.length()) {
      Character a = s.charAt(i);
      key = key * letterTable.get(a);
      i++;
    }
    return key;
  }

  // compute the hash code of the string s passed as argument, and should add this word to the hash table anagramTable
  private void addWord(String s) {
    if (anagramTable.containsKey(myHashCode(s))) {
      ArrayList<String> tmp = anagramTable.get(myHashCode(s));
      tmp.add(s);
      anagramTable.replace(myHashCode(s), tmp);
    } else {
      ArrayList<String> tmp = new ArrayList<String>();
      tmp.add(s);
      anagramTable.put(myHashCode(s), tmp);
    }
  }

  // return the entries in the anagramTable that have the largest number of anagrams
  protected ArrayList<Map.Entry<Long,ArrayList<String>>> getMaxEntries() {
    ArrayList<Map.Entry<Long,ArrayList<String>>> tmp = new ArrayList<Map.Entry<Long,ArrayList<String>>>();
    int maxSize = 0;
    for (Map.Entry<Long,ArrayList<String>> entry: anagramTable.entrySet()) {
      if (entry.getValue().size() > maxSize) {
        tmp.clear();
        tmp.add(entry);
        maxSize = entry.getValue().size();
      } else {
        if (entry.getValue().size() == maxSize)
          tmp.add(entry);
      }
    }
    return tmp;
  }

  public static void main(String[] args) {
    Anagrams a = new Anagrams ();

    final long startTime = System.nanoTime();
    try {
      a.processFile("words_alpha.txt");
    } catch (IOException e1) {
      e1.printStackTrace();
    }
    ArrayList<Map.Entry<Long,ArrayList<String>>> maxEntries = a.getMaxEntries();
    final long estimatedTime = System.nanoTime() - startTime;
    final double seconds = ((double) estimatedTime/1000000000);
    System.out.println("Time: "+ seconds);
    System.out.println("Key of max anagrams: " + maxEntries.get(0).getKey());
    System.out.println("List of max anagrams: "+ maxEntries.get(0).getValue());
    System.out.println("Length of list of max anagrams: "+ maxEntries.get(0).getValue().size());
  }
}