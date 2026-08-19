public enum Stat{
    STR(0),
    DEX(1),
    CON(2),
    IN(3),
    WIS(4),
    CHA(5);

    private int index;

    private Stat(int index){
        this.index=index;
    }

    public int getIndex(){
        return this.index;
    }
}