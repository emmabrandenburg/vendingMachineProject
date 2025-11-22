class leftSection
{
	int xPos;
	int yPos;
	station st[];

	public leftSection()
	{
		xPos = 0;
		yPos = 0;
		st = new station[4];

		for (int i = 0; i < 4; i++)
		{
			st[i].setXPos(xPos);
			st[i].setYPos(yPos);
			st[i].setZPos(i+1);
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
}
