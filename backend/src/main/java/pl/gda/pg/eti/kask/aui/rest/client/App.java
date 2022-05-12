package pl.gda.pg.eti.kask.aui.rest.client;

import pl.gda.pg.eti.kask.aui.rest.entities.Book;

/**
 *
 * @author psysiu
 */
public class App {

    public static void main(String[] args) {
        BookResource bookResource = new BookResource("http://localhost:8080/Rest-1.0-SNAPSHOT", "psysiu", "psysiu");

        System.out.println(bookResource.saveBook(1, "Gra121232321", "Card"));

        bookResource.listBooks().forEach((book) -> {
            System.out.println(book.getTitle());
        });

        System.out.println(bookResource.saveBook(new Book("Card", "Cień Hegemona")));

        System.out.println(bookResource.findBook(1).getTitle());
    }

}
