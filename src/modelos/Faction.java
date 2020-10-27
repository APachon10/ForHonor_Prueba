package modelos;

import java.io.BufferedReader;
import java.io.Console;
import java.io.InputStreamReader;

public class Faction {
	//Atributos 
	private int faction_id;
	private String faction_name;
	private String lore;
	
	// Getters
	public int getFaction_id() {
		return faction_id;
	}
	public String getFaction_name() {
		return faction_name;
	}
	public String getLore() {
		return lore;
	}
	// Setters 
	public void setFaction_id(int faction_id) {
		this.faction_id = faction_id;
	}
	public void setFaction_name(String faction_name) {
		this.faction_name = faction_name;
	}
	public void setLore(String lore) {
		this.lore = lore;
	}
	// To String 
	@Override
	public String toString() {
		return "ID: " + faction_id + ", name: " + faction_name + ", lore: " + lore;
	}
	public static void main(String[] args) {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		
		System.out.println("Introducir un numero: ");
		String dato;
		
		try {
		
			dato = br.readLine();
			System.out.println("El numero introducido fue: "+dato);
	
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	public Faction(int faction_id, String faction_name, String lore) {
		super();
		this.faction_id = faction_id;
		this.faction_name = faction_name;
		this.lore = lore;
	}
	
}
