package 网易2019实习生招聘编程题集合_8题;

/**
 * Created by 赵 on 2018/5/14
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 * <p>
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * <p>
 * <p>
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * <p>
 * 输入例子1:
 * 5 2 (43487 0)
 * <p>
 * 输出例子1:
 * 7 (1891119169)
 * <p>
 * 例子说明1:
 * 满足条件的数对有(2,3),(2,4),(2,5),(3,4),(3,5),(4,5),(5,3)
 */

import java.util.*;

public class 数对 {

    //注意(x,y)是正整数对，且k有可能为0
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.close();

        long count = 0;
        for (int i = Math.max(1, k); i < n; i++) {
            count += (n - i);
        }
        for (int j = k + 1; j <= n; j++) {
            int a = j - k;
            int b = n / j;
            count += a * (b - 1);
            int c = n % j;
            if (c >= k)
                count += c - k + 1;
        }
        System.out.println(count);

    }

}
