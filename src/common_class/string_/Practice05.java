package common_class.string_;

public class Practice05 {
    public static void main(String[] args) {
        String s1 = "";
        StringBuffer s2 = new StringBuffer();
        StringBuffer s3 = new StringBuffer();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            s1 = s1 + i;
        }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            s2.append(i);
        }
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);
        startTime = System.currentTimeMillis();
        for (int i = 0; i < 200000; i++) {
            s3.append(i);
        }
        endTime = System.currentTimeMillis();
        totalTime = endTime - startTime;
        System.out.println(totalTime);

    }
}
