package supportingSalesApp;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;
import supportingSalesApp.model.AppUser;
import supportingSalesApp.repo.AppUserRepo;

@Configuration
public class InitialUsers {

    public InitialUsers(AppUserRepo appUserRepo, PasswordEncoder passwordEncoder) {
        AppUser appUserNotDefined = new AppUser();
        appUserNotDefined.setUsername("Niezdefiniowany");
        appUserNotDefined.setPassword(passwordEncoder.encode("!@#$%^&*"));
        appUserNotDefined.setRole("ROLE_USER");
        appUserNotDefined.setEnabled(false);

        AppUser userSeller = new AppUser();
        userSeller.setUsername("UbraniaGwiazdka");
        userSeller.setPassword(passwordEncoder.encode("ubrania123"));
        userSeller.setRole("ROLE_ADMIN");
        userSeller.setEnabled(true);

        AppUser userBasic = new AppUser();
        userBasic.setUsername("Kamil");
        userBasic.setPassword(passwordEncoder.encode("kamil123"));
        userBasic.setRole("ROLE_USER");
        userBasic.setEnabled(true);

        appUserRepo.save(appUserNotDefined);
        appUserRepo.save(userSeller);
        appUserRepo.save(userBasic);


    }

}
