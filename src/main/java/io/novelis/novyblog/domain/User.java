package io.novelis.novyblog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Collection<Comment> comments;


}
