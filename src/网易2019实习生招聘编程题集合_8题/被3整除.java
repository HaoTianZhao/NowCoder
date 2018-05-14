package 网易2019实习生招聘编程题集合_8题;

import java.util.*;

/**
 * Created by 赵 on 2018/5/14
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 小Q得到一个神奇的数列: 1, 12, 123,...12345678910,1234567891011...。
 * <p>
 * 并且小Q对于能否被3整除这个性质很感兴趣。
 * <p>
 * 小Q现在希望你能帮他计算一下从数列的第l个到第r个(包含端点)有多少个数可以被3整除。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括两个整数l和r(1 <= l <= r <= 1e9), 表示要求解的区间两端。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数, 表示区间内能被3整除的数字个数。
 * <p>
 * 输入例子1:
 * 2 5
 * <p>
 * 输出例子1:
 * 3
 * <p>
 * 例子说明1:
 * 12, 123, 1234, 12345...
 * 其中12, 123, 12345能被3整除。
 */
public class 被3整除 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lo = sc.nextInt();
        int hi = sc.nextInt();
        int count = 0;
        for (int i = lo; i <= hi; i++)
            if (!(1 == i % 3))
                count++;
        System.out.println(count);

    }

}

