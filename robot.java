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

	Scanner scan = new Scanner(System.in);

	public robot()
	{
		xPos = 0;
		yPos = 0;
		zPos = 1;
		it = null;
	}

	public void moveLeft()
	{
		System.out.println("Number of places to move: ");
		int x = scan.nextInt();
		
		if (x < 0)
		{
			System.out.println("You can’t enter a negative number");
		}
		else if (xPos - x >= lowXBound)
		{
			xPos -= x;
		}
		else
		{
			System.out.println("You can’t move farther than that");
		}
	}

	public void moveRight()
	{
		System.out.println("Number of places to move: ");
		int x = scan.nextInt();

		if (x < 0)
		{
			System.out.println("You can’t enter a negative number");
		}
		else if (xPos + x <= highXBound)
		{
			xPos += x;
		}
		else
		{
			System.out.println("You can’t move farther than that");
		}
	}

	public void moveForward()
	{
		System.out.println("Number of places to move: ");
		int y = scan.nextInt();

		if (y < 0)
		{
			System.out.println("You can’t enter a negative number");
		}
		else if (yPos + y <= highYBound)
		{
			yPos += y;
		}
		else
		{
			System.out.println("You can’t move farther than that");
		}
	}

	public void moveBackward()
	{
		System.out.println("Number of places to move: ");
		int y = scan.nextInt();

		if (y < 0)
		{
			System.out.println("You can’t enter a negative number");
		}
		else if (yPos - y >= lowYBound)
		{
			yPos -= y;
		}
		else
		{
			System.out.println("You can’t move farther than that");
		}
	}

	public void raiseArm()
	{
		int z = scan.nextInt();

		if (z < 0)
		{
			System.out.println("You can’t enter a negative number");
		}
		else if (zPos + z <= highZBound)
		{
			zPos += z;
		}
		else
		{
			System.out.println("You can’t raise the arm more than that");
		}
	}

	public void lowerArm()
	{
		int z = scan.nextInt();

		if (z < 0)
		{
			System.out.println("You can’t enter a negative number");
		}
		else if (zPos - z >= lowZBound)
		{
			zPos -= z;
		}
		else
		{
			System.out.println("You can’t lower the arm more than that");
		}
	}

	public void hasItem()
	{
		if (it != null)
		{
			System.out.println("Yes");
		}
		else
		{
			System.out.println("No");
		}
	}

	public void checkItemID()
	{
		if (it != null)
		{
			String itemID = it.getId();
			System.out.println("The ID number of the item is " + itemID);
		}
		else
		{
			System.out.println("You don’t have an item");
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
			else
			{
				System.out.println("You are not at the right position");
			}
		}
		else
		{
			System.out.println("You already have an item");
		}
	}
	
	public void putItem()
	{
		station st1 = new station();
		boolean xInStation = xPos == st1.xPos;
		boolean yInStation = yPos == st1.yPos;
		boolean zInStation = zPos == st1.zPos;
		boolean correctPos = xInStation && yInStation & zInStation;
		int st1Capacity = st1.getCapacity();
		
		if (it != null)
		{
			if (correctPos)
			{
				if (st1 == new station5())
				{
					if (it.getId().charAt(0) == '5')
					{
						for (int i = 0; i < st1Capacity; i++)
						{
							if (st1.it[i] == null)
							{
								st1.it[i] = new item();
								it = null;
								System.out.println("You placed an item in station 5");
								break;
							}
						}
					}
					else
					{
						System.out.println("You can't place this item in station 5");
						System.out.println("The first digit should be equal to 5");
					}
				}
				else if (st1 == new station7())
				{
					if (it.getWeight() < 50)
					{
						for (int i = 0; i < st1Capacity; i++)
						{
							if (st1.it[i] == null)
							{
								st1.it[i] = new item();
								it = null;
								System.out.println("You placed an item in station 7");
								break;
							}
						}
					}
					else
					{
						System.out.println("You can't place this item in station 7");
						System.out.println("The item's weight should be less than 50 kilograms");
					}
				}
			}
			System.out.println("You aren't in the right place");
		}
		else
		{
			System.out.println("You don't have an item");
		}
	}
}
