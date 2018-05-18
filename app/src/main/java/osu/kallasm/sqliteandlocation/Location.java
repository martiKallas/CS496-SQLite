package osu.kallasm.sqliteandlocation;

public class Location {
    public double getLattitude() {
        return lattitude;
    }

    public void setLattitude(double lattitude) {
        this.lattitude = lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    double lattitude;
    double longitude;

    public Location(double lattitude, double longitude) {
        this.lattitude = lattitude;
        this.longitude = longitude;
    }
}
