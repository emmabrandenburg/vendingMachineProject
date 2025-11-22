class rightSection
{
	int xPos;
	int yPos;
	station st[];

	public rightSection()
	{
		xPos = 2;
		yPos = 1;
		st = new station[4];
		st[0] = new station5();
		st[2] = new station7();
		
		for (int i = 0; i < st.length; i++)
		{
			if (i != 0 && i != 2)
			{
				st[i] = new station();
			}
		}
		
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
