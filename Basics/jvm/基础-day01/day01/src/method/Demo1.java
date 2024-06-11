package method;

/**
 * 查看字节码指令练习2 ++
 */
public class Demo1 {
    public static void main(String[] args) {
        int i = 0, j = 0, k = 0;
        i++;
        j = j + 1;
        k += 1;

        System.out.println(i + "\t" + j + "\t" + k);
    }
}
