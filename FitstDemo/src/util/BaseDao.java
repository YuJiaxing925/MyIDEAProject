package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class BaseDao {
	public Connection conn = null;
	public PreparedStatement pstate = null;
	public ResultSet rs = null;

	// �ͷ���Դ
	public void closeAll() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstate != null) {
				pstate.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ��ȡ����
	public void getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/pet?characterEncoding=utf-8",
							"root", "123456");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/**
	 * ��ɾ��
	 */
	public int myexecuteUpdate(String sql,Object[] lists){
		int num=0;
		getConn();
		try {
			pstate=conn.prepareStatement(sql);
			if(lists!=null){
				for (int i = 0; i < lists.length; i++) {
					pstate.setObject(i+1, lists[i]);
				}
			}
			num = pstate.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	//��
	public ResultSet myexecuteQuery(String sql,Object[] lists){
		getConn();
		try {
			pstate=conn.prepareStatement(sql);
			if(lists!=null){
				for (int i = 0; i < lists.length; i++) {
					pstate.setObject(i+1, lists[i]);
				}
			}
			rs=pstate.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
}
