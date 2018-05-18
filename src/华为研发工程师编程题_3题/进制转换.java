package 华为研发工程师编程题_3题;

/**
 * Created by 赵 on 2018/5/17
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 写出一个程序，接受一个十六进制的数值字符串，输出该数值的十进制字符串。（多组同时输入 ）
 * <p>
 * <p>
 * 输入描述:
 * 输入一个十六进制的数值字符串。
 * <p>
 * <p>
 * <p>
 * 输出描述:
 * 输出该数值的十进制字符串。
 * <p>
 * <p>
 * 输入例子1:
 * 0xA
 * <p>
 * 输出例子1:
 * 10
 */

import java.util.*;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String x = sc.next().substring(2);
            //用java自带函数也可以
            //System.out.println(Integer.parseInt(x,16));
            long n = 0;
            for (int i = 0; i < x.length(); i++) {
                char temp = x.charAt(x.length() - i - 1);
                switch (temp) {
                    case 'A':
                        n += 10 * Math.pow(16, i);
                        break;
                    case 'B':
                        n += 11 * Math.pow(16, i);
                        break;
                    case 'C':
                        n += 12 * Math.pow(16, i);
                        break;
                    case 'D':
                        n += 13 * Math.pow(16, i);
                        break;
                    case 'E':
                        n += 14 * Math.pow(16, i);
                        break;
                    case 'F':
                        n += 15 * Math.pow(16, i);
                        break;
                    default:
                        n += Integer.parseInt("" + temp) * Math.pow(16, i);
                }
            }
            System.out.println(n);
        }
        sc.close();

    }
}
