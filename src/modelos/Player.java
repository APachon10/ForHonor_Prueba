package modelos;

public class Player {
	private int player_id;
	private String player_name;
	private int attack;
	private int defense;
	private int faction_id;
	
	
	public Player() {
		super();
	}
	//Getters
	public int getPlayer_id() {
		return player_id;
	}
	public String getPlayer_name() {
		return player_name;
	}
	public int getAttack() {
		return attack;
	}
	public int getDefense() {
		return defense;
	}
	public int getFaction_id() {
		return faction_id;
	}
	//Setters
	public void setPlayer_id(int player_id) {
		this.player_id = player_id;
	}
	public void setPlayer_name(String player_name) {
		this.player_name = player_name;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	public void setFaction_id(int faction_id) {
		this.faction_id = faction_id;
	}
	//To String
	@Override
	public String toString() {
		return "ID: " + player_id + ", Name: " + player_name + ", Attack: " + attack + ", Defense: "
				+ defense + ", Faction_id: " + faction_id;
	}
	public Player(int player_id, String player_name, int attack, int defense, int faction_id) {
		super();
		this.player_id = player_id;
		this.player_name = player_name;
		this.attack = attack;
		this.defense = defense;
		this.faction_id = faction_id;
	}
	
	
}
