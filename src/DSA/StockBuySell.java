package DSA;

public class StockBuySell {
    public static void solver(int[] prices){
        int profit, maxProfit = 0, left = 0, right;
        for(right=0;right<prices.length;right++){
            profit = prices[right] - prices[left];
            maxProfit = Math.max(maxProfit, profit);
            if(profit < 0)
                left = right;
        }
        System.out.println("Max Profit: "+maxProfit);
    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        solver(prices);
    }
}
