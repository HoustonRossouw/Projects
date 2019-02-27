public class Secretary {

    String name;
    String surname;
    int age;
    String sex;
    int yearsOfExperience;

    public Secretary(String name,String surname,int age,String sex,int yearsOfExperience){
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.sex = sex;
        this.yearsOfExperience = yearsOfExperience;
    }
    public String toString(){
        String output = "Name: " + name;
        output +="\nSurename: "+ surname;
        output += "\nAge: " + age;
        output += "\nSex: "+sex;
        output += "\nYear of experience: "+ yearsOfExperience;

        return output;
    }
}
