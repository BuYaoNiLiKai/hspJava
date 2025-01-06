package middle_project.smallchange;

import java.util.Scanner;

public class Memu {
    public void showSubMenu() {
        System.out.println("_________________零钱通账单_________________");
        System.out.println("\t\t\t\t1" + "零钱通明细" + "\t\t\t\t");
        System.out.println("\t\t\t\t2" + "收益入账" + "\t\t\t\t");
        System.out.println("\t\t\t\t3" + "消费" + "\t\t\t\t");
        System.out.println("\t\t\t\t4" + "退出" + "\t\t\t\t");
    }

    public void RunSmallChange(int maxNums) {
        int choose;
        double account;
        String name;
        Scanner sc = new Scanner(System.in);
        SmallChange smallChange = new SmallChange();
        do {
            showSubMenu();
            System.out.println("请选择(1~4)");
            choose = sc.nextInt();
            if (choose == 1) {
                smallChange.showDetail();
            }
            if (choose == 2) {
                System.out.println("请依次输入账的金额");
                System.out.print("金额：");
                account = sc.nextDouble();
                smallChange.addAccount(account);
            }
            if (choose == 3) {
                System.out.println("请依次输消费的金额、方式");
                System.out.print("金额：");
                account = sc.nextDouble();
                System.out.print("方式：");
                name = sc.next();
                smallChange.subAccount(account, name);
            }
        } while (choose != 4);
    }
}
