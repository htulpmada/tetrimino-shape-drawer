import javax.swing.JFrame;
public class TestPanel {
	public static void main( String[] args ){
		JFrame application = new JFrame("NewTetris");
		
		TetrisPanel tetrisPanel = new TetrisPanel();
		application.add(tetrisPanel);
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.setSize(800,540);
		application.setVisible(true);
	}
}