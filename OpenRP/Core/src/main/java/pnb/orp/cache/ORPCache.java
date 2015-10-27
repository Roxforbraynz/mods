package pnb.orp.cache;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import com.google.inject.Singleton;

import pnb.orp.characters.Character.CharacterBuilder;

@Singleton
public interface ORPCache {
	
	//TODO Character creation methods
	
	//Database Cache Methods
	Character loadCharacter(UUID uuid, String cardName);
	Character loadCharacterAndMakeActive(UUID uuid, String cardName);
	CharacterBuilder loadCharacterBuilder(UUID uuid, String cardName);
	DataSource getDataSource() throws SQLException;
}
