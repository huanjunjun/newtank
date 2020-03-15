package newtank;

import java.awt.*;
import java.util.*;

class tank {
	int x=0,y=0;
	int speed=5;
    int direction=0;
	int status=0;
	
    public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDirection() {
		return direction;
	}
	public void setDirection(int direction) {
		this.direction = direction;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
    
	tank(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}

class MyTank extends tank
{
    bullet bullet1=null;
	Vector<bullet> bullets=new Vector<bullet>();
	Vector<Image>  images=new Vector<Image>();//Õº∆¨œÚ¡ø
	
	MyTank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	void shoot()
	{
		switch(this.direction)
		{
		  case 0: bullet1=new bullet(x-10,y,0);
		          bullets.add(bullet1);
		           break;
		  case 1: bullet1=new bullet(x,y+10,1);
		          bullets.add(bullet1);
		           break;
		  case 2: bullet1=new bullet(x+10,y,2);
		          bullets.add(bullet1);
		            break;
		  case 3: bullet1=new bullet(x,y-10,3);
		          bullets.add(bullet1);
		            break;
		}
		 Thread t1=new Thread(bullet1);
		 t1.start();
	}
	
	void left()
	{
		x-=speed;
	}
	void right() {
		x+=speed;
	}
	void up() {
		y-=speed;
	}
	void down() {
		y+=speed;
	}
	
}


class enermytank extends tank {

	enermytank(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
	}
	
	void left()
	{
		x-=speed;
	}
	void right() {
		x+=speed;
	}
	void up() {
		y-=speed;
	}
	void down() {
		y+=speed;
	}
}

class bullet implements Runnable
{
	int x=0,y=0;
	int speed=15;
	int direction=0;
	boolean exist=true;
	
	
	bullet(int x,int y,int direction)
	{
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
    public int getDirection() {
		return direction;
	}


	public void setDirection(int direction) {
		this.direction = direction;
	}


	public boolean isExist() {
		return exist;
	}


	public void setExist(boolean exist) {
		this.exist = exist;
	}


	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{ 
			try {
				Thread.sleep(50);
			}catch(Exception e){}
			
			switch(direction)
			{
			case 0 :  x-=speed;
			            break;
			case 1 :  y+=speed;
			              break;
			case 2 :  x+=speed;
			              break;
			case 3 :  y-=speed;
			             break;
			}
			if(x<0||x>870||y<0||y>245)
			{
				this.exist=false;
				break;
			}
			
		
		}
	}

}
