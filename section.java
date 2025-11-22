class station
{
	int xPos;
	int yPos;
	int zPos;
	int capacity;
	Item it[];

	public station()
	{
		xPos = 0;
		yPos = 0;
		zPos = 1;
		it = new Item[8];
		capacity = it.length;
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

	//used to level the stations from 1 to 4
  	public void setZPos(int z)
  	{
    	zPos += z;
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
  	
  	public int getCapacity()
  	{
  		return capacity;
  	}
}
