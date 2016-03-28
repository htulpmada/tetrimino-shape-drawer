import java.awt.*;
import java.util.ArrayList;
public class CTetriMino{
	public CTetriMino(int x,int y,int d,int type,Color c,int s){
		X=x;
		Y=y;
		spin=s;
		Width=d;
		Height=d;
		FillColor=c;
		Type=type;
		center=0;
		build();}
	public CTetriMino(CTetriMino src){
		X=src.X;
		Y=src.Y;
		spin=src.spin;
		Width=src.Width;
		Height=src.Height;
		FillColor=src.FillColor;
		Type=src.Type;
		Minox = src.Minox;
		Minoy = src.Minoy;
		center=src.center;
		build();}
	public CTetriMino(CTetriMino src,boolean r){
		X=src.X;
		Y=src.Y;
		spin=src.spin+1;
		Width=src.Width;
		Height=src.Height;
		FillColor=src.FillColor;
		Type=src.Type;
		center=src.center;
		Minox = src.Minox;
		Minoy = src.Minoy;
		build();}
	public int getX(){return X;}
	public void setX(int x){X=x;build();}
	public int getY(){return Y;}
	public void setY(int y){Y=y;build();}
	public void setX(int x,boolean r){X=x;build();}
	public void setY(int y,boolean r){Y=y;build();}
	
	public int whichPoint(int x,int y){
		int center=0;
		for(CMino i : original){
			if(i.containsPoint(x, y))
			{
				break;
			}
			else;{center++;}
		}
		System.out.println(center);
		return center;}
	public boolean lowerThird(CTetriMino c){
		if (c.getY()<360){return false;}
		else{return true;}}
	public void build(){
		
		switch(Type){
		case(0)://squareup
			if(spin%4==0){
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==1){//squareleft
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==2){//squaredown
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==3){//squareright
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
		case(1)://lineup
			if(spin%4==0){
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height*2;
				Minoy[3] = Y+Height*3;
				break;}
			else if(spin%4==1){//lineleft
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width*2;
				Minox[3] = X+Width*3;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y;
				Minoy[3] = Y;
				break;}
			else if(spin%4==2){//linedown
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height*2;
				Minoy[3] = Y+Height*3;
				break;}
			else if(spin%4==3){//lineright
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width*2;
				Minox[3] = X+Width*3;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y;
				Minoy[3] = Y;
				break;}
		case(2)://zup
			if(spin%4==0){
				Minox[0] = X;	
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==1){//zleft
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X+Width;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height*2;
				break;}
			else if(spin%4==2){//zdown
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==3){//zright
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X+Width;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height*2;
				break;}
		case(3)://backwards zup
			if(spin%4==0){
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y+Height;
				Minoy[1] = Y+Height;
				Minoy[2] = Y;
				Minoy[3] = Y;
				break;}
			else if(spin%4==1){//backwards zleft
				Minox[0] = X+Width;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X;
				Minoy[0] = Y+Height*2;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y;
				break;}
			else if(spin%4==2){//backwards zdown
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y+Height;
				Minoy[1] = Y+Height;
				Minoy[2] = Y;
				Minoy[3] = Y;
				break;}
			else if(spin%4==3){//backwards zright
				Minox[0] = X+Width;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X;
				Minoy[0] = Y+Height*2;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y;
				break;}
		case(4)://Tup
			if(spin%4==0){
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X+Width;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height*2;
				break;}
			else if(spin%4==1){//Tleft
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y+Height;
				Minoy[1] = Y+Height;
				Minoy[2] = Y;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==2){//Tdown
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X-Width;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height*2;
				break;}
			else if(spin%4==3){//Tright
				Minox[0] = X+Width*2;
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y;
				break;}
		case(5)://backwards Lup
			if(spin%4==0){//backwards Lup
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height*2;
				break;}
			else if(spin%4==1){//backwards Lleft
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
			else if(spin%4==2){//backwards Ldown
				Minox[0] = X+Width;
				Minox[1] = X;
				Minox[2] = X+Width;
				Minox[3] = X+Width;
				Minoy[0] = Y+Height*2;
				Minoy[1] = Y+Height*2;
				Minoy[2] = Y+Height;
				Minoy[3] = Y;
				break;}
			else if(spin%4==3){//backwards Lright
				Minox[0] = X+Width*2;
				Minox[1] = X+Width*2;
				Minox[2] = X+Width;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y;
				Minoy[3] = Y;
				break;}
		case(6)://Lup
			if(spin%4==0){
				Minox[0] = X;
				Minox[1] = X+Width;
				Minox[2] = X+Width;
				Minox[3] = X+Width;
				Minoy[0] = Y;
				Minoy[1] = Y;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height*2;
				break;}
			else if(spin%4==1){//Lleft
				Minox[0] = X;
				Minox[1] = X;
				Minox[2] = X+Width;
				Minox[3] = X+Width*2;
				Minoy[0] = Y+Height;
				Minoy[1] = Y;
				Minoy[2] = Y;
				Minoy[3] = Y;
				break;}
			else if(spin%4==2){//Ldown
				Minox[0] = X+Width;
				Minox[1] = X;
				Minox[2] = X;
				Minox[3] = X;
				Minoy[0] = Y+Height*2;
				Minoy[1] = Y+Height*2;
				Minoy[2] = Y+Height;
				Minoy[3] = Y;
				break;}
			else if(spin%4==3){//Lright
				Minox[0] = X+Width*2;
				Minox[1] = X+Width*2;
				Minox[2] = X+Width;
				Minox[3] = X;
				Minoy[0] = Y;
				Minoy[1] = Y+Height;
				Minoy[2] = Y+Height;
				Minoy[3] = Y+Height;
				break;}
		}
		for (int i=0;i<=Minox.length-1;i++){
	//		System.out.println(Minox[i]);
	//		System.out.println(Minoy[i]);
	//		System.out.println(Width);
	//		System.out.println(FillColor);
			CMino tempMino = new CMino(Minox[i],Minoy[i],Width,FillColor);	
			original[i] = tempMino;
		}	
	}
	public void draw(Graphics g){		
		g.setColor(FillColor);
		for(int i=0;i<=original.length-1;i++){
			original[i].draw(g);
		}
		
	}
	public boolean containsPoint(int x,int y){
		int truth=0;
		for(CMino i : original){
			if(i.containsPoint(x, y)){
				truth++;
			}
		}
		if(truth!=0){
			System.out.println("true");
			return true;
		}else{
			System.out.println("false");
			return false;
		}
	}
	boolean rotate;
	int X;
	int Y;
	int d;
	int Width;
	int Height;
	Color FillColor;
	int Minox [] ={0,0,0,0};
	int Minoy [] ={0,0,0,0};
	int Type;
	private CMino[] original = new CMino [4];
	int temptype;
	int spin;
	int center;
}
