package pnb.orp.cache;

import java.sql.SQLException;
import java.util.UUID;

import javax.sql.DataSource;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import pnb.orp.characters.Character.CharacterBuilder;

@Singleton
public class CoreCache implements ORPCache {
	
	@Inject
	private CoreCache() {
		
	}
	
	@Override
	public synchronized Character loadCharacter(UUID uuid, String cardName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized Character loadCharacterAndMakeActive(UUID uuid, String cardName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized CharacterBuilder loadCharacterBuilder(UUID uuid, String cardName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public synchronized DataSource getDataSource() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
