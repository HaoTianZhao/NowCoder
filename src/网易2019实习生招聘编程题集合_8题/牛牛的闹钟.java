package 网易2019实习生招聘编程题集合_8题;

/**
 * Created by 赵 on 2018/5/17
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：32768K
 * <p>
 * 牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
 * 接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
 * 接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
 * 接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
 * 数据保证至少有一个闹钟可以让牛牛及时到达教室。
 * <p>
 * <p>
 * 输出描述:
 * 输出两个整数表示牛牛最晚起床时间。
 * <p>
 * 输入例子1:
 * 3
 * 5 0
 * 6 0
 * 7 0
 * 59
 * 6 59
 * <p>
 * 输出例子1:
 * 6 0
 */
import java.util.*;

public class 牛牛的闹钟 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] t1 = new int[n];
        for(int i = 0; i < n;i++)
            t1[i] = sc.nextInt() * 60 + sc.nextInt();
        int distanceTime = sc.nextInt();
        int t2 = sc.nextInt() * 60 + sc.nextInt() - distanceTime;
        sc.close();

        int minIndex = 0;
        int minTime = Integer.MAX_VALUE;
        for(int i = 0; i < n;i++){
            int temp = t2 - t1[i];
            if(temp >= 0 && temp < minTime){
                minTime = temp;
                minIndex = i;
            }
        }
        System.out.println(t1[minIndex] / 60 + " " + t1[minIndex] % 60);
    }
}
