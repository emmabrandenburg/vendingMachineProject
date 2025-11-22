//station class where constructors and methods are defined
class station
{
	int xPos;
	int yPos;
	int capacity;
	Item itemList[];
	int stationNum;

	//creates defualt constructor for station object
	public station()
	{
		xPos = 0;
		yPos = 0;
		zPos = 1;
		itemList = new Item[8];
		capacity = itemList.length;
		stationNum = 1;
	}

	//sets it to the same x coordinate of left or right section
  	public void setXPos(int x)
  	{
    	xPos += x;
  	}

	//sets it to the same y coordinate of left or right section
  	public void setYPos(int y)
  	{
    	yPos += y;
  	}	

	//returns xPos
  	public int getXPos()
  	{
  		return xPos;
  	}

	//returns yPos
  	public int getYPos()
  	{
  		return yPos;
  	}

	//returns length of itemList
  	public int getCapacity()
  	{
  		return capacity;
  	}

	//returns true if there is space for an item
	public boolean numItemCheck()
	{
		for (int i = 0; i < capacity; i++)
		{
			if (itemList[i] == null)
			{
				return true;
			}
		}
		return false;
	}

	//returns position of item slot
	public int findItemSlot()
	{
		for (int i = 0; i < capacity; i++)
		{
			if (numItemCheck() == true)
			{
				return i + 1;
			}
		}
		return -1;
	}

	//returns the station number of station
	public int getStationNum()
	{
		return stationNum;
	}

	//assigns special stations their needed values
	private void stationAssign(int xLoc, int yLoc)
	{
		xPos = xLoc;
		yPos = yLoc;
	}
}
