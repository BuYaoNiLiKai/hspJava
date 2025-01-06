package middle_project.horse_renting;

import java.util.Scanner;

public class HouseRenting {
    private int maxNums;
    private int[] ids; //id
    private String[] names; //姓名
    private String[] phones; //电话
    private String[] addresses; //地址
    private double[] prices;
    private String[] statuss;
    private int index;//状态

    public HouseRenting(int maxNums) {
        this.maxNums = maxNums;
        ids = new int[maxNums];
        names = new String[maxNums];
        phones = new String[maxNums];
        addresses = new String[maxNums];
        statuss = new String[maxNums];
        prices = new double[maxNums];
        index = 0;
    }

    public void addHouse() {
        System.out.println("_________________添加房源______________________");
        if (index == maxNums) {
            System.out.println("系统已满，无法添加房源");
        } else {
            Scanner scanner = new Scanner(System.in);
            this.ids[index] = index + 1;
            System.out.println("姓名：");
            this.names[index] = scanner.next();
            System.out.println("电话");
            this.phones[index] = scanner.next();
            System.out.println("地址");
            this.addresses[index] = scanner.next();
            System.out.println("月租");
            this.prices[index] = scanner.nextDouble();
            System.out.println("状态(未出租/已出租)");
            this.statuss[index] = scanner.next();
            this.index++;
            System.out.println("添加完成");
        }

    }

    public void deleteHouse() {
        System.out.println("_________________删除房源______________________");
        System.out.println("请选择待删除房屋编号(-1退出)");
        int id;
        Scanner sc = new Scanner(System.in);
        id = sc.nextInt();
        if (id != -1) {
            int i = findId(id);
            if (i == -1) {
                System.out.println("未找到该房屋信息");
            } else {
                System.out.println("确认是否删除(y/n):请小心选择");
                System.out.println("请输入您的选择(y/n)");
                String choose;
                choose = sc.next();
                if (choose.equals("y")) {
                    for (int j = i; j < index - 1; j++) {
                        this.ids[j] = this.ids[j + 1];
                    }
                    System.out.println("_______________删除完成_______________");
                    index--;
                }
            }
        }

    }

    public int findId(int id) {
        for (int i = 0; i < index; i++) {
            if (this.ids[i] == id) {
                return i;
            }
        }
        return -1;
    }

    public void updateInfo() {
        System.out.println("_________________修改信息(保持原来信息请输入回车)______________________");
        System.out.println("请选择要修改的房屋编号");
        int id;
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextInt();
        int i = findId(id);
        if (i == -1) {
            System.out.println("未找到该房屋信息");
        } else {
            String update;
            update = scanner.nextLine();
            System.out.println("姓名(" + names[i] + "):");
            update = scanner.nextLine();
            if (!update.isEmpty()) {
                this.names[i] = update;
            }
            System.out.println("电话(" + phones[i] + "):");
            update = scanner.nextLine();
            if (!update.isEmpty()) {
                this.phones[i] = update;
            }
            System.out.println("地址(" + addresses[i] + "):");
            update = scanner.nextLine();
            if (!update.isEmpty()) {
                this.addresses[i] = update;
            }
            System.out.println("月租(" + prices[i] + "):");
            update = scanner.nextLine();
            if (!update.isEmpty()) {
                this.prices[i] = Double.parseDouble(update);
            }
            System.out.println("状态(" + statuss[i] + "):");
            update = scanner.nextLine();
            if (!update.isEmpty()) {
                this.statuss[i] = update;
            }
            System.out.println("_________________修改完成______________________");
        }
    }

    public void findHouse() {
        System.out.println("_________________查找房源______________________");
        int id;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入你要查找的id");
        id = scanner.nextInt();
        int i = findId(id);
        if (i == -1) {
            System.out.println("未找到该房屋信息");
        } else {
            showIndex(i);
            System.out.println("_________________查找完成______________________");
        }
    }

    public void showIndex(int i) {
        System.out.println(ids[i] + "\t\t" + names[i] + "\t\t" + phones[i] +
                "\t\t" + addresses[i] + "\t\t" + prices[i] + "\t\t" + statuss[i]);
    }

    public void showInfo() {
        System.out.println("_________________房屋列表______________________");
        System.out.println("编号\t\t房主\t\t电话\t\t地址\t\t月租\t\t状态(未出租/已出租)");
        for (int i = 0; i < index; i++) {
            showIndex(i);
        }
    }
}
