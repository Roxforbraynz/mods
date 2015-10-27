package pnb.orp.cache;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import pnb.orp.characters.Character;
import pnb.orp.characters.Character.CharacterBuilder;

@Singleton
public class CoreCache implements ORPCache {
	
	private final DataSource dbDataSource;
	
	@Inject
	private CoreCache() {
		this.dbDataSource = null;
	}
	
	/**
     * Loads a requested character from the database, given the character name and player uuid.
     * @param uuid The player UUID
     * @param name Character's Name (should be card name)
     * @return The character object.
     */
	@Override
	public synchronized Character loadCharacter(UUID uuid, String cardName) {
		return loadCharacterBuilder(uuid, cardName).build();
	}
	
	/**
	 * Loads a character from the database and makes them active.
	 * @param uuid UUID of the player
	 * @param cardName the name of the character card
	 * @return the character card
	 */
	@Override
	public synchronized Character loadCharacterAndMakeActive(UUID uuid, String cardName) {
		Character character = null;
    	try {
			Connection conn = getDataSource().getConnection();
			
			conn.setAutoCommit(true);
			conn.createStatement().executeQuery("UPDATE Characters SET active=false WHERE UUID='" + uuid.toString() + "' AND active=true");
			
			ResultSet result = conn.createStatement().executeQuery("SELECT * FROM Characters WHERE UUID='" + uuid.toString() + "' AND cardName='" + cardName + "'");
			
			result.first();
			
			character = loadCharacterBuilder((UUID)result.getObject("uuid"), result.getString("cardName"))
				.name(result.getString("name"))
				.age(result.getInt("age"))
				.race(result.getString("race"))
				.subrace(result.getString("subrace"))
				.bio(result.getString("bio"))
				.active(true)
				.buildAndUpdate();
			
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return character;
	}
	
	/**
	 * Load a CharacterBuilder for editing purposes.
	 * @param uuid UUID of the player who owns the character
	 * @param The name of the character card being loaded
	 * @return The builder of the character requested.
	 */
	@Override
	public synchronized CharacterBuilder loadCharacterBuilder(UUID uuid, String cardName) {
		CharacterBuilder character = null;
		
		String sql = "";
		
		if (cardName==null)
			sql = "SELECT * FROM Characters WHERE UUID='" + uuid.toString() + "' AND active=true";
		else
			sql = "SELECT * FROM Characters WHERE UUID='" + uuid.toString() + "' AND cardName='" + cardName + "'";
		
    	try {
			Connection conn = getDataSource().getConnection();
			ResultSet result = conn.createStatement().executeQuery(sql);
			
			result.first();
			
			character = Character.builder(this.dbDataSource.getConnection(), (UUID)result.getObject("uuid"), result.getString("cardName"))
				.name(result.getString("name"))
				.age(result.getInt("age"))
				.race(result.getString("race"))
				.subrace(result.getString("subrace"))
				.bio(result.getString("bio"))
				.active(result.getBoolean("active"));

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return character;
	}

	@Override
	public synchronized DataSource getDataSource() throws SQLException {
		return this.dbDataSource;
	}

}
