package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity {
	
	GamePanel gp;
	KeyHandler keyH;
	public final int screenX;
	public final int screenY;
	int hasKey=0;
	public Player(GamePanel gp,KeyHandler keyH) {
		this.gp=gp;
		this.keyH=keyH;
		screenX=gp.screenWidth/2 -(gp.tileSize/2);
		screenY=gp.screenHeight/2 -(gp.tileSize/2);
		solidArea = new Rectangle();
		solidArea.x=10;
		solidArea.y=16;
		solidAreaDefaultX=solidArea.x;
		solidAreaDefaultY=solidArea.y;
		solidArea.height=20;
		solidArea.width=20;
		setDefaultValues();
		getPlayerImage();
	}
	public void setDefaultValues() {
		worldX=gp.tileSize * 20;
		worldY=gp.tileSize * 61;
		speed=4;
		direction="down";
	}
	public void getPlayerImage() {
		try {
			up1=ImageIO.read(getClass().getResourceAsStream("/player/back-right.png"));
			up2=ImageIO.read(getClass().getResourceAsStream("/player/back-left.png"));
			down1=ImageIO.read(getClass().getResourceAsStream("/player/right.png"));
			down2=ImageIO.read(getClass().getResourceAsStream("/player/left.png"));
			left1=ImageIO.read(getClass().getResourceAsStream("/player/right-side.png"));
			left2=ImageIO.read(getClass().getResourceAsStream("/player/right-side-move.png"));
			right1=ImageIO.read(getClass().getResourceAsStream("/player/left-side.png"));
			right2=ImageIO.read(getClass().getResourceAsStream("/player/left-side-move.png"));
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void update() {
		if(keyH.upPressed==true||keyH.downPressed==true||
				keyH.leftPressed==true||keyH.rightPressed==true) {
		if(keyH.upPressed==true) {
			direction="up";
			
		}else if(keyH.downPressed==true) {
			direction="down";
		}
		else if(keyH.leftPressed==true) {
			direction="left";
		}
		else if(keyH.rightPressed==true) {
			direction="right";
		}
		//Check the collision;
		collisionOn=false;
		gp.oChecker.checkTile(this);
		//check object collision
		int objIndex=gp.oChecker.checkObject(this,true);
		pickUpObject(objIndex);
		
		if(collisionOn==false) {
			switch(direction) {
			case "up":worldY-=speed;
				break;
			case "down":worldY+=speed;
				break;
			case "left":worldX-=speed;
				break;
			case "right":worldX+=speed;
				break;
			}
		}
		
		spriteCounter++;
		if(spriteCounter>11) {
			if(spriteNum==1) {
				spriteNum=2;
			}
			else if(spriteNum==2) {
				spriteNum=1;
			}
			spriteCounter=0;
		}
	  }
	}
	public void pickUpObject(int index) {
		if(index!=999) {
			String objectName=gp.obj[index].name;
			switch(objectName) {
			case "Key":
				hasKey++;
				gp.obj[index]=null;
				System.out.println("Keys left: "+hasKey);
				break;
			case "Door":
				if(hasKey>0) {
					gp.obj[index]=null;
					hasKey--;
				}
				break;
			case "Boots":
				speed+=1;
				gp.obj[index]=null;
			}
			
		}
	}
	public void draw(Graphics2D g2) {
		//g2.setColor(Color.white);
		//g2.fillRect(x, y, gp.tileSize, gp.tileSize);
		BufferedImage image=null;
		switch(direction) {
		case "up":
			if(spriteNum==1) {
				image=up1;
			}
			if(spriteNum==2) {
				image=up2;
			}
			break;
		case "down":
			if(spriteNum==1) {
				image=down1;
			}
			else {
				image=down2;
			}
			break;
		case "left":
			if(spriteNum==1) {
				image=left1;
			}
			else {
				image=left2;
			}
			break;
		case "right":
			if(spriteNum==1) {
				image=right1;
			}
			else {
				image=right2;
			}
			break;
		}
		g2.drawImage(image, screenX, screenY,gp.tileSize,gp.tileSize,null);
		
	}

}
