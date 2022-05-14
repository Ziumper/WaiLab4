package pl.gda.pg.eti.kask.aui.rest.servlet;

import pl.gda.pg.eti.kask.aui.rest.entities.Book;
import java.io.Serializable;
import java.util.List;

public interface BooksContext extends Serializable {
    public List<Book> findAllBooks();
    public int saveBook(Book book);
    public Book findBook(Integer bookId);
}
