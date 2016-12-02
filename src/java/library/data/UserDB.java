package library.data;

import java.sql.*;
import java.util.ArrayList;

import library.business.User;

public class UserDB {

    public static int insert(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query
                = "INSERT INTO patron (first_name, last_name, email_address, book_title, due_date, overdue) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmailAddress());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getBookTitle());
            ps.setString(5, user.getDueDate());
            ps.setString(6, user.getOverdue());
            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static int delete(User user) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM patron "
                + "WHERE email_address = ? AND book_title = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, user.getEmailAddress());
            ps.setString(2, user.getBookTitle());

            return ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
            return 0;
        } finally {
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean emailExists(String email, String bookTitle) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT email_address FROM patron "
                + "WHERE email_address = ? AND book_title = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, bookTitle);
            rs = ps.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static User selectUser(String email, String bookTitle) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT concat(first_name, \" \", last_name) AS 'Patron Name', email_address, book_title, due_date AS 'Due Date',\n" +
"    CASE\n" +
"    WHEN DATE(now()) > DATE(due_date)\n" +
"		THEN 'Overdue'\n" +
"	Else overdue\n" +
"    END AS 'Overdue' FROM patron "
                + "WHERE email_address = ? AND book_title = ?";
        try {
            ps = connection.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, bookTitle);
            rs = ps.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setFirstName(rs.getString("Patron Name"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setBookTitle(rs.getString("book_title"));
                user.setDueDate(rs.getString("due_date"));
                user.setOverdue(rs.getString("Overdue"));
                
            }
            return user;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }
    
    public static ArrayList<User> selectUsers() {
       ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT concat(first_name, \" \", last_name) AS 'Patron Name', email_address, book_title, due_date AS 'Due Date',\n" +
"    CASE\n" +
"    WHEN DATE(now()) > DATE(due_date)\n" +
"		THEN 'Overdue'\n" +
"	Else overdue\n" +
"    END AS 'Overdue' FROM Homework4.patron ";
        try {
            ps = connection.prepareStatement(query);
            rs = ps.executeQuery();
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next())
            {
                User user = new User();
                user.setFirstName(rs.getString("Patron Name"));
                user.setEmailAddress(rs.getString("email_address"));
                user.setBookTitle(rs.getString("book_title"));
                user.setDueDate(rs.getString("due_date"));
                user.setOverdue(rs.getString("Overdue"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            System.out.println(e);
            return null;
        } finally {
            DBUtil.closeResultSet(rs);
            DBUtil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
}