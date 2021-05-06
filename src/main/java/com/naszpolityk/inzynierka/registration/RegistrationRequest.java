package com.naszpolityk.inzynierka.registration;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {

    private final String login;
    private final String password;
    private final String firstName;
    private final LocalDate dateOfBirth;
    private final String email;
}
