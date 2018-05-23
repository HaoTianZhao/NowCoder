package 网易2018校园招聘编程题真题集合_8题;

/**
 * Created by 赵 on 2018/5/18
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 小易正在玩一款新出的射击游戏,这个射击游戏在一个二维平面进行,小易在坐标原点(0,0),平面上有n只怪物,每个怪物有所在的坐标(x[i], y[i])。小易进行一次射击会把x轴和y轴上(包含坐标原点)的怪物一次性消灭。
 * 小易是这个游戏的VIP玩家,他拥有两项特权操作:
 * 1、让平面内的所有怪物同时向任意同一方向移动任意同一距离
 * 2、让平面内的所有怪物同时对于小易(0,0)旋转任意同一角度
 * 小易要进行一次射击。小易在进行射击前,可以使用这两项特权操作任意次。
 * 小易想知道在他射击的时候最多可以同时消灭多少只怪物,请你帮帮小易。
 * <p>
 * 所有点对于坐标原点(0,0)顺时针或者逆时针旋转45°,可以让所有点都在坐标轴上,所以5个怪物都可以消灭。
 * <p>
 * 输入描述:
 * 输入包括三行。
 * 第一行中有一个正整数n(1 ≤ n ≤ 50),表示平面内的怪物数量。
 * 第二行包括n个整数x[i](-1,000,000 ≤ x[i] ≤ 1,000,000),表示每只怪物所在坐标的横坐标,以空格分割。
 * 第二行包括n个整数y[i](-1,000,000 ≤ y[i] ≤ 1,000,000),表示每只怪物所在坐标的纵坐标,以空格分割。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数表示小易最多能消灭多少只怪物。
 * <p>
 * 输入例子1:
 * 5
 * 0 -1 1 1 -1
 * 0 -1 -1 1 1
 * <p>
 * 输出例子1:
 * 5
 */

import java.util.*;

/**
 * 任意两个斜率相乘为-1的线上，这两条线上的怪物就是一次可以消灭的怪物
 *
 * 本解法复杂度最差为O(n*n*n)。
 *
 * 也可以暴力求解，复杂度为O(n*n*n*n)。即对每两个点组成线(n*n)，对每个线与每个点组成坐标轴(n*n*n)，
 * 对每个坐标轴判断每个点(n*n*n*n)是否在其上。
 */
public class 射击游戏 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            y[i] = sc.nextInt();
        }
        sc.close();

        //小于两个点时一定能一次消灭
        if (n <= 2) {
            System.out.println(n);
            return;
        }

        //maps[i]为所有经过点x[i],y[i]且斜率相同的点集。
        Map[] maps = new Map[n];
        double[][] k = new double[n][n];
        for (int i = 0; i < n; i++) {
            Map<Slope, Set<Point>> slopeMap = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                Slope slope = new Slope(x[i], y[i], x[j], y[j]);

                if (slopeMap.containsKey(slope)) {
                    slopeMap.get(slope).add(new Point(x[i], y[i]));
                    slopeMap.get(slope).add(new Point(x[j], y[j]));
                } else {
                    Set<Point> set = new HashSet<>();
                    set.add(new Point(x[i], y[i]));
                    set.add(new Point(x[j], y[j]));
                    slopeMap.put(slope, set);
                }

            }
            maps[i] = slopeMap;
        }

        //求每个斜率，经过的点的数量的最大值
        Map<Slope, Integer> maxPointSlope = new HashMap<>();
        for (int i = 0; i < n; i++) {
            Map<Slope, Set<Point>> map = (Map<Slope, Set<Point>>) maps[i];
            for (Map.Entry<Slope, Set<Point>> entry : map.entrySet()) {
                Slope slope = entry.getKey();
                int points = entry.getValue().size();
                if (maxPointSlope.containsKey(slope))
                    maxPointSlope.put(slope, Math.max(maxPointSlope.get(slope), points));
                else
                    maxPointSlope.put(slope, points);
            }
        }

        //去除经过点的数量小于最大值的线
        for (int i = 0; i < n; i++) {
            Map<Slope, Set<Point>> map = (Map<Slope, Set<Point>>) maps[i];
            Iterator<Map.Entry<Slope, Set<Point>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Slope, Set<Point>> entry = iterator.next();
                Slope slope = entry.getKey();
                int points = entry.getValue().size();
                int maxPoints = maxPointSlope.get(slope);
                if (points < maxPoints)
                    iterator.remove();
            }
        }

        for (int i = 0; i < n; i++) {
            Map<Slope, Set<Point>> mapA = (Map<Slope, Set<Point>>) maps[i];
            for (Slope s : mapA.keySet())
                System.out.println(s.numerator + " / " + s.denominator);
        }


        //任意组合两条斜率相乘为-1的线，求它们经过的点的数量的最大值，注意去除重复点(线的交点)
        //如果没有垂直的线，则取经过点最多的线，再加任意一个未经过的点
        int max = 0;
        for (int i = 0; i < n; i++) {
            Map<Slope, Set<Point>> mapA = (Map<Slope, Set<Point>>) maps[i];
            for (Map.Entry<Slope, Set<Point>> entry : mapA.entrySet()) {

                Slope slope = entry.getKey();
                Slope zero = new Slope(0, 1);
                Slope infinity = new Slope(1, 0);
                Slope verticalSlope = new Slope(-slope.denominator, slope.numerator);
                for (int j = 0; j < n; j++) {
                    Set<Point> set = new HashSet<>();
                    set.addAll(entry.getValue());
                    Map<Slope, Set<Point>> mapB = (Map<Slope, Set<Point>>) maps[j];
                    if (0 == slope.numerator && mapB.get(infinity) != null)
                        set.addAll(mapB.get(infinity));
                    else if (0 == slope.denominator && mapB.get(zero) != null)
                        set.addAll(mapB.get(zero));
                    else if (mapB.get(verticalSlope) != null)
                        set.addAll(mapB.get(verticalSlope));
                    else if (50 > set.size())
                        max = Math.max(set.size() + 1, max);
                    max = Math.max(set.size(), max);
                }
            }
        }
        System.out.println(max);
    }

    private static class Slope {
        int numerator, denominator;

        Slope(int x1, int y1, int x2, int y2) {
            this(y2 - y1, x2 - x1);
        }

        Slope(int numerator, int denominator) {
            this.numerator = numerator;
            this.denominator = denominator;
            int max = gcd(numerator, denominator);
            if (0 == numerator)
                this.denominator = 1;
            else if (0 == denominator)
                this.numerator = 1;
            else {
                this.numerator /= max;
                this.denominator /= max;
                if (this.denominator < 0) {
                    this.numerator = -this.numerator;
                    this.denominator = -this.denominator;
                }
            }
        }

        //最大公约数
        private int gcd(int a, int b) {
            if (0 == a || 0 == b)
                return 1;

            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            int remainder = a % b;
            while (remainder != 0) {
                a = b;
                b = remainder;
                remainder = a % b;
            }

            return b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Slope))
                return false;

            Slope slope = (Slope) o;

            if (0 == numerator && 0 == slope.numerator)
                return true;
            if (0 == denominator && 0 == slope.numerator)
                return true;
            if (numerator != slope.numerator)
                return false;
            return denominator == slope.denominator;
        }

        @Override
        public int hashCode() {
            int result = numerator;
            result = 31 * result + denominator;
            return result;
        }
    }

    private static class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Point))
                return false;

            Point point = (Point) o;

            if (x != point.x)
                return false;
            return y == point.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
