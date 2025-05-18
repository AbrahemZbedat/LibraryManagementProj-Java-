import java.io.IOException;

public interface BookContract {

    public int searchByTitle(String b);
    public int searchByBookCode(int b);
    public boolean removeByCode(int bookCode) throws IOException;
    public void addBook(Books b);
    public void removeByIndx(int index);

}
