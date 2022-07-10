package io.fulchr3356;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {

    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        while(head != null){
            if(map.containsKey(head)){
                return true;
            }
            else
                map.put(head,head.val);
            head = head.next;
        }
        return false;
    }

    public boolean isPalindrome(int x) {
        String num = String.valueOf(x);
        for(int i = 0; i < num.length() / 2; i++)
            if(num.charAt(i) != num.charAt(num.length()-i - 1))
                return false;
        return true;
    }
    public int reverse(int x) {
        boolean negative = false;
        String number = String.valueOf(x);
        StringBuilder builder = new StringBuilder();
        for(char c: number.toCharArray()){
            if(c == '-'){
                negative = true;
                continue;
            }
            builder.append(c);
        }
        try{
            if(negative)
                return Integer.parseInt("-" + builder.reverse().toString());
            else
                return Integer.parseInt(builder.reverse().toString());
        }
        catch(NumberFormatException e){
            return 0;
        }
    }


    static boolean repeatings(String s){
        HashMap<Character,Integer> characters = new HashMap<>();
        // ArrayList<Character> characters = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(characters.containsKey(c))
                return false;
            else
                characters.put(c,0);
        }
        return true;
    }
    public int lengthOfLongestSubstrings(String s) {
        String tempString = "";
        String currMax = "";
        for(int i = 0; i < s.length(); i++){
            for(int k = s.length(); k >= i; k--){
                if(k - i < currMax.length())
                    continue;
                tempString = s.substring(i,k);
                if(repeatings(tempString)){
                    if(tempString.length() == s.length())
                        return tempString.length();
                    currMax = tempString;
                }

            }
        }
        return currMax.length();

    }


    public String convert(String s, int numRows) {
        if(numRows == 1)
            return s;
        int length = (int) Math.ceil((s.length() / 2.0));
        char[][] zigzag = new char[numRows][length];
        int column = 0;
        int row = 0;
        boolean backToZero = false;
        for(int i = 1; i <= s.length(); i ++){
            zigzag[row][column] = s.charAt(i-1);
            if( row == numRows -1)
                backToZero = true;
            if(row == 0)
                backToZero = false;
            if(backToZero){
                row--;
                column++;
            }else{
                row++;
            }

        }
        StringBuilder converted = new StringBuilder();
        for(char [] n : zigzag)
            for(char c: n)
                if(c != '\u0000')
                    converted.append(c);

        return converted.toString();
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i: nums1)
            list.add(i);
        for(int  i: nums2)
            list.add(i);
        Collections.sort(list);
        int size = list.size();
        if(list.size() % 2 != 0)
            return (double) list.get( size / 2);
        else
            return (double) (list.get(size / 2) + (double) list.get((size/ 2) - 1)) / 2;


    }

    static boolean repeating(String s){
        HashMap<Character,Integer> characters = new HashMap<>();
        // ArrayList<Character> characters = new ArrayList<>();
        for(char c: s.toCharArray()){
            if(characters.containsKey(c))
                return false;
            else
                characters.put(c,0);
        }
        return true;
    }
    public int lengthOfLongestSubstring(String s) {
        int currMax = 0;
        String currMaxSubString = "";
        int i = 0;
        while(true)
            if(currMax >= 127)
                return currMax;
        for(int k = i; k < s.length(); k++){
            // if(k - i < currMax)
            //     break;
            if(repeating(s.substring(i,k))){
                if(s.substring(i,k).length() > currMax)
                    currMax = s.substring(i,k).length();
            }else{
                i = k - 1;
            }

        }


    }
    // substrings.sort(Comparator.comparingInt(String::length));
    // System.out.println(substrings);
    // for(int i = substrings.size() -1; i >= 0; i --){
    //     if(repeating(substrings.get(i)))
    //         return substrings.get(i).length();
    // }
        return currMax;

}




    static List<Integer> deleteDup(int [] numbers ){
        Map<Integer,Integer> number = new HashMap<>();

        for(int i = 0; i < numbers.length; i++){
            if (number.containsKey(numbers[i]))
                numbers[i] = -1;
            else
                number.put(numbers[i],1);
        }
        ArrayList <Integer> list = new ArrayList<>();
        for (int j : numbers) {
            if (j != -1)
                list.add(j);
        }

        return list;
    }

    static  ArrayList<Double> powerVals(int n){
        double val = 0;
        ArrayList<Double> vals = new ArrayList<>();
        int i = 0;
        while (val <= n ){
            val = Math.pow(2,i);
            vals.add(val);
            i++;
        }
        return vals;
    }

    public static void solution(int N) {
        // write your code in Java SE 8
        ArrayList<Double> list = powerVals(N);
        for(int i = 1; i <=N; i++){
            if(list.contains(i))
                System.out.println("POWER");
            else
                System.out.println(i);

        }
    }


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    static int getNum(ListNode node){
        String num = "";
        while(node != null){
            num += Integer.toString(node.val);
            node = node.next;
        }
        BigInteger
        return Integer.parseInt(new StringBuilder(num).reverse().toString());
    }

    static ListNode toNode(int num){
        ListNode node = new ListNode();
        ListNode head = node;
        String numString = new StringBuilder(Integer.toString(num)).reverse().toString();
        int counter = 0;
        for(char c: numString.toCharArray()){
            node.val = Integer.parseInt(String.valueOf(c));
            if(counter == numString.length() -1)
                break;
            node.next = new ListNode();
            node = node.next;
            counter++;
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return toNode(getNum(l1) + getNum(l2));

    }
}

    public boolean solution(String S) {
        // write your code in Java SE 8
        boolean aFound = false;
        boolean bFound = false;
        for (char c: S.toCharArray()){
            if(c == 'a' && bFound){
                return false;
            }
            else if (c == 'a' && bFound){
                aFound = true;
            }
            else if(c == 'b' ){
                bFound = true;
            }
        }
        return true;
    }

    static boolean isPalindromic(String s ){
        for(int i = 0; i < s.length() / 2; i++){
            if(s.charAt(i) != s.charAt(s.length() -i - 1)){
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome(String s) {
        String currMax = "";
        String tempString;
        for(int i = 0; i < s.length(); i++){
            for(int k = s.length(); k >= i; k--){
                if(k - i < currMax.length())
                    continue;
                tempString = s.substring(i,k);
                if(isPalindromic(tempString)){
                    if(tempString.length() == s.length())
                        return tempString;
                    currMax = tempString;
                }

            }

        }
        return currMax;
    }

    public static void main(String[] args) {

//
        solution(7);

    }

}
