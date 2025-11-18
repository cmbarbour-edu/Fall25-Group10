package Nat20.Network.dungeonMaster;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import Nat20.Network.campaign.*;
import Nat20.Network.review.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dungeon_masters")
public class DM {
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

    @OneToMany(mappedBy = "dm", cascade = CascadeType.ALL)
    private List<Campaign> campaigns = new ArrayList<>();

    @OneToMany(mappedBy = "dm", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Review> reviews = new HashSet<>();


    public DM(Long id) {
        this.dmID = id;
    }
    
    public DM(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public DM(Long dmID, String username, String email, String password) {
        this.dmID = dmID;
        this.username = username;
        this.email = email;
        this.password = password;
    }

}
