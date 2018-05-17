package 网易2019实习生招聘编程题集合_8题;

/**
 * Created by 赵 on 2018/5/15
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 平面内有n个矩形, 第i个矩形的左下角坐标为(x1[i], y1[i]), 右上角坐标为(x2[i], y2[i])。
 * <p>
 * 如果两个或者多个矩形有公共区域则认为它们是相互重叠的(不考虑边界和角落)。
 * <p>
 * 请你计算出平面内重叠矩形数量最多的地方,有多少个矩形相互重叠。
 * <p>
 * <p>
 * 输入描述:
 * 输入包括五行。
 * 第一行包括一个整数n(2 <= n <= 50), 表示矩形的个数。
 * 第二行包括n个整数x1[i](-10^9 <= x1[i] <= 10^9),表示左下角的横坐标。
 * 第三行包括n个整数y1[i](-10^9 <= y1[i] <= 10^9),表示左下角的纵坐标。
 * 第四行包括n个整数x2[i](-10^9 <= x2[i] <= 10^9),表示右上角的横坐标。
 * 第五行包括n个整数y2[i](-10^9 <= y2[i] <= 10^9),表示右上角的纵坐标。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个正整数, 表示最多的地方有多少个矩形相互重叠,如果矩形都不互相重叠,输出1。
 * <p>
 * 输入例子1:
 * 2
 * 0 90
 * 0 90
 * 100 200
 * 100 200
 * <p>
 * 输出例子1:
 * 2
 */

import java.util.*;

/**
 * 思路：先将每个矩形按左下角的X轴排序，用N²找出在X轴与某矩形相交的矩形。再将这些矩形按Y轴排序，
 * 用N²找出每个矩形在Y轴上与多少个矩形相交，这就是二维的最多矩形重叠数。
 */
public class 矩形重叠 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x1 = new int[n], x2 = new int[n], y1 = new int[n], y2 = new int[n];
        for (int i = 0; i < n; i++)
            x1[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            y1[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            x2[i] = sc.nextInt();
        for (int i = 0; i < n; i++)
            y2[i] = sc.nextInt();
        sc.close();

        List<Rectangle> xList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            xList.add(new Rectangle(x1[i], y1[i], x2[i], y2[i]));
        }
        Collections.sort(xList, (o1, o2) -> Integer.compare(o1.x1, o2.x1));

        int max = 1;
        for (int i = 0; i < n; i++) {
            List<Rectangle> yList = new ArrayList<>();
            yList.add(xList.get(i));
            for (int j = 0; j < i; j++) {
                if (xList.get(j).intersect(xList.get(i)))
                    yList.add(xList.get(j));
            }

            int m = yList.size();
            Collections.sort(yList, (o1, o2) -> Integer.compare(o1.y1, o2.y1));
            for (int j = 0; j < m; j++) {
                int temp = 1;
                for (int k = 0; k < j; k++)
                    if (yList.get(j).intersect(yList.get(k)))
                        temp++;
                max = Math.max(temp, max);
            }

        }

        System.out.println(max);
    }

    private static class Rectangle {
        private int x1, y1, x2, y2;

        private Rectangle(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        //判断是否有相交部分
        private boolean intersect(Rectangle r) {
            return x1 < r.x2 && y1 < r.y2 && x2 > r.x1 && y2 > r.y1;
        }

    }
}
