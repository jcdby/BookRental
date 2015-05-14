package kr.ac.ajou.data;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class JdbcUserRepository implements UserRepository {
	private JdbcOperations jdbc;

	@Autowired
	public JdbcUserRepository(JdbcOperations jdbc) {
		this.jdbc = jdbc;
	}

	private static class UserRowMapper implements RowMapper<User> {
		@Override
		public User mapRow(ResultSet rs, int rowNum) throws SQLException {
			return new User(rs.getString("id"), rs.getString("name"), null);
		}
	}

	@Override
	public User save(User user) {
		jdbc.update(
				"insert into User (id, name, pwd"
						+ " values (?, ?, ?)", user.getId(),
						user.getName(), user.getPwd());
		return user; // TODO: Determine value for id
	}

	@Override
	public User findById(String id) {
		return jdbc
				.queryForObject(
						"select id, name, null from User where id=?",
						new UserRowMapper(), id);
	}

}
