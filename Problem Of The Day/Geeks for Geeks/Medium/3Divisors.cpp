
// https://practice.geeksforgeeks.org/problems/3-divisors3942/1

class Solution
{
public:
    void primeSieveAlgo(int N, vector<bool>& primes){
        primes[0] = primes[1] = false;
        
        for(int i = 2; i*i <= N; ++i){
            if(primes[i]){
                for(int j = 2*i; j <= N; j += i){
                    primes[j] = false;
                }
            }
        }
    }

    int solve(long long n, vector<bool>& primes){
        int count = 0;
        for(long long i = 2; i*i <= n; ++i){
            if(primes[i]){
                count += 1;
            }
        }
        
        return count;
    }


    vector<int> threeDivisors(vector<long long> query, int q)
    {
        const int N = 1e6+5;
        vector<bool> primes(N, true);
        vector<int> res;
        
        primeSieveAlgo(N, primes);
        
        
        for(int i = 0; i < q; ++i){
            int val = solve(query[i], primes);
            res.push_back(val);
        }
        
        return res;
    }
};