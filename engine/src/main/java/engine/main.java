package engine;

public class main{
    public static void main(String[]args){
        int[] chr1= {1,1,1,1,1,1};
        int[] chr2= {5,5,5,5,5,5};
        int[] chr3= {20,20,20,20,20,20};
        PCharacter c1=new PCharacter(chr1);
        System.out.println("c1 creado");
        PCharacter c2=new PCharacter(chr2);
        System.out.println("c2 creado");
        PCharacter c3=new PCharacter(chr3);
        System.out.println("c3 creado");

        PCharacter[] t1= {c1,c2};
        PCharacter[] t2={c3};

        Battle battle=new Battle(t1, t2);
        System.out.println("batalla entre t1 y t2");
        battle.fight();
    }
}