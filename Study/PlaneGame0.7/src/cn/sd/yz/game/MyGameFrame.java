package cn.sd.yz.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Date;

import javax.sound.midi.SysexMessage;
import javax.swing.JFrame;
import javax.xml.crypto.Data;

/**
 * �ɻ���Ϸ��������
 * @author Yin
 *
 */
public class MyGameFrame extends Frame{
	
	Image huaji = GameUtil.getImage("images/huaji1.jpg");
	Image bg = GameUtil.getImage("images/bg.jpg");
	
	Plane plane = new Plane(huaji,0,0);
	Shell shell = new Shell();
	Shell[]  shells = new Shell[50];
	
	Explode bao;
	Date startTime = new Date();
	Date endTime;
	int period;
	
	@Override
	public void paint(Graphics g) {  //�Զ������á� g�൱��һ֧����
	super.paint(g);
	Color c = g.getColor();
	
	g.drawImage(bg, 0, 0, null);

	plane.drawSelf(g);  //��������
	
	//�������е��ڵ�
	for(int i=0;i<shells.length;i++) {
		shells[i].draw(g);	
		
		//�ɻ����ڵ�����ײ���
		boolean peng = shells[i].getRect().intersects(plane.getRect());
		if(peng) {
			plane.live=false;
			
			if(bao==null) {
				bao = new Explode(plane.x, plane.y);
				
				endTime = new Date();
				period = (int)((endTime.getTime()-startTime.getTime())/1000);
			}
			bao.draw(g);
		}
		
		
		//��ʱ���ܣ�������ʾ
		if(!plane.live) {
			g.setColor(Color.red);
			Font f = new Font("����",Font.BOLD,50);
			g.setFont(f);
			g.drawString("ʱ�䣺"+period+"��", (int)plane.x, (int)plane.y);
		}
	}
	
	 g.setColor(c);
		
	}
	
	class PaintThread extends Thread{
		
		@Override
		public void run() {
			while(true) {
				repaint();   //�ػ�����
			
			try {
				Thread.sleep(40);  //1s=1000ms
			} catch (InterruptedException e) {
				e.printStackTrace();
			}   
				
			}
		}
	}
	
	//������̼������ڲ���
	class KeyMonitor extends KeyAdapter{

		@Override
		public void keyPressed(KeyEvent e) {
			plane.addDirection(e);
		}

		@Override
		public void keyReleased(KeyEvent e) {
			plane.minusDirection(e);
		}
		
		
	}
	
	/**
	 * ��ʼ������
	 */
	public void launchFrame() {
		this.setTitle("С���������Ϸ0.0");
		this.setVisible(true);
		this.setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		this.setLocation(300,300);
		
		this.addWindowListener(new WindowAdapter() {
			
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
		
		new PaintThread().start(); //�����ػ����ڵ��߳�		
		addKeyListener(new KeyMonitor());  //���������Ӽ��̵ļ���
	
		//��ʼ��50���ڵ�
		for(int i=0;i<shells.length;i++) {
			shells[i]=new Shell();
		}
	}
	
	public static void main(String[] args) {
		MyGameFrame f = new MyGameFrame();
		f.launchFrame();
	}
	
	private Image offScreenImage = null;
	 
	public void update(Graphics g) {
	    if(offScreenImage == null)
	        offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//������Ϸ���ڵĿ��Ⱥ͸߶�
	     
	    Graphics gOff = offScreenImage.getGraphics();
	    paint(gOff);
	    g.drawImage(offScreenImage, 0, 0, null);
	}  
	
}