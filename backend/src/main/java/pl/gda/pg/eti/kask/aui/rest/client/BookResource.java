package pl.gda.pg.eti.kask.aui.rest.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import pl.gda.pg.eti.kask.aui.rest.entities.Book;

/**
 *
 * @author psysiu
 */
public class BookResource {

    private final WebTarget root;

    public BookResource(String address, String login, String password) {
        Client client = ClientBuilder.newClient();
        HttpAuthenticationFeature feature = HttpAuthenticationFeature.basic(login, password);
        client.register(feature);
        root = client.target(address + "/resources/books");
    }

    public int saveBook(Integer id, String title, String author) {
        Form form = new Form();
        form.param("id", id.toString());
        form.param("title", title);
        form.param("author", author);
        return root.path("save/form").request().post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE)).getStatus();
    }

    public List<Book> listBooks() {
        return root.path("list").request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<List<Book>>() {});
    }

    public int saveBook(Book book) {
        return root.path("save").request().post(Entity.entity(book, MediaType.APPLICATION_JSON_TYPE)).getStatus();
    }

    public Book findBook(Integer bookId) {
        return root.path("find").path(bookId.toString()).request().get(Book.class);
    }


}
