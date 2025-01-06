package java_application.exception_;

public class Code04_Practice {
    public static double cal(int n1, int n2) {
        return n1 / n2;
    }

    public static void main(String[] args) {
        // 先验证输入的参数的个数
        try {
            if (args.length != 2) {
                throw new ArrayIndexOutOfBoundsException("参数个数不对");
            }
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);
            double res = cal(n1, n2);
            System.out.println(res);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("参数格式不正确");
        } catch (ArithmeticException e) {
            System.out.println("除0异常");
        }


    }
}

