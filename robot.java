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
		station st1 = new station();
		station5 st5 = new station5();
		station7 st7 = new station7();
		boolean xInStation = xPos == st1.xPos;
		boolean yInStation = yPos == st1.yPos;
		boolean zInStation = zPos == st1.zPos;
		boolean correctPos = xInStation && yInStation & zInStation;
		boolean xInStation5 = xPos == st5.xPos;
		boolean yInStation5 = yPos == st5.yPos;
		boolean zInStation5 = zPos == st5.zPos;
		boolean correctPos5 = xInStation && yInStation & zInStation;
		boolean xInStation7 = xPos == st7.xPos;
		boolean yInStation7 = yPos == st7.yPos;
		boolean zInStation7 = zPos == st7.zPos;
		boolean correctPos7 = xInStation && yInStation & zInStation;
		int st1Capacity = st1.getCapacity();
		int st5Capacity = st5.getCapacity();
		int st7Capacity = st7.getCapacity();

		if (it != null)
		{
			if (it.coldCheck == true)
			{
				if (correctPos5)
				{
					for (int i = 0; i < st5Capacity; i++)
					{
						if (st5[i] == null)
						{
							st5.it[i] = new item();
							it = null;
							break;
						}
					}
				}	
			}
			else if (it.getWeight() < 50)
			{
				if (correctPos7)
				{
					for (int i = 0; i < st7Capacity; i++)
					{
						if (st7[i] == null)
						{
							st7.it[i] = new item();
							it = null;
							break;
						}
					}
				}
			}
			else if (it.getStatusCode().equals("s1"))
			{
				if (correctPos)
				{
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
			else
			{
				if (correctPos)
				{
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
