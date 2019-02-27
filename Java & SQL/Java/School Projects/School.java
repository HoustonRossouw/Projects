public class School
{
   public static void main (String [] args)
   {
   
      Student sally = new Student("Sally", 15, 8, 'D');
      Student sipho = new Student("Sipho", 17 , 11, 'A');
      Student rajesh = new Student("Rajesh", 19, 12, 'B');

      //Teacher
      Teacher houston = new Teacher("houston",32,12,"Computer class",5,'B');
      //Secretary
      Secretary rosa = new Secretary("Rosa",45,10);
      //Printing Students
      System.out.println("Students\n");
      System.out.println(sally + "\n");
      System.out.println(sipho + "\n");
      System.out.println(rajesh+ "\n");
      //Printing Teacher
      System.out.println("Teacher");
      System.out.println(houston+"\n");
      //Printing Secretary
      System.out.println("Secretary");
      System.out.println(rosa);


   }
}