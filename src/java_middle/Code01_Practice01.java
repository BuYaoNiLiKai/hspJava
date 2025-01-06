package java_middle;

public class Code01_Practice01 {
    public static void main(String[] args) {
        System.out.println(Frock.getNextNum());
        System.out.println(Frock.getNextNum());
        Frock fr = new Frock();
        Frock fr2 = new Frock();
        Frock fr3 = new Frock();
        System.out.println(fr.getSeriaNumber());
        System.out.println(fr2.getSeriaNumber());
        System.out.println(fr3.getSeriaNumber());
    }
}

class Frock {
    private static int currentNum = 10000;
    private int seriaNumber;

    public Frock() {
        this.seriaNumber = getNextNum();
    }

    public static int getNextNum() {
        currentNum += 100;
        return currentNum;
    }

    public int getSeriaNumber() {
        return seriaNumber;
    }


}