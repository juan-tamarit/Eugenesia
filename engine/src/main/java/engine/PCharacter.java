package engine;

public class PCharacter{
    private int[] chromosome;
    private int hp;

    public PCharacter(int[]chromosome){
        this.chromosome=chromosome;
        this.hp=this.chromosome[Stat.CON.getIndex()];
    }

    public void setStat(Stat stat, int value){
        this.chromosome[stat.getIndex()]=value;
    }
    public int getStat(Stat stat){
        return this.chromosome[stat.getIndex()];
    }
    public void setHP(int hp){
        this.hp=hp;
    }
    public int getHp(){
        return this.hp;
    }
}