package ch1;

/**
 * 斐波拉契数列 递归  时间复杂度为o(2^n)
 * @anthor wangyul
 * @date 2019/6/24 23:21
 */
public class Demo01 {
    public static void main(String[] args) {
        int a = Demo01.diff(6);
        System.out.println(a);
    }

    public static int diff(int n){
        if (n==0 ||n ==1){
            return n;
        }
        return diff(n-1)+diff(n-2);
    }
}
