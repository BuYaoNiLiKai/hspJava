package middle_project.smallchange;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SmallChange {

    private double balance;
    private String detail;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

    public SmallChange() {
        this.balance = 0;
        this.detail = "";
    }

    public void addAccount(double val) {
        if (val < 0) {
            System.out.println("输入有误");
        } else {
            Date date = new Date();
            this.balance += val;
            this.detail += "\n" + "收益入账\t+" + val + "\t" + sdf.format(date) + "\t余额：" + balance + "\n";
        }
    }

    public void subAccount(double val, String name) {
        if (val < 0) {
            System.out.println("输入有误");

        } else {
            Date date = new Date();
            this.balance -= val;
            this.detail += "\n" + name + "\t-" + val + "\t" + sdf.format(date) + "\t余额：" + balance + "\n";
        }
    }

    public void showDetail() {
        System.out.println(detail);
    }

}
