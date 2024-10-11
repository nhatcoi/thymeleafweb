package org.example.mywebapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffDTO {
    private Integer id;

    private String firstName;

    private String lastName;

    private String email;

    private String position;

    private boolean enabled;

    private String resume;
}
