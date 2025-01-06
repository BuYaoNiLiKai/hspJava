package java_base.poly;

public class EmployTest {
    public static void main(String[] args) {
        Employee worker = new Worker("jack", 5000);
        Employee manager = new Manager("milan", 8000, 50000);
        EmployTest employTest = new EmployTest();
        employTest.showEmpAnnual(worker);
        employTest.showEmpAnnual(manager);
        employTest.testWork(worker);
        employTest.testWork(manager);

    }

    public void showEmpAnnual(Employee employee) {

        System.out.println("我的名称" + employee.getName() + "当我的薪水" + employee.getAnnual());
    }

    public void testWork(Employee employee) {
        if (employee instanceof Manager) {
            ((Manager) employee).manage();
        }
        if (employee instanceof Worker) {
            ((Worker) employee).work();
        }
    }
}
