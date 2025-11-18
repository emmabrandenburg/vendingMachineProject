Class section
{
	Int xPos;
	Int yPos;
	station st[];

  //default constructor
	public section()
	{
		xPos = 0;
		yPos = 0;
		St = new station[4];

    //sets each respective station to same location as left or right section
    //levels each station from 1 to 4 in either left or right section
		For (int i = 0; i < 4; i++)
		{
			st[i].setXPos(xPos);
			st[i].setYPos(yPos);
			st[i].setZPos(i+1);
		}
	}
}
