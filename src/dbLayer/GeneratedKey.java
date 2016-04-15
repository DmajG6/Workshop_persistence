package dbLayer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class GeneratedKey {

	public int getGeneratedKey(Statement insertStatement) {
		int res = -1;
		try (ResultSet rs = insertStatement.getGeneratedKeys()) {
			if (rs.next()) {
				res = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
}