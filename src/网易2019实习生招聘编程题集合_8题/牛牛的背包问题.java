package 网易2019实习生招聘编程题集合_8题;

/**
 * Created by 赵 on 2018/5/17
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
 * 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * <p>
 * 输入描述:
 * 输入包括两行
 * 第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
 * 第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个正整数, 表示牛牛一共有多少种零食放法。
 * <p>
 * 输入例子1:
 * 3 10
 * 1 2 4
 * <p>
 * 输出例子1:
 * 8
 * <p>
 * 例子说明1:
 * 三种零食总体积小于10,于是每种零食有放入和不放入两种情况，一共有2*2*2 = 8种情况。
 */

import java.util.*;

public class 牛牛的背包问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int w = sc.nextInt();
        int[] v = new int[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            sum += v[i];
        }
        sc.close();

        if (sum <= w) {
            System.out.println((int)Math.pow(2, n));
            return;
        }

        Arrays.sort(v);
        int max = sum(w, v, 0);
        System.out.println(max);
    }

    private static int sum(int w, int[] v, int index) {
        if (v.length == index)
            return 1;
        if (w < v[index])
            return 1;
        else
            return sum(w - v[index], v, index + 1) + sum(w, v, index + 1);
    }
}
