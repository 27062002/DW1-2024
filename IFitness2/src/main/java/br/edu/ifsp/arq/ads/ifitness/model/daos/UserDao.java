package br.edu.ifsp.arq.ads.ifitness.model.daos;
//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

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import br.edu.ifsp.arq.ads.ifitness.model.entities.Activity;
import br.edu.ifsp.arq.ads.ifitness.model.entities.ActivityType;
import br.edu.ifsp.arq.ads.ifitness.model.entities.User;
import br.edu.ifsp.arq.ads.ifitness.utils.PasswordEncode;

public class UserDao {

	private DataSource dataSource;

	public UserDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Optional<User> getUserByEmailAndPassword(String email, String password) {
		String passwordEncripted = PasswordEncode.encode(password);

		String sql = "select id,name,email from user where email=? and password=?";
		
		Optional<User> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, passwordEncripted);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getLong(1));
					user.setName(rs.getString(2));
					user.setEmail(rs.getString(3));
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}	
	
	public Optional<User> getUserByEmail(String email) {
		String sql = "select id,email,name from user where email=?";
		Optional<User> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getLong(1));
					user.setEmail(rs.getString(2));
					user.setName(rs.getString(3));
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}
	
	/*public Optional<User> getUserById(String email) {
		String sql = "select * from user where user_id=?";
		List<Activity> activities = new ArrayList<>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, user.getId());
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Activity activity = new Activity();
					activity.setId(rs.getLong(1));
					activity.setType(ActivityType.valueOf(rs.getString(2)));
					activity.setDate(LocalDate.parse(rs.getDate(3).toString()));
					activity.setDistance(rs.getDouble(4));
					activity.setDuration(rs.getInt(5));
					activity.setUser(user);
					activities.add(activity);
				}
			}
			return activities;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}*/
	
	public Boolean save(User user){
		Optional<User> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		String sql = "insert into user(name, email, password, date_of_birth, gender, active) values (?,?,?,?,?,?)";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setDate(4, Date.valueOf(user.getDateOfBirth()));
			ps.setString(5, user.getGender().toString());
			ps.setBoolean(6, true);
			ps.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return true;
	}
}
