package java_middle.interface_;

interface Bell {
    void ring();
}

class CellPhone {
    public void alarmClock(Bell bell) {
        bell.ring();
    }
}

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CellPhone cellPhone = new CellPhone();
        cellPhone.alarmClock(
                new Bell() {
                    @Override
                    public void ring() {
                        System.out.println("懒猪起床了");
                    }
                }
        );
        cellPhone.alarmClock(
                new Bell() {
                    @Override
                    public void ring() {
                        System.out.println("上课了");
                    }
                }
        );
    }

}
