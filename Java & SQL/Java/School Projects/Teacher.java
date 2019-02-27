public class Teacher {

    String name;
    int age;
    int grade;
    String subject;
    int yearsOfExperience;
    char registrationClass;

    public Teacher(String name,int age, int grade,String subject,int yearsOfExperience,char registrationClass){
        this.name = name;
        this.age = age;
        this.grade = grade;
        this. subject = subject;
        this.yearsOfExperience = yearsOfExperience;
        this.registrationClass = registrationClass;
    }

    public String toString(){
        String output = "Name: " + name;
        output += "\nAge: " + age;
        output += "\nGrade: "+ grade;
        output += "\nSubject: "+ subject;
        output += "\nYear of experience: "+ yearsOfExperience;
        output += "\nRegistration Class: " + registrationClass;

        return output;
    }
}
