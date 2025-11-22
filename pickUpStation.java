class pickUpStation extends station
{
	public pickUpStation()
	{
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
