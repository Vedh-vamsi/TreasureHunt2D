package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_boots extends SuperObject {
	
	public OBJ_boots() {
		try {
		name="Boots";
		image=ImageIO.read(getClass().getResourceAsStream("/object/boots.png"));
		}catch(IOException e) {
			e.getStackTrace();
		}
	}

}
