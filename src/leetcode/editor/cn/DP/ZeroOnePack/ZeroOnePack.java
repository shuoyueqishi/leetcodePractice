package leetcode.editor.cn.DP.ZeroOnePack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZeroOnePack {
    public static void main(String [] args){
        System.out.println("开始计算01背包问题");
        Scanner sc = new Scanner(System.in);
        System.out.printf("背包容量：");
        int capacity = sc.nextInt();
        int objNum=4;
        Good good0 = new Good(0,0);
        Good good1 = new Good(3,2);
        Good good2 = new Good(2,3);
        Good good3 = new Good(4,5);
        Good good4 = new Good(5,6);
        List<Good> goods=new ArrayList<>(objNum);
        goods.add(good0);
        goods.add(good1);
        goods.add(good2);
        goods.add(good3);
        goods.add(good4);
        int[][] dparr= dp(goods,capacity);
        System.out.println("最大价值："+dparr[objNum][capacity]);
    }
    public static int[][] dp(List<Good> goodList, int capacity) {
        int objNum = goodList.size();
        int[][] dp=new int[objNum+1][capacity+1];
        // 首行首列设置为0
        for(int i=0;i<=capacity;i++){
            dp[0][i]=0;
        }
        for(int i=1;i<=objNum;i++) {
            dp[i][0] =0;
        }
        // 开始动态规划
        for(int i=1;i<objNum;i++) {
            for(int j=1;j<=capacity;j++) {
                int weight=goodList.get(i).getWeight();
                int value = goodList.get(i).getValue();
                if(j<weight){
                    dp[i][j] = dp[i-1][j];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-weight]+value);
                }
                System.out.printf("%-4d",dp[i][j]);
            }
            System.out.println();
        }
        return dp;
    }
}
