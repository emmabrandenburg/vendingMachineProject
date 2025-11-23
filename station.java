//station class where constructors and methods are defined
class station
{
	int xPos;
	int yPos;
	int capacity;
	item itemList[];
	int stationNum;
	boolean isCold;
	boolean isLight;

	//creates defualt constructor for station object
	public station()
	{
		xPos = 0;
		yPos = 0;
		itemList = new item[8];
		capacity = itemList.length;
		stationNum = -1;
	}

	public station(int x, int y, int number, boolean cold, boolean light)
	{
		xPos = x;
		yPos = y;
		itemList = new item[8];
		capacity = itemList.length;
		stationNum = number;
		isCold = cold;
		isLight = light;
	}

	//sets it to the same x coordinate of left or right section
  	public void setXPos(int x)
  	{
    	xPos = x;
  	}

	//sets it to the same y coordinate of left or right section
  	public void setYPos(int y)
  	{
    	yPos = y;
  	}	

	public int[] getCords(){
		int cords[] = {xPos, yPos};
		return cords;
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
}
