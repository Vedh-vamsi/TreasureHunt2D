package main;

import object.OBJ_Box;
import object.OBJ_Key;
import object.OBJ_boots;
import object.OBJ_door;

public class AssetSetter {
	GamePanel gp;
	public AssetSetter(GamePanel gp) {
		this.gp=gp;
	}
   public void setObject() {
	   //key 1
	   gp.obj[0]=new OBJ_Key();
	   gp.obj[0].worldX=20 *gp.tileSize;
	   gp.obj[0].worldY=47 *gp.tileSize;
	   //key 2
	   gp.obj[1]=new OBJ_Key();
	   gp.obj[1].worldX=21 * gp.tileSize;
	   gp.obj[1].worldY=79 * gp.tileSize;
	   //key3
	   gp.obj[2]=new OBJ_Key();
	   gp.obj[2].worldX=9 * gp.tileSize;
	   gp.obj[2].worldY=48 *gp.tileSize;
	   //door
	   gp.obj[3]=new OBJ_door();
	   gp.obj[3].worldX=10 * gp.tileSize;
	   gp.obj[3].worldY=61 * gp.tileSize;
	   //treasure box
	   gp.obj[4]=new OBJ_Box();
	   gp.obj[4].worldX=10* gp.tileSize;
	   gp.obj[4].worldY=48 * gp.tileSize;
	   
	   gp.obj[5]=new OBJ_Box();
	   gp.obj[5].worldX=5 * gp.tileSize;
	   gp.obj[5].worldY=34 *gp.tileSize;
	   
	   
	   gp.obj[6]= new OBJ_door();
	   gp.obj[6].worldX=33 * gp.tileSize;
	   gp.obj[6].worldY=46 *gp.tileSize;
	   
	   gp.obj[7]=new OBJ_door();
	   gp.obj[7].worldX=10 *gp.tileSize;
	   gp.obj[7].worldY= 51 * gp.tileSize;
	   
	   //boots
	   gp.obj[8]=new OBJ_boots();
	   gp.obj[8].worldX=16 * gp.tileSize;
	   gp.obj[8].worldY=81 *gp.tileSize;
	   
	   
	   
   }
}
