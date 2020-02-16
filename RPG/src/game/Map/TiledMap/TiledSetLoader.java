package game.Map.TiledMap;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public class TiledSetLoader {

	private TiledSetSource tiledsource; 
	
	public TiledSetSource loadTiledMap(String path) {
		path = (System.getProperty("user.dir")+"/resources/rooms/"+path).replace("/", "\\");
		
		Gson gson = new Gson();
		try {tiledsource = gson.fromJson(new FileReader(path), TiledSetSource.class);
 		} catch (JsonSyntaxException | JsonIOException | FileNotFoundException e) {e.printStackTrace();}
		
		return tiledsource;
	}
}
