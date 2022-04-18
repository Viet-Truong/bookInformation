/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author AD
 */
public class BookService {
    private ManagerBook managerBook;
    public BookService(){
        managerBook = new ManagerBook();
    }
    public List<Book> getAllBooks() throws SQLException{
        return managerBook.getAllBooks();
    }
    public Book checkBook(int id) throws SQLException{
        return managerBook.checkBook(id);
    }
    public void addBook(Book book) throws SQLException{
        managerBook.addBook(book);
    }
    public void deleteBook(int id) throws SQLException{
        managerBook.deleteBook(id);
    }
    public Book getBookById(int id) throws SQLException{
        return managerBook.getBookById(id);
    }
    public void updateBook(Book book) throws SQLException{
        managerBook.updateBook(book);
    }
    public Book findBook(String name) throws SQLException{
        return managerBook.findBook(name);
    }
}
