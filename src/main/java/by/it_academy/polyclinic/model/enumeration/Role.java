package by.it_academy.polyclinic.model.enumeration;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {

    ADMIN, DOCTOR, PATIENT, GUEST;

    @Override
    public String getAuthority() {
        return name();
    }
}
