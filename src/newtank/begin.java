package newtank;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class begin extends JFrame 
{
    MyPanel mp=null; 
	
	public static void main(String []args)
	{
	            begin t=new begin();	
	}
	
	begin()
	{
		mp=new MyPanel();
     	Thread t2=new Thread(mp);
    	t2.start();
		
		this.add(mp);
		this.addKeyListener(mp);
		
		this.setSize(870,350);
		this.setLocation(270,170);
		 this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
}

class MyPanel extends JPanel  implements KeyListener,Runnable
{
	MyTank mt=null;//my tank
	enermytank et=null;//enermy tank
	int pengstatus=0;//0为普通态，1为攻击态
	
	MyPanel()
	{
		
		mt=new MyTank(120,127);//初始化坦克数据，为画图做准备
		et=new enermytank(680,124);
	
	}
	
	public void paint(Graphics g)
	{
		Image image1=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/zp.png"));
		Image image2=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/zs.png"));
		//两人物的静态形象
		
		
		Image image11=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/zpattack.png"));
		Image image12=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/zpattack1.png"));
		 Image image13=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/attack2.png"));
		//张鹏的攻击形象
		Image background=Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/background.png"));
		//背景图像
		
	//	g.fillRect(0, 0, 720, 600);
		
		g.drawImage(background, 0, 0,870, 245, this);//先画背景
		draw(et.getX(),et.getY(),g,0,image2);//静态张硕
		
		
		switch(this.mt.status)//判断此刻张鹏的形象
		{
		case 0:draw(mt.getX(),mt.getY(),g,0,image1);break;
		case 1:draw(mt.getX(),mt.getY(),g,0,image11);break;
		case 2:draw(mt.getX(),mt.getY(),g,0,image12);break;
		}
		
		for(int i=0;i<mt.bullets.size();i++)
		{
			bullet bu=mt.bullets.get(i);
			if( bu!=null && bu.exist==true  )
			{
//				g.setColor(Color.blue);
//				g.fillRoundRect(bu.x, bu.y, 15, 15,15, 15);
                 				
				g.drawImage(image13, bu.x+40, bu.y-10, 100, 100,this);
				
			}
		}
		
		
		
//		if(mt.bullet1!=null)//判断张鹏是否发射气功
//		{
//			g.setColor(Color.blue);
//			g.fillRoundRect(mt.bullet1.x, mt.bullet1.y, 15, 15,15, 15);
//		}
	    
		
	}

	public void draw (int x,int y,Graphics g,int type,Image image){

		g.drawImage(image, x, y, 70, 80, this);
		
	}
	
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			this.mt.setStatus(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_K)
		{
			this.mt.setStatus(0);
		}
		if(e.getKeyCode()==KeyEvent.VK_U)
		{
			this.mt.setStatus(0);
		}
		repaint();
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_A)
		{
			this.mt.setDirection(0);
			this.mt.left();
		}
		else if(e.getKeyCode()==KeyEvent.VK_S)
		{
			this.mt.setDirection(1);
			this.mt.down();
		}
		else if(e.getKeyCode()==KeyEvent.VK_D)
		{
			this.mt.setDirection(2);
			this.mt.right();
		}
		else if(e.getKeyCode()==KeyEvent.VK_W)
		{
			this.mt.setDirection(3);
			this.mt.up();
		}
		if(e.getKeyCode()==KeyEvent.VK_U)
		{
			this.mt.setStatus(1);
			this.mt.shoot();
		}
		if(e.getKeyCode()==KeyEvent.VK_J)
		{
			this.mt.setStatus(1);
		}
		if(e.getKeyCode()==KeyEvent.VK_K)
		{
			this.mt.setStatus(2);
		}
		
		repaint();   //数据修改后重新作图
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			try {
				Thread.sleep(50);
			}catch(Exception e) {}
			
			this.repaint();
	    }
	}

}