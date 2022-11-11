
// https://practice.geeksforgeeks.org/problems/primes-sum5827/1

#include<iostream>
#include<vector>
using namespace std;
vector<int> getPrimeNumbers(int N){
    vector<int> primeNumbers;
    vector<bool> prime;
    for(int i=0;i<N;i++){
        prime.push_back(true);
    }
    for (int i = 2; i < N; i++)
    {
        if (prime[i])
        {
            primeNumbers.push_back(i);
            for(int j=2*i; j<N; j+=i){
                prime[j]=false;
            }
        }        
    }
    return primeNumbers;
}

string isSumOfTwo(int N){
    vector<int> nums;
    nums=getPrimeNumbers(N);
    int i=0,j=nums.size()-1,sum;
    while(i<=j && i>=0 && j<nums.size()){
        sum=nums[i]+nums[j];
        if(sum<N)
            i++;
        else if(sum>N)
            j--;
        else
            return "Yes";
    }

    return "No";
}
int main(){
    int n=4;
    cout<<isSumOfTwo(n);
    return 0;
}