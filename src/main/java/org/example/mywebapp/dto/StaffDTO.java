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
    private String email;

    private String firstName;

    private String lastName;

    private String position;

    private boolean enabled;
}
