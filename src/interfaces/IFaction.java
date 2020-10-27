package interfaces;

import java.util.List;

public interface IFaction {
	public void LogIn(String db_name,String url,String db_pass);
	public int getFaction_id(String faction_name);
	public void logOut();
}
