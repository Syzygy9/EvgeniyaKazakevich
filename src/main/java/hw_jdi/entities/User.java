package hw_jdi.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import utils.ConfigProperties;

@AllArgsConstructor
@Setter
@Getter
public class User {

    private String login;
    private String password;
    private String fullName;

    public static User ROMAN = new User(
            ConfigProperties.getProperty("user"),
            ConfigProperties.getProperty("password"),
            ConfigProperties.getProperty("fullusername"));


}