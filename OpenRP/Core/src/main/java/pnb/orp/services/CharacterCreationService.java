package pnb.orp.services;

import java.util.UUID;

import com.google.inject.Inject;
import com.google.inject.Singleton;

import pnb.utils.services.DatabaseService;

@Singleton
public class CharacterCreationService {
	
	private final DatabaseService dbs;
	
	@Inject
	public CharacterCreationService(DatabaseService dbs) {
		this.dbs = dbs;
	}
	
	
	void createCharacter(UUID player, String cardName) {
		
	}
	//How to add items to the character in an extensible way.
	void finishCharacter(UUID player) {
		
	}
	void cancelCharacter(UUID player) {
		
	}
}
