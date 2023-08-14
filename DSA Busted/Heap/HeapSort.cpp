
// https://practice.geeksforgeeks.org/problems/heap-sort/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

#include<iostream>
using namespace std;
class Solution
{
    public:
    //Heapify function to maintain heap property.
    void heapify(int arr[], int n, int i)  
    {
      // Your Code Here
        int largest= i;
        int left= 2*i + 1;
        int right= 2*i + 2;
        if(left<n && arr[largest]<arr[left])
            largest= left;
        if(right<n && arr[largest]<arr[right])
            largest= right;
        
        if(largest!=i){
            swap(arr[largest], arr[i]);
            heapify(arr, n, largest);
        }
        
    }

    public:
    //Function to build a Heap from array.
    void buildHeap(int arr[], int n)  
    { 
        for(int i= n/2-1; i>=0; i--)
            heapify(arr, n, i);
    }

    
    public:
    //Function to sort an array using Heap Sort.
    void heapSort(int arr[], int n)
    {
        //code here
        buildHeap(arr, n);
        int currSize= n;
        for(int i=0; i<n; i++){
            swap(arr[0], arr[currSize-1]);
            currSize--;
            heapify(arr, currSize, 0);
        }
        
        
    }
};


