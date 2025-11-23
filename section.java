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
  public void defineStations(){
    if(sectionType == 1){
      stationList[0] = new station(0, 1, 1);
      stationList[1] = new station(0, 2, 3);
      stationList[2] = new station(0, 3, 5);
      stationList[3] = new station(0, 4, 7);
    }
    else{
      stationList[0] = new station(1, 1, 2);
      stationList[1] = new station(1, 2, 4);
      stationList[2] = new station(1, 3, 6);
      stationList[3] = new station(1, 4, 8);
    }
  }


}
