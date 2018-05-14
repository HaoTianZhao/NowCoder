package 网易2019实习生招聘编程题集合_8题;

import java.util.*;

/**
 * Created by 赵 on 2018/5/14
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 小Q正在给一条长度为n的道路设计路灯安置方案。
 * <p>
 * 为了让问题更简单,小Q把道路视为n个方格,需要照亮的地方用'.'表示, 不需要照亮的障碍物格子用'X'表示。
 * <p>
 * 小Q现在要在道路上设置一些路灯, 对于安置在pos位置的路灯, 这盏路灯可以照亮pos - 1, pos, pos + 1这三个位置。
 * <p>
 * 小Q希望能安置尽量少的路灯照亮所有'.'区域, 希望你能帮他计算一下最少需要多少盏路灯。
 * <p>
 * <p>
 * 输入描述:
 * 输入的第一行包含一个正整数t(1 <= t <= 1000), 表示测试用例数
 * 接下来每两行一个测试数据, 第一行一个正整数n(1 <= n <= 1000),表示道路的长度。
 * 第二行一个字符串s表示道路的构造,只包含'.'和'X'。
 * <p>
 * <p>
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示最少需要多少盏路灯。
 * <p>
 * 输入例子1:
 * 2
 * 3
 * .X.
 * 11
 * ...XX....XX
 * <p>
 * 输出例子1:
 * 1
 * 3
 */
public class 安置路灯 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k = 0; k < n; k++) {
            int length = sc.nextInt();
            String s = sc.next();
            int min = 0;
            for (int i = 0; i < length; ) {
                if (s.charAt(i) == '.') {
                    min++;
                    i += 3;
                } else
                    i++;
            }
            System.out.println(min);
        }
        sc.close();

    }

}
