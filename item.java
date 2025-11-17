import java.util.Random;

public class Item {
    int serialNum;
    boolean coldCheck;
    double weight;
    Random random = new Random();

    //Item constructors
    public Item(){
        //FIXME (make the first number never 5)
        serialNum = random.nextInt(9000) + 1000;
        coldCheck = false;
        weight = 0.0;
    }

    public Item(boolean cold, double kilograms){
        coldCheck = cold;
        weight = kilograms;

        // If Item is set to cold, then first num in serialNum is set to 5
        if( cold == true){
            int tempID = random.nextInt(900) + 100;
            String stringID = String.valueOf(tempID);
            String combindID = "5" + stringID;
            int finalID = Integer.valueOf(combindID);
            serialNum = finalID;
        }
        else{
            serialNum = random.nextInt(9000) + 1000;
        }
    }

    public int getSerialNum(){
        return serialNum;
    }

    public double getWeight(){
        return weight;
    }

    public static void main(String[] args){
        Item it = new Item();
        Item em = new Item(true, 12.5);

        System.out.println(it.getSerialNum());
        System.out.println(it.getWeight());
        System.out.println(em.getSerialNum());
        System.out.println(em.getWeight());
    }
}


