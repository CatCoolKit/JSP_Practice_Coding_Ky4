/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package obJect;

/**
 *
 * @author manhc
 */
public class peoPle1 {
    private int humanId;
    private String humanName;
    private String humanDob;
    private String humangender;
    private int typeId;

    public peoPle1() {
    }

    public peoPle1(int humanId, String humanName, String humanDob, String humangender, int typeId) {
        this.humanId = humanId;
        this.humanName = humanName;
        this.humanDob = humanDob;
        this.humangender = humangender;
        this.typeId = typeId;
    }

    public int getHumanId() {
        return humanId;
    }

    public void setHumanId(int humanId) {
        this.humanId = humanId;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public String getHumanDob() {
        return humanDob;
    }

    public void setHumanDob(String humanDob) {
        this.humanDob = humanDob;
    }

    public String getHumangender() {
        return humangender;
    }

    public void setHumangender(String humangender) {
        this.humangender = humangender;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public String toString() {
        return "peoPle1{" + "humanId=" + humanId + ", humanName=" + humanName + ", humanDob=" + humanDob + ", humangender=" + humangender + ", typeId=" + typeId + '}';
    }
    
    
}
