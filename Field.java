import java.awt.*;
import java.awt.event.*;

public class Field extends Frame implements Runnable,KeyListener
{
	Panel pan;
	Label ts;
	public static int x,y;
	Color cr;
	int dx,dy;
	public static int xSize=10,ySize=75;

	Field(String s)
	{
		super(s);
		pan=new Panel();
		ts=new Label("Press the LEFT arrow key to start the Game..!!");
		ts.setForeground(Color.WHITE);
		//ts.setHorizontalAlignment("Center");
		add(pan,"Center");
		Panel p=new Panel();
		p.add(ts);
		p.setBackground(Color.BLACK);
		pan.setBackground(Color.BLACK);
		add(p,"North");
		setSize(700,400);
		setVisible(true);

    	addKeyListener(this);
    	setFocusable(true);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				System.exit(0);
			}
		});

		//Racket
		dx=dy=1;
		Dimension d=pan.getSize();
		x=d.width-5-xSize;
		y=50;
		cr=new Color(255,255,255);
	}

	public static int getXvar()
	{
		//System.out.println("x :- "+x);
		return x;
	}
	public static int getXsizevar()
	{
		//System.out.println("xSize :- "+xSize);
		return xSize;
	}

    public void keyTyped(KeyEvent e) 
    {

    }

    public void keyPressed(KeyEvent e) 
    {
        if (e.getKeyCode() == KeyEvent.VK_UP) 
        {
        	y-=13;
        	//ySize-=5;
        	//xSize+=5;
            //System.out.println("UP key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) 
        {
        	y+=13;
        	//ySize+=5;
        	//xSize-=5;
            //System.out.println("DOWN key pressed");
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) 
        {
			Ball b=new Ball(pan);
        }
    }

    public void keyReleased(KeyEvent e) 
    {
       
    }

	public void run()
	{
		while(true)
		{
			move();
			//moveBall();
			try
			{
				Thread.sleep(5);
			}
			catch(Exception e1){}
		}
	}
/*
	public void actionPerformed(ActionEvent e)
	{
		Button bp=(Button)e.getSource();
		if(bp==be)
			System.exit(0);
		else
		{
			Ball b=new Ball(pan);
		}

    	//setFocusable(true);
	}
*/
	void move()
	{
		Dimension d=pan.getSize();
		Graphics g=pan.getGraphics();
		g.setColor(Color.BLACK);
		g.fillRect(d.width-15,0,d.width,d.height);
		
		//x+=dx;
		//y+=dy;
		/*g.setColor(cr);
		g.fillOval(x,y,xSize,ySize);*/
		if(x<0)
		{
			x=d.width+xSize;
		}
		if(x+xSize>=d.width)
		{
			x=d.width+xSize;
		}
		if(y<0)
		{
			y=0;
			//dy=-dy;
		}
		if(y+ySize>=d.height)
		{
			y=d.height-ySize;
			//dy=-dy;
		}

		g.setColor(cr);
		g.fillRect(x,y,xSize,ySize);
	}
	public static void main(String[] args) 
	{
		Field a=new Field("Ping Pong");	
		Thread t=new Thread(a);
		t.start();
	}
}