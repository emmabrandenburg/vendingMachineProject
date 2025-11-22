class pickUpStation extends station
{
	int amount;
	
	public pickUpStation()
	{
		xPos = 1;
		yPos = 0;
		zPos = 1;
		it = new Item[amount];
	}
}
