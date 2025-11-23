class section {
  int sectionType;
  station stationList[];

  //Constructors
  public section(){
    sectionType = -1;
  }

  public section(int type){
    sectionType = type;
    stationList = new station[4];
  }

  //Methods
  public void createStations(){
    if(sectionType == 1){
      stationList[0] = new station(0, 1, 1, false, false);
      stationList[1] = new station(0, 2, 3, false, false);
      stationList[2] = new station(0, 3, 5, true, false);
      stationList[3] = new station(0, 4, 7, false, true);
    }
    else{
      stationList[0] = new station(1, 1, 2, false, false);
      stationList[1] = new station(1, 2, 4, false, false);
      stationList[2] = new station(1, 3, 6, false, false);
      stationList[3] = new station(1, 4, 8, false, false);
    }
  }

  public int getSectionType(){
    return sectionType;
  }

  public station[] getStationList(){
    return stationList;
  }


}
