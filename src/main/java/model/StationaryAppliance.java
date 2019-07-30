package model;

public  class StationaryAppliance extends Appliance {

    private final int x;
    private final int y;

    public StationaryAppliance( int x, int y ,String name,int power){
        super(name,power);
        this.x=x;
        this.y=y;
    }

    /**
     *
     * @return  string in format "name:  %15s  power: %2d  on: %1s (%2d;%2d);"
     */
    public String toString(){
        return String.format("name:  %15s  power: %3d  on: %1s (%2d;%2d);", name, power, isOn ? "+":"-", x, y);
    }

}
