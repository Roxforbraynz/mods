package pnb.orp.characters;

public interface Character {
	
	/**
	 * Checks if this character is active.
	 * @return the active state.
	 */
	boolean isActive();
	
	void printCard(int page);
}
