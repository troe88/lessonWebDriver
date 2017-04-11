package com.spbstu.pageobjectsfactory.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Created by dmitry on 11.04.2017.
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    String login;
    String password;
}
