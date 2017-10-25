package main.java.ru.archi.model;


import java.time.LocalDate;

/**
 * Created by Черный on 19.10.2017.
 */
public class Author {
    private String name;
    private LocalDate dateOfBirth;
    private LocalDate dateOfDeath;
    private Sex sex;

    public Author(String name, LocalDate dateOfBirth,LocalDate dateOfDeath, Sex sex) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.sex = sex;
    }

    public Integer getAge(){
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDateOfDeath() {
        return dateOfDeath;
    }

    public void setDateOfDeath(LocalDate dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }


}
