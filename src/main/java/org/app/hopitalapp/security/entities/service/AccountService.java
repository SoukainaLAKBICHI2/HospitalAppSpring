package org.app.hopitalapp.security.entities.service;


import org.app.hopitalapp.security.entities.AppRole;
import org.app.hopitalapp.security.entities.AppUser;

//les methodes que j'aurai besoin
public interface AccountService {
    AppUser addNewUser(String username, String password, String email, String confirmedPassword);
    AppRole addNewRole(String role);
    void addRoleToUser(String username, String role);
    void removeRoleFromUser(String username, String role);
    AppUser loadUserByUsername(String username);
}
