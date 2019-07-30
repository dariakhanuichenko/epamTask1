package model;

import java.util.ArrayList;
import java.util.List;

public class House {
    private List<PortableAppliance> portableAppliances;
    private List<StationaryAppliance> stationaryAppliances;

    public House(){
        this.portableAppliances=new ArrayList<PortableAppliance>();
        this.stationaryAppliances=new ArrayList<StationaryAppliance>();
    }

    public List<PortableAppliance> getPortableAppliances() {
        return portableAppliances;
    }


    public List<StationaryAppliance> getStationaryAppliances() {
        return stationaryAppliances;
    }

}
