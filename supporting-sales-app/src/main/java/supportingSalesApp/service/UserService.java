package supportingSalesApp.service;


import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import supportingSalesApp.model.AppUser;
import supportingSalesApp.repo.AppUserRepo;

import java.util.List;

@Service
public class UserService {

    private AppUserRepo appUserRepo;
    private PasswordEncoder passwordEncoder;


    public UserService(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        this.appUserRepo = appUserRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public void addUser(AppUser appUser) {
        appUser.setPassword(passwordEncoder.encode(appUser.getPassword()));
        appUser.setRole("ROLE_USER");
        appUser.setEnabled(true);
        appUserRepo.save(appUser);
    }

    public List<AppUser> showUsers() {
        return appUserRepo.findAll();
    }
}
