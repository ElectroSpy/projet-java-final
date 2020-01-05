package blogMain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostImpl implements DAOPost {
	
	public java.sql.Connection connection;
	
	public PostImpl(Connection connection) {
		this.connection = connection;
	}

	
	public Post getPost(int id) {
		
		Post post = new Post();
		try {
			String query = "SELECT * FROM post WHERE id=1;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next() == false) {
				return null;
			} else {
				do {
					post.setId(rs.getInt("id"));
					post.setAuteur(rs.getString("auteur"));
					post.setTitre(rs.getString("titre"));
					post.setDescription(rs.getString("description"));
					post.setTexte(rs.getString("texte"));
					post.setDate(rs.getDate("date"));
				} while (rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return post;
	}

	
	public List<Post> getAllPost() {
		List<Post> allPost = new ArrayList<Post>();
		
		try {
			String query = "SELECT * FROM post";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Post post = new Post();
				
				post.setId(rs.getInt("id"));
				post.setAuteur(rs.getString("auteur"));
				post.setTitre(rs.getString("titre"));
				post.setDescription(rs.getString("description"));
				post.setTexte(rs.getString("texte"));
				post.setDate(rs.getDate("date"));
				
				allPost.add(post);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allPost;
	}

	public void addPost(Post post) {
		try {
			String query = "INSERT INTO post (auteur,titre,description,texte,date) Values (?,?,?,?,?);";
			String generatedColumns[] = { "ID" };
			PreparedStatement ps = connection.prepareStatement(query, generatedColumns);

			ps.setString(1, post.getAuteur());
			ps.setString(2, post.getTitre());
			ps.setString(3, post.getDescription());
			ps.setString(4, post.getTexte());
			ps.setDate(5, post.getDate());
			
			
			ps.executeUpdate();
			
			ResultSet rs = ps.getGeneratedKeys();
			while(rs.next()) {
				post.setId(rs.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void updatePost (Post post) {
		try {
			String query = "Update post Set, auteur-?, titre-?, description-?, texte-?, date-? WITH post id";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setString(1, post.getAuteur());
			ps.setString(2, post.getTitre());
			ps.setString(3, post.getDescription());
			ps.setString(4, post.getTexte());
			ps.setDate(5, post.getDate());
			
			ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	public void deletePost (Post post) {
		try {
			String query = "DELETE FROM post WHERE id-?;";
			
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, post.getId());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	

	
}



