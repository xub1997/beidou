package business.entity;

public enum UserType {
    ADMIN("ADMIN"),
    STANDARD("STANDARD");

    public static final UserType[] ALL = {ADMIN, STANDARD};

    private final String name;

    private UserType(String name) {this.name = name;}

    public static UserType forName(String name){
        if(name == null){
            throw new IllegalArgumentException("Name cannot be null fo type");
        }
        if(name.toUpperCase().equals("ADMIN")){
            return ADMIN;
        }else if(name.toUpperCase().equals("STANDARD")){
            return STANDARD;
        }
        throw new IllegalArgumentException("Name \"" + name + "\"does not correspond to any Type");
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() { return getName(); }
}
