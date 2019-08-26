package com.example.stream.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    public enum Sex{
        MALE,FEMALE
    }
    String name;
    LocalDate birthday;
    Sex gender;
    String email;


    public static int compareAge(Person a,Person b){
        return a.birthday.compareTo(b.birthday);
    }
}
