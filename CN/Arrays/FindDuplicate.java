/*
Find Duplicate

You have been given an integer array/list(ARR) of size N which contains numbers from 0 to (N - 2). 
Each number is present at least once. That is, if N = 5, 
the array/list constitutes values ranging from 0 to 3 and among these, 
there is a single integer value that is present twice. 
You need to find and return that duplicate number present in the array.
Note :
Duplicate number is always present in the given array/list.
Input format :
The first line contains an Integer 't' which denotes the number of test cases or queries to be run. Then the test cases follow.

First line of each test case or query contains an integer 'N' representing the size of the array/list.

Second line contains 'N' single space separated integers representing the elements in the array/list.
Output Format :
For each test case, print the duplicate element in the array/list.

Output for every test case will be printed in a separate line.
Constraints :
1 <= t <= 10^2
0 <= N <= 10^3
Time Limit: 1 sec
Sample Input 1:0,3
1
9
0 7 2 5 4 7 1 3 6
Sample Output 1:
7
Sample Input 2:
2
5
0 2 1 3 1
7
0 3 1 5 4 3 2
Sample Output 2:
1
3
*/


package com.rishabh.arrays.assignments;

import java.util.Scanner;

public class FindDuplicate {
    public static void main(String[] args) {
//        int[] arr = {0,3,1,5,4,3,2};
//        System.out.println(duplicateee(arr));

        Scanner input = new Scanner(System.in);
        int testCase = input.nextInt();
        int i = 0;
        int[] ans = new int[testCase];
        while (testCase != 0){
            int n = input.nextInt();
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = input.nextInt();
            }
            ans[i] = duplicateee(arr);
            i++;
            testCase--;
        }

        for (int j = 0; j < ans.length; j++) {
            System.out.println(ans[j]);
        }

    }


    //brute force
    static int duplicate(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0;  j < arr.length ; j++) {
                if(i != j && arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    //XOR approach
    static int duplicatee(int[] arr){
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans ^= arr[i];
        }
        for (int i = 0; i < arr.length-2; i++) {
            ans ^= i;
        }

        return ans;
    }


    //Using the sum of natural numbers
    static int duplicateee(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        int n = arr.length;

        return sum - ((n-2) * (n-1))/2;
    }
}
