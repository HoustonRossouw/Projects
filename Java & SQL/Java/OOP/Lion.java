public class Lion extends Animal {


    public Lion (int numTeeth, boolean spots, int weight){
        super(numTeeth, spots, weight);

    }

    public String toString(){
        String output = "Number of Teeth : " + getNumTeeth();
        output += "\nSpots : " + getSpots();
        output += "\nWeight : " + getWeight();
        if (getWeight() <= 80)
        {
            System.out.println("lion Cub\n");
        }
        else if (getWeight() <= 120)
        {
            System.out.println("Lion Female Adult\n");
        }
        else if (getWeight() >= 121)
        {
            System.out.println("Lion Male Adult\n");
        }
        return output;

    }

    public static void main(String[]args){
        Lion lion = new Lion(30, false, 130);
        System.out.println(lion);
    }

}



