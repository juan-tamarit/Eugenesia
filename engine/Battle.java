package engine;

import com.sun.source.tree.Tree;
import java.util.ArrayList;
import java.util.Comparator;

public class Battle{
    private PCharacter[] t1;
    private PCharacter[] t2;

    public Battle(PCharacter[] t1,PCharacter[] t2){
        this.t1=t1;
        this.t2=t2;
    }

    public void fight(){
        ArrayList<PCharacter> queue=this.order();
        while(!this.ended()){
            for (PCharacter c : queue){
                if (c.getHp()>0){
                    this.turn(c);
                }
            }
        }
        System.out.print("fin");
    }

    public ArrayList<PCharacter> order(){

        ArrayList<PCharacter> queue=new ArrayList<PCharacter>();
        for (PCharacter c: this.t1){
            queue.add(c);
        }
        for (PCharacter c: this.t2){
            queue.add(c); 
        }

        queue.sort((c1,c2)->Integer.compare(c2.getStat(Stat.DEX),c1.getStat(Stat.DEX)));
        return queue;
    }

    public void turn(PCharacter c){
        PCharacter target=this.identifyTarget(c);
        if (target!=null){
            int targetHp=target.getHp();
            switch (this.executeAction(c)) {
                case ATTACK:
                    target.setHP(targetHp-this.calculateDamage(c, Stat.STR));
                    break;
                case MAGIC:
                    target.setHP(targetHp-this.calculateDamage(c, Stat.IN));
                    break;
                case HEAL:
                    target.setHP(targetHp+this.calculateDamage(c, Stat.WIS));
                    break;
            }
        }
    }

    public PCharacter identifyTarget(PCharacter c){
        int wis=c.getStat(Stat.WIS);
        int str=c.getStat(Stat.STR);
        int in=c.getStat(Stat.IN);
        if (this.isInTeam(c, this.t1)){
            if (wis>str && wis>in){
                return this.selectFriend(c, t1);
            }else{
                for (PCharacter ca:this.t2){
                    if(ca.getHp()>0){
                        return ca;
                    }
                }
            }
        }else{
            if (wis>str && wis>in){
               return this.selectFriend(c, t2);
            }else{
                for (PCharacter ca:this.t1){
                    if(ca.getHp()>0){
                        return ca;
                    }
                }
            }
        }
        return null;
    }

    public PCharacter selectFriend(PCharacter c, PCharacter[] t){
        PCharacter target=t[0];
            for (int i=1;i<t.length;i++){
                if(t[i].getHp()<target.getHp()){
                    target=t[i];
                }else if(t[i].getHp()==target.getHp() && t[i].getStat(Stat.CHA)>target.getStat(Stat.CHA)){
                    target=t[i];
                }
            }
            return target;
    }

    public boolean isInTeam(PCharacter c, PCharacter[] t){
        boolean team=false;
        for (PCharacter ca: t){
            if (ca==c){
                team=true;
                break;
            }
        }
        return team;
    }

    public boolean ended(){
        boolean ended=true;

        for(PCharacter c : this.t1){
            if (c.getHp()>0){
                ended=false;
                break;
            }
        }
        if(ended){
            for(PCharacter c : this.t2){
                if (c.getHp()>0){
                    ended=false;
                    break;
                }
            }
        }

        return ended;
    }

    public Action executeAction(PCharacter c){
        int wis=c.getStat(Stat.WIS);
        int str=c.getStat(Stat.STR);
        int in=c.getStat(Stat.IN);
        if(wis>str && wis>in){
            return Action.HEAL;
        }else{
            if(str>in){
                return Action.ATTACK;
            }else{
                return Action.MAGIC;
            }
        }
    }

    public int calculateDamage(PCharacter c, Stat stat){
        return c.getStat(stat);
    }

}