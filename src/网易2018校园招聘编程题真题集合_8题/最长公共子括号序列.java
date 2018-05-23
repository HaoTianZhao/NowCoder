package 网易2018校园招聘编程题真题集合_8题;

/**
 * Created by 赵 on 2018/5/18
 * <p>
 * 时间限制：1秒
 * <p>
 * 空间限制：100768K
 * <p>
 * 一个合法的括号匹配序列被定义为:
 * 1. 空串""是合法的括号序列
 * 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 * 3. 如果"X"是一个合法的序列,那么"(X)"也是一个合法的括号序列
 * 4. 每个合法的括号序列都可以由上面的规则生成
 * 例如"", "()", "()()()", "(()())", "(((()))"都是合法的。
 * 从一个字符串S中移除零个或者多个字符得到的序列称为S的子序列。
 * 例如"abcde"的子序列有"abe","","abcde"等。
 * 定义LCS(S,T)为字符串S和字符串T最长公共子序列的长度,即一个最长的序列W既是S的子序列也是T的子序列的长度。
 * 小易给出一个合法的括号匹配序列s,小易希望你能找出具有以下特征的括号序列t:
 * 1、t跟s不同,但是长度相同
 * 2、t也是一个合法的括号匹配序列
 * 3、LCS(s, t)是满足上述两个条件的t中最大的
 * 因为这样的t可能存在多个,小易需要你计算出满足条件的t有多少个。
 * <p>
 * 如样例所示: s = "(())()",跟字符串s长度相同的合法括号匹配序列有:
 * "()(())", "((()))", "()()()", "(()())",其中LCS( "(())()", "()(())" )为4,其他三个都为5,所以输出3.
 * 输入描述:
 * 输入包括字符串s(4 ≤ |s| ≤ 50,|s|表示字符串长度),保证s是一个合法的括号匹配序列。
 * <p>
 * <p>
 * 输出描述:
 * 输出一个正整数,满足条件的t的个数。
 * <p>
 * 输入例子1:
 * (())()
 * <p>
 * 输出例子1:
 * 3
 */

import java.util.*;

/**
 * 设s.length()为n
 * 移动s的一个字符，可以让新生成的字符串与s的LCS为n-1，是最大值
 * 所以遍历s的所有字符，将该字符插入所有位置，判断是否合法，并加入set去重
 */
public class 最长公共子括号序列 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        scanner.close();

        int n = s.length();
        Set<String> set = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

                StringBuilder builder = new StringBuilder();
                builder.append(s.substring(0,i)).append(s.substring(i+1,s.length()));
                builder.insert(j,s.charAt(i));
                String t = builder.toString();
                if (isLegal(t))
                    set.add(t);
            }
        }

        //去除它自己
        System.out.println(set.size() - 1);
    }

    private static boolean isLegal(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == '(')
                left++;
            else if (--left < 0)
                return false;
        return true;
    }
}
