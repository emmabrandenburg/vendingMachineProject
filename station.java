Class station
{
	Int xPos;
	Int yPos;
	Int zPos;
	Item it[];

	public station()
	{
		xPos = 0;
		yPos = 0;
		zPos = 1;
		It = new Item[8];
	}

	//sets it to the same x coordinate of left or right section
  	public void setXPos(int x)
  	{
    	xPos += z;
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
}
