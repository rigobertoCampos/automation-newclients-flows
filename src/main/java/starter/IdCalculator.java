package starter;

import java.util.ArrayList;

public class IdCalculator {

    private static IdCalculator instance;

    private String id_trn;

    private IdCalculator(){
        setTRN();
    }
    private String getRandomId(int min, int max){

        Integer random_int = (int)Math.floor(Math.random() * (max - min + 1) + min);
        return random_int.toString();
    }

    public synchronized static IdCalculator getInstance(){
        if(instance == null){
            instance = new IdCalculator();
        }
        return instance;
    }

    private void setTRN(){
        id_trn = getRandomId(1000000000, 999999999);
    }

    public String getTRN(){
        System.out.println(id_trn + " TRN ");
        return id_trn;
    }

    public void setPassport(){
        this.id_trn = this.id_trn + "9";
    }

}
