package springmvc.daoImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import springmvc.dao.AccountDAO;
import springmvc.model.Account;
import springmvc.model.Student;
import springmvc.model.Teacher;

public class AccountDAOImpl implements AccountDAO {

	private JdbcTemplate jdbcTemplate;
	
	public AccountDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void register(Account account) {
		String sql = "insert into Accounts values(?, ?, ?,0)";
		System.out.println(account.toString());
		jdbcTemplate.update(sql, account.getUserName(), account.getPassWord(), account.getUserRole() );
	}

	@Override
	public Account validateAcc(Account account) {
		String sql = "select * from Accounts where User_Name='" + account.getUserName() + "' and Password='"
				+ account.getPassWord() +"'";
		return jdbcTemplate.query(sql, new ResultSetExtractor<Account>() {

			@Override
			public Account extractData(ResultSet rs) throws SQLException, DataAccessException {
				if (rs.next()) {
					return new Account(rs.getString("User_Name"),rs.getString("Password"),rs.getString("User_Role"));
				}
				return null;
			}
		});
	}

	@Override
	public void delete(String userName) {
		String sql = "DELETE FROM Accounts WHERE User_Name=?";
		jdbcTemplate.update(sql, userName);
	}

	@Override
	public void update(Account account) {
			String sql = "UPDATE Accounts SET Password=?, User_Role=? WHERE User_Name=?";
			jdbcTemplate.update(sql, account.getPassWord(), account.getUserRole(), account.getUserName());
	}
	@Override
	public List<Account> listAccount(){
		String sql1 = "SELECT * FROM Accounts WHERE accountStatus=0";
		List<Account> listAdmin = jdbcTemplate.query(sql1, new RowMapper<Account>() {

			@Override
			public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
				Account admin = new Account();

				admin.setUserName(rs.getString("User_Name"));
				admin.setPassWord(rs.getString("Password"));
				admin.setUserRole(rs.getString("User_Role"));
				return admin;
			}
		});
		return listAdmin;
	}

	@Override
	public List<Teacher> listTeacher() {
		String sql1 = "SELECT * FROM Accounts INNER JOIN Teacher ON Accounts.User_Name = Teacher.User_Name where Accounts.User_Role='TEACHER';";
		List<Teacher> listTeacher = jdbcTemplate.query(sql1, new RowMapper<Teacher>() {

			@Override
			public Teacher mapRow(ResultSet rs, int rowNum) throws SQLException {
				Teacher teacher = new Teacher(rs.getInt("teacherID"), rs.getString("teacherName"), rs.getString("User_Name"), rs.getString("gender"));
				return teacher;
			}
		});
		return listTeacher;
	}

	@Override
	public List<Student> listStudent() {
		String sql = "select * from Accounts inner join Student on Accounts.User_Name = Student.User_Name where Accounts.User_Role = 'STUDENT';";
		List<Student> listStudent = jdbcTemplate.query(sql, new RowMapper<Student>(){

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student(rs.getInt("studentID"), rs.getString("firstName"), rs.getString("lastName"), rs.getString("gender"), rs.getString("address"), rs.getString("User_Name"));
				return student;
			}
		});
		return listStudent;
	}
	
}

