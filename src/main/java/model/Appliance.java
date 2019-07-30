package model;

public class Appliance {
    protected String name;
    protected int power;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    protected boolean isOn;

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }



    public Appliance() {
    }

    public Appliance(String name, int power) {
        this.name = name;
        this.power = power;
        this.isOn = false;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (this == null) return false;
        if (obj instanceof Appliance) {
            Appliance temp = (Appliance) obj;
            return name.equals(temp.name) && (power == temp.power);
        } else return false;
    }

    @Override
    public int hashCode() {
        return (int) 31 * power + ((name == null) ? 0 : name.hashCode());
    }
}



