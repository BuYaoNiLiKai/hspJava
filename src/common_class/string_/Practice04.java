package common_class.string_;

public class Practice04 {
    public static void main(String[] args) {

        String price = "56789.88";
        StringBuffer sb = new StringBuffer(price);
        sb.append("hello");
        int index = price.indexOf(".");
        System.out.println(index);
        int insertTime = index / 3;
        System.out.println(insertTime);
        int i = 0;
        int stratIndex = (index) % 3;
        while (i < insertTime) {
            sb.insert(stratIndex + i + 3 * i, ',');
            i++;
        }
        System.out.println(sb);

    }
}
