package co.istad.fary.elearning.features.auth.dto;

import lombok.Getter;

@Getter
public enum GenderOptions {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other");

    private final String gender;

    GenderOptions(String gender) {
        this.gender = gender;
    }

}
