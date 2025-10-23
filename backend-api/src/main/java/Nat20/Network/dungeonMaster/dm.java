package Nat20.Network.dungeonMaster;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;


import Nat20.Network.campaign.*;
import Nat20.Network.review.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dungeon_masters")
public class dm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dmID;

    @NotBlank
    @Column(nullable = false)
    private String username;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "dungeon_master", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("dungeon_master")
    private List<campaign> campaigns = new ArrayList<>();

    @OneToMany(mappedBy = "dungeon_master", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("dungeon_master")
    private List<review> reviews = new ArrayList<>();

    public dm(Long id) {
        this.dmID = id;
    }
    
    public dm(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public dm(Long dmID, String username, String email, String password) {
        this.dmID = dmID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
