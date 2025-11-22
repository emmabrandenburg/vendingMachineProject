class robot
{
	int xPos;
	int yPos;
	int zPos;
	int highXBound = 5;
	int highYBound = 5;
	int highZBound = 4;
	int lowXBound = 0;
	int lowYBound = 0;
	int lowZBound = 1;
	item it;

	public robot()
	{
		xPos = 0;
		yPos = 0;
		zPos = 1;
		it = null;
	}

	public void moveLeft()
	{
		if (xPos - x >= lowXBound)
		{
			xPos -= x;
		}
	}

	public void moveRight()
	{
		if (xPos + x <= highXBound)
		{
			xPos += x;
		}
	}

	public void moveForward()
	{
		if (yPos + y <= highYBound)
		{
			yPos += y;
		}
	}

	public void moveBackward()
	{
		else if (yPos - y >= lowYBound)
		{
			yPos -= y;
		}
	}

	public void raiseArm()
	{
		if (zPos + z <= highZBound)
		{
			zPos += z;
		}
	}

	public void lowerArm()
	{
		if (zPos - z >= lowZBound)
		{
			zPos -= z;
		}
	}
	
	public void pickUpItem()
	{
		pickUpStation pst = new pickUpStation();
		int pstCapacity = pst.getCapacity();
		
		if (it == null)
		{
			if (xPos == pst.getXPos() && yPos == pst.getYPos())
			{
				for (int i = 0; i < pstCapacity; i++)
				{
					if (pst.it[i] != null)
					{
						it = new item();
						pst.it[i] = null;
						System.out.println("You have recieved an item");
						break;
					}
				}
			}
		}
	}
	
	public void putItem()
	{
		leftSection lSec = new leftSection();
		rightSection rSec = new rightSection();
		station st1 = new station();
		station5 st5 = new station5();
		station7 st7 = new station7();

		int st1Capacity = st1.getCapacity();
		
		if (it != null)
		{
			if (it.coldCheck == true)
			{
				while (xPos > st5.getXPos())
				{
					moveLeft();
				}
				while (xPos < st5.getXPos())
				{
					moveRight();
				}
				while (yPos < st5.getYPos())
				{
					moveForward();
				}
				while (yPos > st5.getYPos())
				{
					moveBackward();
				}
				while (zPos < st5.getZPos())
				{
					raiseArm();
				}
				while (zPos > st5.getZPos())
				{
					lowerArm();
				}
					
				for (int i = 0; i < st1Capacity; i++)
				{
					if (st5[i] == null)
					{
						st5.it[i] = new item();
						it = null;
						break;
					}
				}	
			}
			else if (it.getWeight() < 50)
			{
				while (xPos > st7.getXPos())
				{
					moveLeft();
				}
				while (xPos < st7.getXPos())
				{
					moveRight();
				}
				while (yPos < st7.getYPos())
				{
					moveForward();
				}
				while (yPos > st7.getYPos())
				{
					moveBackward();
				}
				while (zPos < st7.getZPos())
				{
					raiseArm();
				}
				while (zPos > st7.getZPos())
				{
					lowerArm();
				}
				
				for (int i = 0; i < st1Capacity; i++)
				{
					if (st7[i] == null)
					{
						st7.it[i] = new item();
						it = null;
						break;
					}
				}
			}
			else if (it.getStatusCode().equals("s1"))
			{
				while (xPos > lSec.getXPos())
				{
					moveLeft();
				}
				while (xPos < lSec.getXPos())
				{
					moveRight();
				}
				while (yPos < lSec.getYPos())
				{
					moveForward();
				}
				while (yPos > lSec.getYPos())
				{
					moveBackward();
				}

				xPos = 1;
				
				for (int i = xPos; i <= lSec.length; i++)
				{
					for (int j = 0; j < st1Capacity; i++)
					{
						lSec.st1[i].
				}
			}
			else
			{
				while (xPos > st7.getXPos())
				{
					moveLeft();
				}
				while (xPos < st7.getXPos())
				{
					moveRight();
				}
				while (yPos < st7.getYPos())
				{
					moveForward();
				}
				while (yPos > st7.getYPos())
				{
					moveBackward();
				}
					
				for (int i = 0; i < st1Capacity; i++)
				{
					if (st1[i] == null)
					{
						st1.it[i] = new item();
						it = null;
						break;
					}
				}
			}
		}
	}
}
