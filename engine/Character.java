public class Character{
    private static final int NUM_STATS=6;
    private int[] chromosome;
    private int hp;

    public Character(int hp){
        this.chromosome=new int[NUM_STATS];
        this.hp=hp;
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