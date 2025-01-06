package java_application.enum_;

public class Code01_Example {
    public static void main(String[] args) {
        Season season = Season.SPRING;
        Season season2 = Season.SUMMER;
        System.out.println(season);
        System.out.println(season2);
    }
}

enum Season {
    SPRING("春天", "good"), SUMMER("夏天", "炎热");

    private String name;
    private String description;

    private Season(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Season{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}