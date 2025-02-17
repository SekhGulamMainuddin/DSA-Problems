class Fibonnaci {
    public static void main(String[] args){
        int n = 9;
        System.out.println("Fibonacci of " + n + " is " + fib(n));  // call to fibonacci function
    }

    public static int fib(int n) {

        if(n <= 1)  //base case
            return n;

        return fib(n - 1) + fib(n - 2); // recurrence relation
    }
}