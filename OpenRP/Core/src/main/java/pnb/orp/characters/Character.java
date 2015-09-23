/**
 * Character Cards
 * @author Emily Marriott
 * 
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Project New Beginning
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package pnb.orp.characters;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.UUID;

public final class Character {
	
	private final UUID _uuid;
	private final String _name;
	private final String _cardName;
	private final int _age;
	private final String _race;
	private final String _subrace;
	private final String _bio;
	private final boolean _active;
	
	//Expansion Fields
    
    private Character(CharacterBuilder builder, int save, Connection conn) {
    	
    	//Build the class
    	_uuid = builder._uuid;
    	_name = builder._name;
    	_cardName = builder._cardName;
    	_age = builder._age;
    	_race = builder._race;
    	_subrace = builder._subrace;
    	_bio = builder._bio;
    	_active = (save==1)?true:builder._active;
    	
    	
    	//If told to save, then save the character as a new entry.
    	if (save>0) {
    		//Save new character to DB.
        	try {
    			String sql = (save==1)?"INSERT INTO Characters VALUES ('" + _uuid.toString() + "', '" + _name + 
    					"', '" + _cardName + "', " + _age + ", '" + _race + "', '" + _subrace + "', " +
    					_active + ", '" + _bio + "' )":
    						"UPDATE Characters SET name='" + _name + "', age=" + _age + ", race='" + _race + 
    						"', subrace='" + _subrace + "', bio='" + _bio + "', active=" + _active + 
    						"WHERE uuid='" + _uuid.toString() + "' AMD cardName='" + _cardName + "'";
    			
    			conn.createStatement().execute(sql);
    		} catch (SQLException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    	}
    }
    
    /**
	 * Checks if this character is active.
	 * @return the active state.
	 */
    public boolean isActive() {
    	return _active;
    }

	public void printCard(int page) {
		// TODO Auto-generated method stub
		
	}
    
    public static CharacterBuilder builder(UUID player, String cardName) {
    	return new CharacterBuilder(player, cardName);
    }
    
    public static class CharacterBuilder {
    	private UUID _uuid;
    	private String _name;
    	private String _cardName;
    	private int _age;
    	private String _race;
    	private String _subrace;
    	private String _bio;
    	private boolean _active;
    	
    	public CharacterBuilder(UUID uuid, String cardName) {
    		_uuid = uuid;
    		_cardName = cardName;
    		_name = null;
    		_age = -1;
    		_race = null;
    		_subrace = null;
    		_bio = null;
    		_active = false;
    	}
    	
    	public CharacterBuilder name(String name) {
    		_name = name;
    		return this;
    	}
    	
    	public CharacterBuilder age(int age) {
    		_age = age;
    		return this;
    	}
    	
    	public CharacterBuilder race(String race) {
    		_race = race;
    		return this;
    	}
    	
    	public CharacterBuilder subrace(String subrace) {
    		_subrace = subrace;
    		return this;
    	}
    	
    	public CharacterBuilder bio(String bio) {
    		_bio = bio;
    		return this;
    	}
    	
    	public CharacterBuilder active(boolean active) {
    		_active=active;
    		return this;
    	}
    	
    	public Character buildAndSave(Connection conn) {
    		return new Character(this, 1, conn);
    	}
    	
    	public Character build() {
    		return new Character(this, 0, null);
    	}
    	
    	public Character buildAndUpdate(Connection conn) {
    		return new Character(this, 2, conn);
    	}
    }

}
