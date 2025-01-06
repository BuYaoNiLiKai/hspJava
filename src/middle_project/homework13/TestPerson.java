package middle_project.homework13;

public class TestPerson {
    public static void main(String[] args) {


        Person[] persons = new Person[4];
        persons[0] = new Student("小明", '男', 15, "00023102");
        persons[1] = new Student("小黑", '女', 14, "00023105");
        persons[2] = new Teacher("张飞", '男', 35, 5);
        persons[3] = new Teacher("关羽", '男', 32, 6);
        Person tmp = null;
        for (int i = 0; i < persons.length - 1; i++) {
            for (int j = 0; j < persons.length - i - 1; j++) {
                if (persons[j].getAge() > persons[j + 1].getAge()) {
                    tmp = persons[j];
                    persons[j] = persons[j + 1];
                    persons[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < persons.length; i++) {
            if (persons[i] instanceof Teacher) {
                System.out.println("老师信息如下");
                System.out.println(persons[i]);
                Teacher t = (Teacher) persons[i];
                t.teach();
                System.out.println(t.play());
            } else {
                System.out.println("学生信息如下");
                System.out.println(persons[i]);
                Student s = (Student) persons[i];
                s.study();
                System.out.println(s.play());
            }
        }
    }


}
