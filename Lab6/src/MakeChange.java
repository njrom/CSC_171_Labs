public class MakeChange {

    public static void main(String[] args) {
        System.out.println(makeChange(100,25)); //Cents and Highest coin to start with are the inputs
    }

    public static int makeChange(int n, int currentCoin) {
        int nextCoin = 0;
        switch (currentCoin) {
            case 25:
                nextCoin = 10;
                break;
            case 10:
                nextCoin = 5;
                break;
            case 5:
                nextCoin = 1;
                break;
            case 1:
                return 1;
        }
        int possibleWays = 0;
        for (int i = 0; i * currentCoin <= n; i++) possibleWays += makeChange(n - i * currentCoin, nextCoin);
        return possibleWays;
    }
}

