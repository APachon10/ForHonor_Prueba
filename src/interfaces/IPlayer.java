package interfaces;

import modelos.Player;

public interface IPlayer {
	public void LogIn(String db_name,String url,String db_pass);
	public void getAllknights(String query);
	public Player getSamuraiWithMoreAttack(String query,int faccion_id);
	public void logOut();
}
