package com.example.mpesa;

public class ab {
    String Names, Village,Age,Date;

    public ab(String names, String village, String age) {

    }

    public ab(String names, String village, String age, String gender, String time, String date) {
        Names = names;
        Village = village;
        Age = age;
        Date = date;
    }

    public String getNames() {
        return Names;
    }

    public void setNames(String names) {
        Names = names;
    }

    public String getVillage() {
        return Village;
    }

    public void setVillage(String village) {
        Village = village;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }


}



