package emergentech.iot.model.dao.impl.mysql;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import emergentech.iot.model.LightBulb;
import emergentech.iot.model.dao.LightBulbDao;

public class LightBulbDaoImpl implements LightBulbDao {
	
	private PreparedStatement pStmt = null;
	private ResultSet rs = null;
	
	private Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = (Connection) DriverManager.getConnection(
													"jdbc:mysql://127.0.0.1:3306/emergentech",
													"root",
													"eNjEEf9a");
			return conn;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public LightBulbDaoImpl() {
	}
	
	public LightBulb createLightBulb(boolean isOn) {
		return null;
	}
	
	public LightBulb readLightBulb(int id) {
		
		LightBulb querriedBulb = null;
		Connection connection = getConnection();
		
		try {
			pStmt = connection.prepareStatement("SELECT * FROM lightbulb WHERE id = ?");
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();
			if(rs.next()) {
				querriedBulb = new LightBulb(
						rs.getInt("id"),
						rs.getBoolean("is_on")
					);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if(connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return querriedBulb;
	}
	
	public LightBulb updateLightBulb(int id, boolean isOn) {
		LightBulb querriedBulb = null;
		
		try {
			Connection connection = getConnection();
			pStmt = connection.prepareStatement("UPDATE lightbulb SET is_on = ? WHERE id = ?");
			pStmt.setBoolean(1, isOn);
			pStmt.setInt(2, id);
			pStmt.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return querriedBulb;
	}
	
	public void deleteLightBulb(int id) {
		try {
			Connection connection = getConnection();
			pStmt = connection.prepareStatement("DELETE FROM lightbulb SET WHERE id = ?");
			pStmt.setInt(1, id);
			rs = pStmt.executeQuery();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
