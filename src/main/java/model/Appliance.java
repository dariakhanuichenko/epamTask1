package model;

public abstract class Appliance {
    String name;
    int power;
    boolean isOn;

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

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
}



