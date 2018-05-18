package 华为研发工程师编程题_3题;

/**
 * Created by 赵 on 2018/5/17
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 有这样一道智力题：“某商店规定：三个空汽水瓶可以换一瓶汽水。小张手上有十个空汽水瓶，她最多可以换多少瓶汽水喝？”答案是5瓶，方法如下：先用9个空瓶子换3瓶汽水，喝掉3瓶满的，喝完以后4个空瓶子，用3个再换一瓶，喝掉这瓶满的，这时候剩2个空瓶子。然后你让老板先借给你一瓶汽水，喝掉这瓶满的，喝完以后用3个空瓶子换一瓶满的还给老板。如果小张手上有n个空汽水瓶，最多可以换多少瓶汽水喝？
 * <p>
 * 输入描述:
 * 输入文件最多包含10组测试数据，每个数据占一行，仅包含一个正整数n（1<=n<=100），表示小张手上的空汽水瓶数。n=0表示输入结束，你的程序不应当处理这一行。
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 对于每组测试数据，输出一行，表示最多可以喝的汽水瓶数。如果一瓶也喝不到，输出0。
 * <p>
 * <p>
 * 输入例子1:
 * 3
 * 10
 * 81
 * 0
 * <p>
 * 输出例子1:
 * 1
 * 5
 * 40
 */

import java.util.*;

/**
 * 复杂度为O(1)
 * 既然可以借一瓶，就相当于每两瓶可以换一瓶喝，且不剩空瓶，所以除以2即可
 */
public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNext()) {
            int temp = sc.nextInt();
            if (0 == temp)
                break;
            list.add(temp);
        }
        sc.close();

        Integer[] bottles = new Integer[list.size()];
        list.toArray(bottles);
        for (int i = 0; i < bottles.length; i++) {
            int count = 0;
            while (bottles[i] >= 2) {
                bottles[i]++;
                count += bottles[i] / 3;
                bottles[i] = bottles[i] / 3 + bottles[i] % 3 - 1;
            }
            System.out.println(count);
        }
    }
}
