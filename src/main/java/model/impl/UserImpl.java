package model.impl;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.User;

@AllArgsConstructor
@Getter
@Setter
public class UserImpl implements User {
    long id;

    String name;

    String email;
}
