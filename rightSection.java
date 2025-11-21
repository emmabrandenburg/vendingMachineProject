class rightSection
{
	int xPos;
	int yPos;
	station st[];

	public rightSection()
	{
		xPos = 0;
		yPos = 0;
		st = new station[4];
		st[0] = new station5();
		st[2] = new station7();
		
		for (int i = 0; i < 4; i++)
		{
			st[i].setXPos(xPos);
			st[i].setYPos(yPos);
			st[i].setZPos(i+1);
		}
	}
}
