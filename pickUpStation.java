class pickUpStation extends station
{
	public pickUpStation()
	{
		xPos = 1;
		yPos = 0;
		zPos = 1;
		it = new item[64];
		capacity = it.length;
	}
	
	public int getXPos()
	{
		return xPos;
	}
	
	public int getYPos()
	{
		return yPos;
	}
}
