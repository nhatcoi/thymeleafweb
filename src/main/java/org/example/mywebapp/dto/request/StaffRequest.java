package org.example.mywebapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StaffRequest {
    private String email;

    private String firstName;

    private String lastName;

    private String position;

    private boolean enabled;
}
