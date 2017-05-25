package pl.marczak.ifixpicturesrenderer.model;

import com.google.gson.annotations.SerializedName;

/**
 * Project "SynopticScreens"
 * <p>
 * Created by Lukasz Marczak
 * on 30.04.2017.
 */
public class Person {

    @SerializedName("@dob")
    private String dob;

    @SerializedName("@gender")
    private String gender;

    private String name;

//    @SerializedName("$")
//    private String description;

    @Override public String toString() {
        return "Person{" +
                "dob='" + dob + '\'' +
                ", gender='" + gender + '\'' +
                ", name='" + name + '\'' +
//                ", description='" + description + '\'' +
                '}';
    }
}