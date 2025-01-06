package common_class.arrays;

public class CustomSortPractice {
    public static void customSort(Book[] arr, com c) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (c.compare(arr[j], arr[j + 1]) > 0) {
                    Book temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }


    }

    public static void main(String[] args) {
        Book[] arr = new Book[4];
        arr[0] = new Book("红楼梦aaaa", 100);
        arr[1] = new Book("金瓶梅", 90);
        arr[2] = new Book("青年文摘", 5);
        arr[3] = new Book("java入门", 300);
        customSort(arr, new com<Book>() {
            @Override
            public int compare(Book a, Book b) {
                return a.price - b.price;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        customSort(arr, new com<Book>() {

            @Override
            public int compare(Book a, Book b) {
                return a.name.length() - b.name.length();
            }
        });
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}

interface com<Template> {
    int compare(Template a, Template b);
}

class Book {
    String name;
    int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}