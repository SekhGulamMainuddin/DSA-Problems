class LCM {
    // Find LCM of Two numbers
    public static void main(String [] args){
        int a = 100000;
        int b = 100000;
        System.out.format(" LCM of %d and %d is: %d ", a, b, lcm(a,b));
    }
    static int gcd(int a, int b){
        if(a == 0)
            return b;
        return gcd(b % a , a);
    }
    static int lcm(int a, int b){
        return a*(b/gcd(a,b));
    }
}