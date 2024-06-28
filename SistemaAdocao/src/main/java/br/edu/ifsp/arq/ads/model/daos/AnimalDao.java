package br.edu.ifsp.arq.ads.model.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import br.edu.ifsp.arq.ads.model.daos.filters.AnimalFilter;
import br.edu.ifsp.arq.ads.model.entities.Animal;
import br.edu.ifsp.arq.ads.model.entities.Especie;
import br.edu.ifsp.arq.ads.model.entities.Sexo;
import br.edu.ifsp.arq.ads.model.entities.User;

public class AnimalDao {

	private DataSource dataSource;

	public AnimalDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	
	public Boolean save(Animal animal) {
		String sql = "insert into animal (nome, especie, idade, sexo, raca, pelagem, problemas_saude) values(?,?,?,?,?,?,?)";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, animal.getNome());
			ps.setString(2, animal.getEspecie().toString());
			ps.setInt(3, animal.getIdade());
			ps.setString(4, animal.getSexo().toString());
			ps.setString(5, animal.getRaca());
			ps.setString(6, animal.getPelagem());
			ps.setString(7, animal.getProblemas_saude());
			ps.executeUpdate();
			return true;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro ao inserir dados", sqlException);
		}
	}
	
	public List<Animal> getAnimal() {
		String sql = "select * from animal";
		List<Animal> animals = new ArrayList();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Animal animal = new Animal();
					animal.setId(rs.getLong(1));
					animal.setNome(rs.getString(2));
					animal.setEspecie(Especie.valueOf(rs.getString(3)));
					animal.setIdade(rs.getInt(4));
					animal.setSexo(Sexo.valueOf(rs.getString(5)));
					animal.setRaca(rs.getString(6));
					animal.setPelagem(rs.getNString(7));
					animal.setProblemas_saude(rs.getString(8));
					animals.add(animal);
				}
			}
			return animals;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}
	
	public Animal getAnimalsById(Long id) {
		String sql = "select * from animal where id=?";
		Animal animal = null;
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, id);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					animal = new Animal();
					animal.setId(rs.getLong(1));
					animal.setNome(rs.getString(2));
					animal.setEspecie(Especie.valueOf(rs.getString(3)));
					animal.setIdade(rs.getInt(4));
					animal.setSexo(Sexo.valueOf(rs.getString(5)));
					animal.setRaca(rs.getString(6));
					animal.setPelagem(rs.getString(7));
					animal.setProblemas_saude(rs.getString(8));
				}
			}
			return animal;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro durante a consulta", sqlException);
		}
	}
	
	public Boolean update(Animal animal) {
		String sql = "update animal set " +
				"nome=?," +
                "especie=?," +
                "idade=?," +
                "sexo=?," +
                "raca=?," +
                "pelagem=?," +
                "problemas_saude=?" +
                " where id=?";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setString(1, animal.getNome());
			ps.setString(2, animal.getEspecie().toString());
			ps.setInt(3, animal.getIdade());
			ps.setString(4, animal.getSexo().toString());
			ps.setString(5, animal.getRaca());
			ps.setString(6, animal.getPelagem());
			ps.setString(7, animal.getProblemas_saude());
			ps.setLong(8, animal.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro ao atualizar dados", sqlException);
		}
	}
	
	public Boolean delete(Animal activity) {
		String sql = "delete from animal where id=?";
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setLong(1, activity.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException sqlException) {
			throw new RuntimeException("Erro ao remover dados", sqlException);
		}
	}
	
	public List<Animal> getAnimalsByFilter(AnimalFilter filter) throws SQLException {
		StringBuilder sql = new StringBuilder("select * from animal");
		List<Object> params = new ArrayList<>();
		
		if (filter.getEspecie() != null) {
			sql.append(" where especie=?");
			params.add(filter.getEspecie().getType().toString());
		}

		/*if (filter.getSexo() != null) {
			sql.append(" and sexo=?");
			params.add(filter.getSexo().getDesciption().toString());
		}*/
		
		return getAnimalList(sql.toString(), params, filter.getUser());	
	}

	private List<Animal> getAnimalList(String sql, List<Object> params, User user) throws SQLException {
		List<Animal> animals = new ArrayList<>();
		try (Connection con = dataSource.getConnection(); PreparedStatement ps = con.prepareStatement(sql)) {
			for (int i = 0; i < params.size(); i++) {
				ps.setObject(i+1, params.get(i));
			}
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					Animal animal = new Animal();
					animal.setId(rs.getLong(1));
					animal.setNome(rs.getString(2));
					animal.setEspecie(Especie.valueOf(rs.getString(3)));
					animal.setIdade(rs.getInt(4));
					animal.setSexo(Sexo.valueOf(rs.getString(5)));
					animal.setRaca(rs.getString(6));
					animal.setPelagem(rs.getString(7));
					animal.setProblemas_saude(rs.getString(8));
					animals.add(animal);
				}
			}
		}
		return animals;
	}
}