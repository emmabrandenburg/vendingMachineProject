import java.util.Random;

public class item {
    int serialNum;
    boolean coldCheck;
    double weight;
    Random random = new Random();


    public item(){
        serialNum = random.nextInt(9000) + 1000;
        coldCheck = false;
        weight = 0.0;
    }

    public item(){

    }

}


