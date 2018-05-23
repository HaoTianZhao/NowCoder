package 网易2018校园招聘编程题真题集合_8题;

/**
 * Created by 赵 on 2018/5/18
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：100768K
 * <p>
 * 小易有一个长度为N的正整数数列A = {A[1], A[2], A[3]..., A[N]}。
 * 牛博士给小易出了一个难题:
 * 对数列A进行重新排列,使数列A满足所有的A[i] * A[i + 1](1 ≤ i ≤ N - 1)都是4的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * 输入描述:
 * 输入的第一行为数列的个数t(1 ≤ t ≤ 10),
 * 接下来每两行描述一个数列A,第一行为数列长度n(1 ≤ n ≤ 10^5)
 * 第二行为n个正整数A[i](1 ≤ A[i] ≤ 10^9)
 * <p>
 * <p>
 * 输出描述:
 * 对于每个数列输出一行表示是否可以满足牛博士要求,如果可以输出Yes,否则输出No。
 * <p>
 * 输入例子1:
 * 2
 * 3
 * 1 10 100
 * 4
 * 1 2 3 4
 * <p>
 * 输出例子1:
 * Yes
 * No
 * <p>
 * 1
 * 72
 * 690 782 498 838 278 956 532 798 532 776 728 176 578 168 858 202 166 312 712 208 720 736 400 692 884 516 624 46 426 108 310 730 58 668 416 661 698 582 28 630 966 678 647 4 720 495 821 369 1000 332 701 347 861 721 820 508 162 150 671 697 263 672 82 640 387 752 499 990 33 516 367 17
 */

import java.util.*;

/**
 * 令最少能除2个2的数叫2，以此类推，还有数1和0。
 * 此题思路为：最少能整除2个2的数，可以自消；最少整除1个2的数，需要另一个1或者半个2；
 *          最多除0个2的数，每个需要一个2，若0的个数大于1则有两个0只要半个2；因为数列个数大于2时，左右边界各相当于半个2
 * 另注意特殊情况：数列中只有一个数。
 */
public class 重排数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        while (n-- > 0) {
            int count = sc.nextInt();
            if (1 == count) {
                sc.nextInt();
                System.out.println("Yes");
                continue;
            }
            int zero = 0, one = 0, two = 0;
            for (int i = 0; i < count; i++) {
                int number = sc.nextInt();
                if (number % 4 == 0)
                    two++;
                else if (number % 2 == 0)
                    one++;
                else
                    zero++;
            }
            double min = 0;
            min += zero > 2 ? zero - 1 : (double) zero / 2;
            min += one > 0 ? 0.5 : 0;
            if (min <= two)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
        sc.close();
    }
}
