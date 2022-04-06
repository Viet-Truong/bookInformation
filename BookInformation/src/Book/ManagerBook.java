/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Book;

/**
 *
 * @author AD
 */
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author AD
 */
public class ManagerBook {
    public List<Book> getAllBooks() throws SQLException {
        List<Book> books = new ArrayList<Book>();

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from book";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setMoney(rs.getDouble("price"));
                books.add(book);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }
    
    public Book getBookById(int id) throws SQLException {

        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from book where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Book book = new Book();
                book.setId(rs.getInt("id"));
                book.setName(rs.getString("name"));
                book.setMoney(rs.getDouble("price")); 
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Book checkBook(int id) throws SQLException{
        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "select * from book where id = ?";
        Book book = new Book();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                book.setId(rs.getInt("id"));
                return book;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBook(Book book) throws SQLException {
        Connection connection =  ConnectDatabase.getConnectionDatabase();
        String sql = "Insert into book(id, name, price)"
                + "Values(?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, book.getId());
            preparedStatement.setString(2, book.getName());
            preparedStatement.setDouble(3, book.getMoney());
            int rs = preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateBook(Book book) throws SQLException{
        Connection connection = ConnectDatabase.getConnectionDatabase();
        String sql = "Update book set name = ?, price = ? Where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, book.getName());
            preparedStatement.setDouble(2, book.getMoney());
            preparedStatement.setInt(3, book.getId());
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void deleteBook(int id) throws SQLException{
       Connection connection = ConnectDatabase.getConnectionDatabase();
       String sql = "delete from book where id = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Book findBook(Book book) throws SQLException {
        List<Book> listbook = new ArrayList<>();
        listbook = getAllBooks();
        for (Book s : listbook) {
            if (book.getName().equals(s.getName())) {
                return s;
            }
        }
        return null;
    }
}
