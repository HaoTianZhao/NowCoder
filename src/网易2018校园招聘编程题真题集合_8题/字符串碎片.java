package 网易2018校园招聘编程题真题集合_8题;

/**
 * Created by 赵 on 2018/5/17
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 一个由小写字母组成的字符串可以看成一些同一字母的最大碎片组成的。例如,"aaabbaaac"是由下面碎片组成的:'aaa','bb','c'。牛牛现在给定一个字符串,请你帮助计算这个字符串的所有碎片的平均长度是多少。
 * <p>
 * 输入描述:
 * 输入包括一个字符串s,字符串s的长度length(1 ≤ length ≤ 50),s只含小写字母('a'-'z')
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示所有碎片的平均长度,四舍五入保留两位小数。
 * <p>
 * 如样例所示: s = "aaabbaaac"
 * 所有碎片的平均长度 = (3 + 2 + 3 + 1) / 4 = 2.25
 * <p>
 * 输入例子1:
 * aaabbaaac
 * <p>
 * 输出例子1:
 * 2.25
 */

import java.util.*;

/**
 * 注意，system.out.format会自动四舍五入
 */
public class 字符串碎片 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        int n = s.length();
        int sum = 0;
        int time = 0;
        int count = 1;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == (s.charAt(i + 1)))
                count++;
            else {
                sum += count;
                time++;
                count = 1;
            }
        }
        sum += count;
        time++;

        double result = (double)sum / time;
        System.out.format("%.2f", result);
    }
}
