import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JPanel;
public class TetrisPanel extends JPanel
	implements MouseListener,MouseMotionListener
{
	private ArrayList<CTetriMino> originals;
	private ArrayList<CTetriMino> duplicates;
	private CTetriMino MinoToMove;
	private int m_noffsetX;
	private int m_noffsetY;
	private Image backBuffer;
	private Graphics gBackBuffer;
	boolean isInitialized;
	public TetrisPanel(){
		isInitialized=false;
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}
	void init(){
			duplicates = new ArrayList<CTetriMino>();
			originals = new ArrayList<CTetriMino>();
			Color[] colors ={Color.red, Color.green, Color.blue, Color.magenta, Color.cyan, Color.yellow, Color.orange};
			int count=6;
			int dx=10;
			int dy=10;
			int gap=20;
			int length=(getSize().height-2*dy-(count-1)*gap)/count;
			for (int i=0;i<=count;i++){
				System.out.println((i*4)+1);
				originals.add(new CTetriMino(dx+i*(length+gap),dy,25,i,colors[i],0));
			}
			MinoToMove=null;
			backBuffer=createImage(getSize().width,getSize().height);
			gBackBuffer=backBuffer.getGraphics();
	}
	public void paintComponent(Graphics g){
		if(!isInitialized){
			isInitialized=true;
			init();
		}
		gBackBuffer.setColor(Color.white);
		gBackBuffer.clearRect(0,0,getSize().width,getSize().height);
		gBackBuffer.setColor(Color.black);		
		gBackBuffer.drawLine(0,360,800,360);
		for(int i=0;i<originals.size();i++){
			originals.get(i).draw(gBackBuffer);
		}
		for(int i=0;i<duplicates.size();i++){
			duplicates.get(i).draw(gBackBuffer);
		}	
		g.drawImage(backBuffer, 0, 0,null);
	}
	
	public void mouseClicked(MouseEvent e){
		if(e.isMetaDown()){//right click
			int centerMino=0;
			for (int i=duplicates.size()-1;i>=0;i--){
				if(duplicates.get(i).containsPoint(e.getX(),e.getY())){
					CTetriMino p2=new CTetriMino(duplicates.get(i),true);
					duplicates.remove(i);
					centerMino =p2.whichPoint(e.getX(),e.getY());
					System.out.println(centerMino);
					MinoToMove=p2;
					m_noffsetX=e.getX()-MinoToMove.getX();
					m_noffsetY=e.getY()-MinoToMove.getY();
					centerMino=0;
					duplicates.add(p2);
					if(MinoToMove!=null){
						MinoToMove.setX(e.getX()-m_noffsetX);
						MinoToMove.setY(e.getY()-m_noffsetY);
						repaint();
					}
					break;
				}	
			}
		}
	}
	public void mousePressed(MouseEvent e){
		if(e.isMetaDown()) return;//ignore right click
		for(int i=duplicates.size()-1;i>=0;i--){
			CTetriMino p=duplicates.get(i);
			if (p.containsPoint(e.getX(),e.getY())){
				duplicates.remove(i);
				duplicates.add(p);
				MinoToMove=p;
				m_noffsetX=e.getX()-MinoToMove.getX();
				m_noffsetY=e.getY()-MinoToMove.getY();
				repaint();
				return;
			}
		}
		for(int i=originals.size()-1;i>=0;i--){
			CTetriMino p=originals.get(i);
			if (p.containsPoint(e.getX(),e.getY())){
				CTetriMino p2=new CTetriMino(p);
				duplicates.add(p2);
				MinoToMove=p2;
				m_noffsetX=e.getX()-MinoToMove.getX();
				m_noffsetY=e.getY()-MinoToMove.getY();
				repaint();
				return;
			}
		}
	}
	public void mouseReleased( MouseEvent e ){
		MinoToMove=null;
		for(int i=duplicates.size()-1;i>=0;i--){
			if (duplicates.get(i).lowerThird(duplicates.get(i))==true){
				duplicates.remove(i);}
			repaint();
			}
		}
	public void mouseEntered(MouseEvent e){
	}
	public void mouseExited(MouseEvent e){
	}
	public void mouseMoved(MouseEvent e){	
	}
	public void mouseDragged(MouseEvent e){
		if(e.isMetaDown()) return;
		if(MinoToMove!=null){
			MinoToMove.setX(e.getX()-m_noffsetX);
			MinoToMove.setY(e.getY()-m_noffsetY);
			repaint();
		}
	}
}