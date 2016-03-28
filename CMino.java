import java.awt.Color;
import java.awt.Graphics;

public class CMino {
	public CMino(int x, int y, int d, Color c){
		X=x;
		Y=y;
		Width=d;
		Height=d;
		FillColor=c;
	}
	public CMino(CMino src){
		X=src.X;
		Y=src.Y;
		Width=src.Width;
		Height=src.Height;
		FillColor=src.FillColor;
		
	}
	public int getX(){return X;}
	public void setX(int x){
		System.out.println(X);
		System.out.println();
		X=x;
	System.out.println(X);}
	public int getY(){return Y;}
	public void setY(int y){
		System.out.println(Y);
		Y=y;
		System.out.println();
		System.out.println(Y);}
	public void draw(Graphics g){
		g.setColor(FillColor);
		g.fillOval(X, Y, Width, Height);
	}
	public boolean containsPoint(int x, int y){
		double a=Width/2.0;
		double b=Height/2.0;
		double xc=X+a;
		double yc=Y+b;
		return((x-xc)*(x-xc)/(a*a)+(y-yc)*(y-yc)/(b*b)<=1.0);
	}
	
	private int X;
	private int Y;
	private int Width;
	private int Height;
	private Color FillColor;
	
}
