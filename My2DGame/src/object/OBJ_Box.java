package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class OBJ_Box extends SuperObject{
	
	public OBJ_Box() {
		name="Treasure Box";
		try {
			image=ImageIO.read(getClass().getResourceAsStream("/object/box.png"));
		}catch(IOException e) {
			e.getStackTrace();
		}
	}

}
