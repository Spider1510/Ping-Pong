import java.awt.*;
import java.awt.event.*;

class Ball extends Thread
{
	int xb,yb;
	Color crb;
	int dxb,dyb;
	Panel box;
	int xSizeb=10,ySizeb=10;
	Ball(Panel p)
	{
		super();
		dxb=dyb=2;
		box=p;
		xb=0;
		yb=(int)(Math.random()*300);
		crb=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
		start();
	}
	public void run()
	{
		while(true)
		{
			moveBall();
			try
			{
				Thread.sleep(5);
			}
			catch(Exception e1){}
		}
	}
	void moveBall()
	{
		Graphics g=box.getGraphics();
		g.setColor(Color.BLACK);
		g.fillOval(xb,yb,xSizeb,ySizeb);
		xb+=dxb;
		yb+=dyb;/*
		g.setColor(cr);
		g.fillOval(x,y,xSize,ySize);*/
		Dimension db=box.getSize();
		if(xb<0)
		{
			xb=0;
			dxb=-dxb;
		}
		/*if(xb+xSizeb>=db.width)
		{
			xb=db.width-xSizeb;
			dxb=-dxb;
		}*/
		if((xb+xSizeb>=Field.getXvar()) && (xb+xSizeb<=Field.getXsizevar()))
		{
			xb=db.width-xSizeb;
			dxb=-dxb;
		}
		if(yb<0)
		{
			yb=0;
			dyb=-dyb;
		}
		if(yb+ySizeb>=db.height)
		{
			yb=db.height-ySizeb;
			dyb=-dyb;
		}
		g.setColor(crb);
		g.fillOval(xb,yb,xSizeb,ySizeb);
	}
}