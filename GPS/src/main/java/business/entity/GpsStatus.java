package business.entity;

public enum GpsStatus {
    BEING_ESTIMATED("BEING_ESTIMATED"),
    NOT_ALIGNED("NOT_ALIGNED"),
    DIFFERENTIAL_LOCATION("DIFFERENTIAL_LOCATION"),
    NON_DIFFERENTIAL_LOCATION("NON_DIFFERENTIAL_LOCATION");

    public static final GpsStatus All[] = {BEING_ESTIMATED,NOT_ALIGNED,DIFFERENTIAL_LOCATION,NON_DIFFERENTIAL_LOCATION};

    private final String name;

    private GpsStatus(String name){this.name = name;}

    public static GpsStatus forname(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if (name.toUpperCase().equals("BEING_ESTIMATED")) {
            return BEING_ESTIMATED;
        } else if (name.toUpperCase().equals("NOT_ALIGNED")) {
            return NOT_ALIGNED;
        } else if (name.toUpperCase().equals("DIFFERENTIAL_LOCATION")) {
            return DIFFERENTIAL_LOCATION;
        } else if (name.toUpperCase().equals("NON_DIFFERENTIAL_LOCATION")) {
            return NON_DIFFERENTIAL_LOCATION;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() { return this.name; }

    @Override
    public String toString() { return getName(); }

    public static GpsStatus fornumber(Integer number) {
        if (number == null) {
            return null;
        }
        if (number.equals(0)) {
            return BEING_ESTIMATED;
        } else if (number.equals(1)) {
            return NOT_ALIGNED;
        } else if (number.equals(2)) {
            return DIFFERENTIAL_LOCATION;
        } else if (number.equals(3)) {
            return NON_DIFFERENTIAL_LOCATION;
        }
        return null;
    }
}
