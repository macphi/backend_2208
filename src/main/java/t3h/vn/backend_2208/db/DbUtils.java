package t3h.vn.backend_2208.db;

import t3h.vn.backend_2208.dto.Book;

import java.sql.*;

public class DbUtils {
    static String DB_INFO = "jdbc:mysql://localhost:3306/t3h_2208";
    static String USER_NAME = "root";
    static String PASS = "Melodyy123";


    public static void insertBook(Book book) throws SQLException {
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        String insertSql = "INSERT INTO sach (NAME, AUTHOR) VALUES (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(insertSql);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getAuthor());
        preparedStatement.execute();
        conn.close();
    }

   public static Book getAllById(Long id) throws SQLException {
        Book book = null;
        Connection conn = DriverManager.getConnection(DB_INFO, USER_NAME, PASS);
        Statement sqlStatement = conn.createStatement();
        String selectSql = "SELECT * FROM sach where ID = " + id;
        // Buoc 3: Thuc thi cau lenh len Sql server -> ket qua tra ve ResultSet
        ResultSet ketQua = sqlStatement.executeQuery(selectSql);
        // Buoc 4: Xu ly ket qua tra ve ( hien thi len man hinh )
        while (ketQua.next()) {
            Long id_ = ketQua.getLong("ID");
            String monHoc = ketQua.getString("NAME");
            String tacGia = ketQua.getString("AUTHOR");
            book = new Book(id_, monHoc, tacGia);
            System.out.println("ID = " + id_ + ", Mon = " + monHoc + ", Tac gia = " + tacGia);
        }
        sqlStatement.close();
        conn.close();
        return book;
    }
}
