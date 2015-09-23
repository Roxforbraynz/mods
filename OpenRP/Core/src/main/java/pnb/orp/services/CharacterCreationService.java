package pnb.orp.services;

import java.util.UUID;

public interface CharacterCreationService {
	void createCharacter(UUID player, String cardName);
	//How to add items to the character in an extensible way.
	void finishCharacter(UUID player);
	void cancelCharacter(UUID player);
}
