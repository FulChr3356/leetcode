package io.fulchr3356;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static ArrayList<Integer> toList(ListNode node){
        ArrayList<Integer> list = new ArrayList<>();
        while(node != null){
            list.add(node.val);
            node = node.next;
        }
        return list;
    }

    static ListNode toNode(ArrayList<Integer> list){
        ListNode node = new ListNode();
        ListNode head = node;
        for(int i: list){
            node.next = new ListNode(i);
            node = node.next;
        }

        return head.next;
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ArrayList<Integer> list = new ArrayList(toList(list1));
        list.addAll(toList(list2));
        Collections.sort(list);
        return toNode(list);
    }


    static int findMaxHeight(int[] height){
        int max = 0;
        for(int i: height)
            if(i > max)
                max = i;
        return max;
    }

    static boolean inRange(int i, int [] range){
        return i > range[0] && i < range[1];
    }

    static boolean foundMax(int begIndex,int [] heights){
        for(int i = begIndex; i < heights.length; i++ )
            if(heights[begIndex] < heights[i])
                return false;
        return true;
    }

    static int volume(int i,int k, int[] height){
        if(height[k] <= height[i])
            return (k - i) * height[k];
        else
            return  (k - i) * height[i];
    }


    public int maxArea(int[] height) {
        int current;
        int max = 0;
        int count = 0;
        int maxHeight = 0;
        int maxIndex = 0;
        int length = height.length - 1;
        // int maxHeight = findMaxHeight(height);

        int [] maxLine = new int [2];
        for(int i = 0; i < height.length; i++){
            for(int k = i; k < height.length; k++){
                if(height[i] < height[k] )
                    if(volume(i,length,height) < volume(k,length,height)){
                        // System.out.println("Breaking out of i: " + i + " and k: " + k);
                        break;
                    }
                if(inRange(i,maxLine) && inRange(k,maxLine) && height[k] < maxHeight)
                    continue;

                current = volume(i,k,height);
                if(current > max){
                    max = current;
                    maxLine[0] = i;
                    maxLine[1] = k;
                    maxHeight = height[k];
                    maxIndex = k;
                }
                count++;

            }
            System.out.println("Count: " + count);
            if(foundMax(i,height))
                return max;
        }
        // System.out.println(count);
        return max;
    }

    static int findLongest(String [] strs){
        int min = Integer.MAX_VALUE;
        int max = 0;
        char currChar = '\u0000';
        for(String str: strs)
            if(str.length() < min)
                min = str.length();

        for(int i = 0; i < min; i++){
            for(String str: strs){
                if(currChar == '\u0000'){
                    currChar = str.charAt(i);
                    continue;
                }
                if(currChar != str.charAt(i))
                    return max;
            }
            max ++;
            currChar = '\u0000';
        }
        return max;
    }
    public String longestCommonPrefix(String[] strs) {
        int max = findLongest(strs);
        if(max != 0)
            return strs[0].substring(0,max);
        else
            return "";
    }

    public int myAtoi(String s) {
        StringBuilder number = new StringBuilder();
        for(char c: s.toCharArray()){
            if(number.length() != 0 && !Character.isDigit(c))
                break;
            if(c == '\u0000' || c == ' ')
                continue;
            number.append(c);
        }
        String str = number.toString();
        if(str == "")
            return 0;
        if(str.charAt(0) == '+')
            str = str.substring(1,str.length());
        if(!str.matches("-?[0-9]+"))
            return 0;

        try{
            return new BigDecimal(str).setScale(0,RoundingMode.HALF_UP).intValueExact();
        }catch(NumberFormatException  | ArithmeticException e ){
            try{
                if(str.charAt(0) == '-')
                    return -2147483648;
                if(str.charAt(0) == '+' || str.matches("[0-9]+"))
                    return 2147483647;
                if(!str.matches("-?[0-9]+"))
                    return 0;
            }catch(NumberFormatException e2 ){
                return 0;
            }
        }
        return 0;
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

    public static void main(String[] args) {

//
        solution(7);

        }

    }
