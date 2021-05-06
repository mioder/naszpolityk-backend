package com.naszpolityk.inzynierka.registration;

import com.naszpolityk.inzynierka.appuser.AppUser;
import com.naszpolityk.inzynierka.appuser.AppUserRole;
import com.naszpolityk.inzynierka.appuser.AppUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RegistrationService {

    private final AppUserService appUserService;
    private final EmailValidator emailValidator;

    public String register(RegistrationRequest request) {
        boolean isValidEmail = emailValidator.test(request.getEmail());

        if (!isValidEmail){
            throw new IllegalStateException("Email not valid!");
        }

        return appUserService.signUpUser(
                new AppUser(
                        request.getLogin(),
                        request.getPassword(),
                        request.getFirstName(),
                        request.getDateOfBirth(),
                        request.getEmail(),
                        AppUserRole.USER

                )
        );
    }

}