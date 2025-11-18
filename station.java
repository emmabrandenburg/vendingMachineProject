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

  public void setZPos(int z)
  {
    zPos += z;
  }
  
  public void setYPos(int y)
  {
    yPos += y;
  }	
  
  public void setZPos(int z)
  {
    zPos += z;
  }	
}
