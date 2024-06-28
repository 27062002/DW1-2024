package br.edu.ifsp.arq.ads.model.daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import javax.sql.DataSource;

import br.edu.ifsp.arq.ads.model.entities.User;
import br.edu.ifsp.arq.ads.utils.PasswordEncode;

public class UserDao {

	private DataSource dataSource;

	public UserDao(DataSource dataSource) {
		super();
		this.dataSource = dataSource;
	}
	
	public Optional<User> getUserByEmailAndPassword(String email, String password) {
		String passwordEncripted = PasswordEncode.encode(password);

		String sql = "select id,nome,email from user where email=? and password=?";
		
		Optional<User> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			ps.setString(2, passwordEncripted);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getLong(1));
					user.setNome(rs.getString(2));
					user.setEmail(rs.getString(3));
					optional = Optional.of(user);
				}
			} 
			return optional;
		}catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
		
	}	
	
	public Optional<User> getUserByEmail(String email) {
		String sql = "select id,email,nome from user where email=?";
		Optional<User> optional = Optional.empty();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, email);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setId(rs.getLong(1));
					user.setEmail(rs.getString(2));
					user.setNome(rs.getString(3));
					optional = Optional.of(user);
				}
			}
			return optional;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}
	
	public Boolean saveComunUser(User user){
		Optional<User> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		String sql = "insert into user(nome,cpf,rg,telefone,data_de_nascimento,endereco,email,password,tipoUsuario) values (?,?,?,?,?,?,?,?,1)";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getRg());
			ps.setString(4, user.getTelefone());
			ps.setDate(5, Date.valueOf(user.getData_de_nascimento()));
			ps.setString(6, user.getEndereco());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return true;
	}
	
	public Boolean saveEmployeeUser(User user){
		Optional<User> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		String sql = "insert into user(nome,cpf,rg,telefone,data_de_nascimento,endereco,email,password,tipoUsuario) values (?,?,?,?,?,?,?,?,2)";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getRg());
			ps.setString(4, user.getTelefone());
			ps.setDate(5, Date.valueOf(user.getData_de_nascimento()));
			ps.setString(6, user.getEndereco());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return true;
	}
	
	public Boolean saveAdmUser(User user){
		Optional<User> optional = getUserByEmail(user.getEmail());
		if(optional.isPresent()) {
			return false;
		}
		String sql = "insert into user(nome,cpf,rg,telefone,data_de_nascimento,endereco,email,password,tipoUsuario) values (?,?,?,?,?,?,?,?,3)";
		try(Connection conn = dataSource.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql)){
			ps.setString(1, user.getNome());
			ps.setString(2, user.getCpf());
			ps.setString(3, user.getRg());
			ps.setString(4, user.getTelefone());
			ps.setDate(5, Date.valueOf(user.getData_de_nascimento()));
			ps.setString(6, user.getEndereco());
			ps.setString(7, user.getEmail());
			ps.setString(8, user.getPassword());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			throw new RuntimeException("Erro durante a consulta", e);
		}
		return true;
	}
}
