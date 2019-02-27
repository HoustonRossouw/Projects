public class Cheetah extends Animal {

    public Cheetah(int numTeeth, Boolean spots,int weight){
        super(numTeeth,spots, weight);
    }

    public String toString(){
        String output = "Number of Teeth : "+ getNumTeeth();
        output += "\nSpots : "+ getSpots();
        output += "\nWeight : "+ getWeight();
        return output;
    }
    public static void main(String[]args){
        System.out.println("Cheetah");
        Cheetah cheetah = new Cheetah(35,true, 50);
        System.out.println(cheetah);
    }
}
