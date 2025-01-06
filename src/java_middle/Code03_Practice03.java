package java_middle;

public class Code03_Practice03 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.testWork(
                new Caculator() {
                    @Override
                    public int work(int n1, int n2) {
                        return n1 + n2;
                    }
                }, 100, 200
        );
    }
}

interface Caculator {
    public int work(int n1, int n2);
}

class CellPhone {

    public void testWork(Caculator c, int n1, int n2) {
        int res = c.work(n1, n2);
        System.out.println(res);

    }
}