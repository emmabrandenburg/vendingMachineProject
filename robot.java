class robot
{
	int xPos;
	int yPos;
	int zPos;
	int highXBound = 2;
	int highYBound = 1;
	int highZBound = 4;
	int lowXBound = 0;
	int lowYBound = 0;
	int lowZBound = 1;
	Item it;

	public robot()
	{
		xPos = 0;
		yPos = 0;
		zPos = 1;
		it = null;
	}

	public void moveLeft()
	{
		if (xPos - 1 >= lowXBound)
		{
			xPos --;
			System.out.println("You've moved left to (" + xPos + ", " + yPos + ")");
		}
	}

	public void moveRight()
	{
		if (xPos + 1 <= highXBound)
		{
			xPos ++;
			System.out.println("You've moved right to (" + xPos + ", " + yPos + ")");
		}
	}

	public void moveForward()
	{
		if (yPos - 1 <= highYBound)
		{
			yPos ++;
			System.out.println("You've moved forward to (" + xPos + ", " + yPos + ")");
		}
	}

	public void moveBackward()
	{
		if (yPos - 1 >= lowYBound)
		{
			yPos --;
			System.out.println("You've moved backward to (" + xPos + ", " + yPos + ")");
		}
	}

	public void raiseArm()
	{
		if (zPos + 1 <= highZBound)
		{
			zPos ++;
			System.out.println("You've raised the arm to level " + zPos);
		}
	}

	public void lowerArm()
	{
		if (zPos - 1>= lowZBound)
		{
			zPos --;
			System.out.println("You've lowered the arm to level " + zPos);
		}
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
	
	public int getZPos()
	{
		return zPos;
	}
	
	public void pickUpItem()
	{
		pickUpStation pst = new pickUpStation();
		int pstCapacity = pst.getCapacity();

		if (it == null)
		{
			while (xPos > pst.getXPos())
			{
				moveLeft();
			}
			while (xPos < pst.getXPos())
			{
				moveRight();
			}
			while (yPos < pst.getYPos())
			{
				moveForward();
			}
			while (yPos > pst.getYPos())
			{
				moveBackward();
			}
			while (zPos < pst.getZPos())
			{
				raiseArm();
			}
			while (zPos > pst.getZPos())
			{
				lowerArm();
			}

			for (int i = 0; i < pstCapacity; i++)
			{
				if (pst.it[i] != null)
				{
					it = pst.it[i];
					pst.it[i] = null;
					System.out.println("You have recieved item " + it.getSerialNum());
					break;
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
					if (st5.it[i] == null)
					{
						System.out.println("You've put item " + it.getSerialNum() + " in station 5");
						st5.it[i] = it;
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
					if (st7.it[i] == null)
					{
						System.out.println("You've put item " + it.getSerialNum() + " in station 7");
						st7.it[i] = it;
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

				zPos = 1;
				
				for (int i = zPos; i <= lSec.st.length; i++)
				{
					for (int j = 0; j < st1Capacity; i++)
					{
						if (lSec.st[i].it[j] == null)
						{
							System.out.println("You've put item " + it.getSerialNum() + " in a left station");
							lSec.st[i].it[j] = it;
							it = null;
							break;
						}
					}
				}
			}
			else
			{
				while (xPos > rSec.getXPos())
				{
					moveLeft();
				}
				while (xPos < rSec.getXPos())
				{
					moveRight();
				}
				while (yPos < rSec.getYPos())
				{
					moveForward();
				}
				while (yPos > rSec.getYPos())
				{
					moveBackward();
				}

				zPos = 1;
				
				for (int i = zPos; i <= lSec.st.length; i++)
				{
					for (int j = 0; j < st1Capacity; i++)
					{
						if (lSec.st[i].it[j] == null)
						{
							System.out.println("You've put item " + it.getSerialNum() + " in a right station");
							lSec.st[i].it[j] = it;
							it = null;
							break;
						}
					}
				}
			}
		}
	}

	public void promptUser()
	{
		String itemName;
		int amount;
		boolean isCold;
		double weight;
		pickUpStation pst2 = new pickUpStation();
		
		Scanner scan = new Scanner(System.in);

		System.out.print("Enter the name of the item: ");
		itemName = scan.next();
		System.out.print("Enter the amount to store away: ");
		amount = scan.nextInt();
		System.out.print("Enter true if it's cold or false if it's not: ");
		isCold = scan.nextBoolean();
		System.out.print("Enter the weight: ");
		weight = scan.nextDouble();
		System.out.println();

		pst2.it = new Item[amount];
		
		for (int i = 0; i < amount; i++)
		{
			it = new Item(itemName, isCold, weight);
		}
		
		for (int i = 0; i < amount; i++)
		{
			pickUpItem();
			putItem();
		}
	}
}
