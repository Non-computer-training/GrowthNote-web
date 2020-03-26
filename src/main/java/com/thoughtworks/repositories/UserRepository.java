package com.thoughtworks.repositories;


import com.thoughtworks.entities.User;
import com.thoughtworks.utils.JDBCUtils;

import java.sql.*;


public class UserRepository implements UserRepositoryI {

    public User getUserByNameAndPassword(String userName, String password) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "SELECT * FROM userInfo WHERE userName = ? and password = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, userName);
            stmt.setString(2, password);
            rs = stmt.executeQuery();
            while (rs.next()) {
                user = new User(rs.getInt("id"), rs.getString("userName"), rs.getString("password"));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, stmt, conn);
        }
        return new User();
    }

    public void userRegister(User user) {
        Connection conn = null;
        PreparedStatement pre = null;
        try {
            conn = JDBCUtils.getConnection();
            String sql = "INSERT INTO userInfo(userName, password) VALUES(?, ?)";
            pre = conn.prepareStatement(sql);
            pre.setString(1, user.getUserName());
            pre.setString(2, user.getPassword());
            pre.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(pre, conn);
        }
    }
}
