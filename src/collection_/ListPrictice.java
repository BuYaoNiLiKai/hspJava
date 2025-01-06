package collection_;

import java.util.ArrayList;
import java.util.List;

public class ListPrictice {
    @SuppressWarnings({"all"})
    public static void sortBookList(List l) {
        int size = l.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                Book book = (Book) l.get(j);
                Book book1 = (Book) l.get(j + 1);
                if (book.getPrice() > book1.getPrice()) {
                    l.set(j, book1);
                    l.set(j + 1, book);

                }
            }
        }

    }

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Book("红楼梦", "jack", 100));
        list.add(new Book("三国志", "tom", 50));
        list.add(new Book("西游记", "tomasd", 150));
        for (Object b : list) {
            System.out.println(b);
        }
        sortBookList(list);
        for (Object b : list) {
            System.out.println(b);
        }
    }
}

class Book {
    private String name;
    private String author;
    private double price;

    public Book(String name, String author, double price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}