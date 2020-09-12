package springmvc.dao;

import java.util.List;

import springmvc.model.Account;
import springmvc.model.Student;
import springmvc.model.Teacher;

public interface AccountDAO {
	//sign up
	void register(Account account);
	//sign in
	Account validateAcc(Account account);
	//delete
	void delete(String userName);
	//change password or role
	void update(Account account);
	//list of accounts
	List<Account> listAccount();
	List<Teacher> listTeacher();
	List<Student> listStudent();
}
