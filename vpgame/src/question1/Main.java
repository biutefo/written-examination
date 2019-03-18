package question1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 输入一个数组，返回所有和为0的三元组[a,b,c]
 */
public class Main {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, 0, -5, -8, -3, -4, -1, -7, 1, 2, 2, 4, 5, 6};
        Set<Result> resultSet = getResultSet(arr);
        Iterator<Result> iterator = resultSet.iterator();
        while (iterator.hasNext()) {
            Result next = iterator.next();
            System.out.println("[" + next.a + "," + next.b + "," + next.c + "]");
        }
    }

    public static Set<Result> getResultSet(int[] arr) {
        Set<Result> resultSet = new HashSet<>();
        int length = arr.length;
        for (int i = 0; i < length - 2; i++) {
            for (int j = i + 1; j < length - 1; j++) {
                for (int k = j + 1; k < length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        resultSet.add(new Result(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }
        return resultSet;
    }
}

class Result {
    int a;
    int b;
    int c;

    public Result(int a, int b, int c) {
        int[] arr = {a, b, c};
        Arrays.sort(arr);
        this.a = arr[0];
        this.b = arr[1];
        this.c = arr[2];
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Result)) return false;

        Result result = (Result) o;

        if (a != result.a) return false;
        if (b != result.b) return false;
        return c == result.c;
    }

    @Override
    public int hashCode() {
        int result = a;
        result = 31 * result + b;
        result = 31 * result + c;
        return result;
    }
}
