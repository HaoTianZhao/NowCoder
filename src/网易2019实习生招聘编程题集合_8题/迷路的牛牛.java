package 网易2019实习生招聘编程题集合_8题;

import java.util.*;

/**
 * Created by 赵 on 2018/5/14
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
 * 接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
 * <p>
 * <p>
 * 输出描述:
 * 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
 * <p>
 * 输入例子1:
 * 3
 * LRR
 * <p>
 * 输出例子1:
 * E
 */
public class 迷路的牛牛 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String s = sc.next();
        sc.close();

        int direction = 0;
        for (int i = 0; i < N; i++) {
            if (s.charAt(i) == 'L')
                direction -= 1;
            else
                direction += 1;
        }
        direction = (direction % 4 + 4) % 4;
        if(0 == direction)
            System.out.println("N");
        if(1 == direction)
            System.out.println("E");
        if(2 == direction)
            System.out.println("S");
        if(3 == direction)
            System.out.println("W");
    }

}