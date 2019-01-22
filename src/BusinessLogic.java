import java.sql.*;
import java.util.ArrayList;

public class BusinessLogic {
	Connection con;
	PreparedStatement ps;

	public BusinessLogic() throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/haridb", "root", "1987");
	}

	public boolean AddBook(Bookk bk) throws SQLException {
		ps = con.prepareStatement("insert into booktable values(?,?,?)");
		ps.setInt(1, bk.getBid());
		ps.setString(2, bk.getBname());
		ps.setInt(3, bk.getBprice());
		int val = ps.executeUpdate();
		return val == 1;
	}

	public boolean UpdateBook(Bookk bk) throws SQLException {
		ps = con.prepareStatement("update booktable set bname=?,bprice=? where bid = ?");
		ps.setInt(3, bk.getBid());
		ps.setString(1, bk.getBname());
		ps.setInt(2, bk.getBprice());
		int val = ps.executeUpdate();
		return val == 1;
	}

	public boolean DeleteBook(Bookk bk) throws SQLException {
		ps = con.prepareStatement("delete from booktable where bid = ? and bname = ?");
		ps.setInt(1, bk.getBid());
		ps.setString(2, bk.getBname());
		int val = ps.executeUpdate();
		return val == 1;
	}

	public ArrayList<Bookk> showBooks() throws SQLException {
		ps = con.prepareStatement("select * from booktable");
		ResultSet rs = ps.executeQuery();
		ArrayList<Bookk> List = new ArrayList<Bookk>();

		while (rs.next()) {
			List.add(new Bookk(rs.getInt(1), rs.getString(2), rs.getInt(3)));
		}
		return List;
	}

}


