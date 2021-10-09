package automata;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class MainPanel extends JPanel implements ActionListener {
	
	private Image pic;
	private JButton firstBtn;
	private JTextField txtField;
	private JLabel picLabel;
	private Timer timer;
	
    public MainPanel(int xDim, int yDim) {
        super();
        setBackground(Color.LIGHT_GRAY);
		addMouseListener(new MAdapter());
		addMouseMotionListener(new MAdapter());
		setFocusable(true);
		setDoubleBuffered(true);

		pic = new BufferedImage(xDim, yDim, BufferedImage.TYPE_INT_RGB);
		timer = new Timer(1, this);					// initialize the timer
		timer.start();

		addThingsToPanel();
		
    }

    public void addThingsToPanel() {
    	initTxt();
    	add(txtField);
    	initBtns();
    	add(firstBtn);
    	initPic();
		add(picLabel);
    }
    
    public void initTxt() {
    	txtField = new JTextField("yay text", 8);
    	txtField.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			System.out.println(txtField.getText());
    		}
    	});
    }

    public void initBtns() {
		firstBtn = new JButton("Press me!");
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("The button got pressed!");
			}
		});		
    }

    public void initPic() {
    	//the pic variable is defined in the class constructor
		int[][] cells = new int[pic.getWidth(null)][pic.getHeight(null)];				// initialize the cells
		for (int i = 0; i < cells.length; i++) {
			for (int j = 0; j < cells[i].length; j++) {
				//0.5 represents the probability of a cell being filled (=1) without needing an if statement
				cells[i][j] = (int)(Math.random()+0.5);
			}
		}
		Graphics g = pic.getGraphics();
		int size = 1;
    	for (int i = 0; i < cells.length; i++) {
    		for (int j = 0; j < cells[i].length; j++) {
    			if (cells[i][j] == 1) {
    		    	g.setColor(Color.BLACK);
    				g.fillRect(i*size, j*size, size, size);
    			}
    			else {
    				g.setColor(Color.WHITE);
    				g.fillRect(i*size, j*size, size, size);
    			}
    		}
    	}
		picLabel = new JLabel(new ImageIcon(pic));
    }
    
    //you do not need to edit this function
    public void paintComponent(Graphics g)  	                 // draw graphics in the panel
    {
        super.paintComponent(g);                              	 // call superclass to make panel display correctly
    }
        
    
	@Override
	public void actionPerformed(ActionEvent e) {
		//things to change every timer tick
		updateCells();			
        drawCells(pic.getGraphics());
		repaint();
	}
	
	
	//use setColor and fillRect to adjust the corresponding graphics to cells in the pic variable
	private void drawCells(Graphics g) {
		
		
	}

	//say what happens to the cells array
	private void updateCells() {
		
		
	}

	//given a location identified by row and col, returns how many living neighbors
	//are in the 8 cells adjacent to that location (8 to include diagonally adjacent)
	private int countNeighbors(int row, int col) {
		return 0;
	}
	
	//mouse input
	private class MAdapter extends MouseAdapter {
		
		@Override
		public void mousePressed(MouseEvent e) {
			//clicked is not pressed
			System.out.println("Mouse got pressed in the panel at (" + e.getX() + ", " + e.getY() + ")");
			System.out.println("On the screen, it happened at (" + e.getXOnScreen() + ", " + e.getYOnScreen() + ")");
		}
		
//		@Override
//		public void mouseMoved(MouseEvent e) {
//			//things for whenever the mouse moves
//		}
		
//		@Override
//		public void mouseDragged(MouseEvent e) {
//			//things for when the mouse is dragged (pressed and held down while moving)
//		}

//		@Override
//		public void mouseClicked(MouseEvent e) {
//			//a click is a press and then a release
//		}
		
//		@Override
//		public void mouseReleased(MouseEvent e) {
//			//things for when the mouse button is released
//		}
	}
}

