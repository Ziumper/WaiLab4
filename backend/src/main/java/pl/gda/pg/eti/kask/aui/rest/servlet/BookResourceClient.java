package pl.gda.pg.eti.kask.aui.rest.servlet;

import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import pl.gda.pg.eti.kask.aui.rest.entities.Book;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 *
 * @author psysiu
 */
public class BookResourceClient implements BooksContext {

    private final WebTarget root;

    public BookResourceClient(String address) {
        Client client = ClientBuilder.newClient();
        root = client.target(address + "/resources/books");
    }

    public int saveBook(Integer id, String title, String author) {
        Form form = new Form();
        form.param("id", id.toString());
        form.param("title", title);
        form.param("author", author);
        return root.path("save/form").request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE)).getStatus();
    }

    public List<Book> findAllBooks() {
        return root.path("list").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Book>>() {});
    }

    public int saveBook(Book book) {
        return root.path("save").request().post(Entity.entity(book, MediaType.APPLICATION_JSON_TYPE)).getStatus();
    }

    public Book findBook(Integer bookId) {
        return root.path("find").path(bookId.toString()).request().get(Book.class);
    }


}
