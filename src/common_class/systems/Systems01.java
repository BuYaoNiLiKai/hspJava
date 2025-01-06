package common_class.systems;

public class Systems01 {
    public static void main(String[] args) {
        System.out.println("hello1");

        System.out.println("hello2");
        int[] arr = {1, 2, 3, 4, 5};
        int[] arr2 = new int[5];
        System.arraycopy(arr, 0, arr2, 0, arr.length);
        for (int i = 0; i < arr2.length; i++) {
            System.out.println(arr2[i]);
        }
        System.out.println(System.currentTimeMillis());
    }
}
