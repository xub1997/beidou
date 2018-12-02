package business.entity;

public enum  CarType {
    PHONE("PHONE"),
    SEDAN("SEDAN"),
    BUS("BUS");

    public static final CarType[] ALL = {PHONE, SEDAN,BUS};

    private final String name;

    CarType(String name) { this.name = name; }

    public static CarType forName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if(name.toUpperCase().equals("PHONE")){
            return PHONE;
        }else if(name.toUpperCase().equals("SEDAN")){
            return SEDAN;
        }else if(name.toUpperCase().equals("BUS")){
            return BUS;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() { return name; }

    @Override
    public String toString() { return getName(); }
}
