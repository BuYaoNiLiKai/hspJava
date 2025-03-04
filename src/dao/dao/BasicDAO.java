package dao.dao;

import dao.utils.JDBCUtilsByDruid;
import mysql_.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class BasicDAO<T> {
    private QueryRunner queryRunner = new QueryRunner();

    // 开发通用dml方法，针对任意的表
    public int update(String sql, Object... params) {
        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.update(conn, sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, null, null);
        }

    }

    // 返回多行多列 多个对象
    public List<T> queryMulti(String sql, Class<T> claszz, Object... params) {
        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(conn, sql, new BeanListHandler<T>(claszz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, null, null);
        }
    }

    // 查询单行结果的通用方法
    public T querySingle(String sql, Class<T> claszz, Object... params) {
        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(conn, sql, new BeanHandler<>(claszz), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, null, null);
        }
    }

    // 查询单行单列
    public Object queryScalar(String sql, Object... params) {
        Connection conn = null;
        try {
            conn = JDBCUtilsByDruid.getConnection();
            return queryRunner.query(conn, sql, new ScalarHandler<>(), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtils.close(conn, null, null);
        }
    }
}
