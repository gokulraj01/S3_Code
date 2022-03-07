class PrimePrint{
    static boolean prime(int n){
        int r = (int) Math.sqrt(n);
        if(n < 2)
            return false;
        for(int i=2; i<=r; i++){
            if(n%i == 0)
                return false;
        }
        return true;
    }

    public static void main(String args[]) {
        int i = 0, n = 1;
        while(i < 100){
            if(prime(n)){
                System.out.print(n+", ");
                i++;
            }
            n++;
        }
        System.out.println();
    }
}
