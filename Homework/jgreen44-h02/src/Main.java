public class Main {

    public static void main(String[] args) {

        aMethod();
        aMethod(2);
        aMethod(3, "th method!");

    }

    public static void aMethod(){
        System.out.println("First method");

    }

    public static void aMethod(int a){
        System.out.println("This is the " + a + "nd method!");
    }

    public static void aMethod(int a, String b){
        System.out.println("This is the " + a + b);
    }
}
