package business.util;

import java.security.Principal;

public final class SessionUser implements Principal{

    private String name;

    public SessionUser(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (!(obj instanceof SessionUser)) {
            return false;
        }
        return this.name == ((SessionUser)obj).getName();
    }
}
