import java.util.Arrays;

public class STATIC {
    public static void main(String[] args) {
        int z = 1;

        increment(z);
        System.out.println(z);

        int[] arr = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(arr));

        update(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void increment(int x) {
        x += 1;
        System.out.println(x);
    }

    static void update(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] *= 10;
        }
    }
}
