package 华为研发工程师编程题_3题;

/**
 * Created by 赵 on 2018/5/17
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 明明想在学校中请一些同学一起做一项问卷调查，为了实验的客观性，他先用计算机生成了N个1到1000之间的随机整数（N≤1000），对于其中重复的数字，只保留一个，把其余相同的数去掉，不同的数对应着不同的学生的学号。然后再把这些数从小到大排序，按照排好的顺序去找同学做调查。请你协助明明完成“去重”与“排序”的工作。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * Input Param
 * <p>
 * n               输入随机数的个数
 * <p>
 * inputArray      n个随机整数组成的数组
 * <p>
 * <p>
 * <p>
 * Return Value
 * <p>
 * OutputArray    输出处理后的随机整数
 * <p>
 * <p>
 * <p>
 * <p>
 * 注：测试用例保证输入参数的正确性，答题者无需验证。测试用例不止一组。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 输入描述:
 * 输入多行，先输入随机整数的个数，再输入相应个数的整数
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 返回多行，处理后的结果
 * <p>
 * <p>
 * 输入例子1:
 * 11
 * 10
 * 20
 * 40
 * 32
 * 67
 * 40
 * 20
 * 89
 * 300
 * 400
 * 15
 * <p>
 * 输出例子1:
 * 10
 * 15
 * 20
 * 32
 * 40
 * 67
 * 89
 * 300
 * 400
 */

import java.util.*;

/**
 * 也可以用计数排序的思想，复杂度为O(输入数的最大值)，即声明一个数组，用下标和值表达该数是否出现过。
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            Set<Integer> set = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                set.add(sc.nextInt());
            }

            List<Integer> list = new LinkedList<>(set);
            Collections.sort(list);
            for (int temp : list)
                System.out.println(temp);
        }
        sc.close();
    }
}
