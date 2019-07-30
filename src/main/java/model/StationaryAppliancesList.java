package model;

public enum StationaryAppliancesList {
    APPLIANCE1("washing mashine",350,1,2),
    APPLIANCE2("refrigerator",260,0,0);
    private  int x;
    private  int y;
    private String name;
    private int power;
    private boolean isOn;

    StationaryAppliancesList(String name,int power, int x,int y){
        this.name=name;
        this.power=power;
        this.isOn=false;
        this.x=x;
        this.y=y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }
}
