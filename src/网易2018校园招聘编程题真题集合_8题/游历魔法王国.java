package 网易2018校园招聘编程题真题集合_8题;

/**
 * Created by 赵 on 2018/5/18
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 魔法王国一共有n个城市,编号为0~n-1号,n个城市之间的道路连接起来恰好构成一棵树。
 * 小易现在在0号城市,每次行动小易会从当前所在的城市走到与其相邻的一个城市,小易最多能行动L次。
 * 如果小易到达过某个城市就视为小易游历过这个城市了,小易现在要制定好的旅游计划使他能游历最多的城市,请你帮他计算一下他最多能游历过多少个城市(注意0号城市已经游历了,游历过的城市不重复计算)。
 * 输入描述:
 * 输入包括两行,第一行包括两个正整数n(2 ≤ n ≤ 50)和L(1 ≤ L ≤ 100),表示城市个数和小易能行动的次数。
 * 第二行包括n-1个整数parent[i](0 ≤ parent[i] ≤ i), 对于每个合法的i(0 ≤ i ≤ n - 2),在(i+1)号城市和parent[i]间有一条道路连接。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示小易最多能游历的城市数量。
 * <p>
 * 输入例子1:
 * 5 2
 * 0 1 2 3
 * <p>
 * 输出例子1:
 * 3
 */

import java.util.*;

/**
 * 只要往回走，必然是一个城市两步的代价，所以要达到最大的城市游历数，则选择最大的不往回走分支，然后加上剩余步数/2即可。
 * 此题现在转变为求树的最长分支
 * 可以由根节点向下求深度，记录走过的节点深度，如此只需O(n)的复杂度，而不是O(nlgn)。不过我数据结构是数组树，就没改
 */
public class 游历魔法王国 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int l = sc.nextInt();
        int[] parent = new int[n];
        parent[0] = 0;
        for (int i = 0; i < n - 1; i++)
            parent[i + 1] = sc.nextInt();
        sc.close();

        //计算所有子结点的深度
        int[] depth = new int[n];
        for (int i = n - 1; i > 0; i--) {
            int index = i;
            while (index != 0) {
                depth[i]++;
                index = parent[index];
            }
        }

        //最深子结点的深度
        int max = 0;
        for (int i = 0; i < n; i++)
            max = Math.max(depth[i], max);

        if (l <= max)
            System.out.println(l + 1);//根节点不用步数，直接加一
        else
            System.out.println(max + 1 + (l - max) / 2);//步数不会大于节点数的两倍，所以不会超

    }

}
