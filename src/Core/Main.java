package Core;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Game window = new Game();
		
		window.setSize(850, 850);
	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    window.setVisible(true);
		
//		JFrame window = new JFrame();
//		
//		window.setSize(850, 850);
//	    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////	    window.setExtendedState(JFrame.MAXIMIZED_BOTH); 
//	    
//	    Game game = new Game();
//	    
//	    window.addMouseListener(game);
//	    window.addMouseMotionListener(game);
//	    window.add(game);
//	    window.setVisible(true);
//	    
//	    game.run();
	}
	
	
	
}
