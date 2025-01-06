package middle_project.horse_renting;

import java.util.Scanner;

public class Memu {

    public void mainMemu() {
        System.out.println("_________________房屋出租系统______________________");
        System.out.println("\t\t\t1 新 增 房 源");
        System.out.println("\t\t\t2 查 找 房 源");
        System.out.println("\t\t\t3 删 除 房 源");
        System.out.println("\t\t\t4 修 改 房 屋 信 息");
        System.out.println("\t\t\t5 房 屋 列 表");
        System.out.println("\t\t\t6 退 出");
        System.out.println("请选择(1~6)");
    }

    void runHouseRenting() {
        int choose;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入系统的最大存储量");
        int nums = scanner.nextInt();
        HouseRenting houseRenting = new HouseRenting(nums);
        System.out.println("系统开始执行～～～");
        while (true) {
            mainMemu();
            choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    houseRenting.addHouse();
                    break;
                case 2:
                    houseRenting.findHouse();
                    break;
                case 3:
                    houseRenting.deleteHouse();
                    break;
                case 4:
                    houseRenting.updateInfo();
                    break;
                case 5:
                    houseRenting.showInfo();
                    break;
                case 6:
                    System.out.println("是否退出(y/n)");
                    String choose1 = scanner.next();
                    while (!choose1.equals("y") && !choose1.equals("n")) {
                        System.out.println("输入有误，请重新输入");
                        choose1 = scanner.next();
                    }
                    if (choose1.equals("y")) {
                        System.out.println("你已退出了系统");
                        return;
                    } else {
                        break;
                    }
                default:
                    break;
            }
        }
    }
}
