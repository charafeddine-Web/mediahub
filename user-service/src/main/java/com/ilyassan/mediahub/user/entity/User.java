package com.ilyassan.mediahub.user.entity;

import com.ilyassan.mediahub.user.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Entity
@Table(name = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    // Stored as a string in the DB ("USER" or "ADMIN"), not a number
    @Enumerated(EnumType.STRING)
    private Role role;
}
