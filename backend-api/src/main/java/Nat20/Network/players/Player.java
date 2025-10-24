package Nat20.Network.players;

import Nat20.Network.requests.*;
import Nat20.Network.campaign.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "players")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String name;

    @Email
    @NotBlank
    @Column(unique = true, nullable = false)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;

    @JsonIgnoreProperties("players")
   @ManyToMany(mappedBy = "players")
    private Set<campaign> campaigns = new HashSet<>();

    public Player(long id) {
        this.id = id;
    }
    
    

    public Set<campaign> getCampaigns() {
        return campaigns;
    }

    public void addCampaign(campaign c) {
        campaigns.add(c);
        c.getPlayers().add(this);
    }

    public void removeCampaign(campaign c) {
        campaigns.remove(c);
        c.getPlayers().remove(this);
    }
}
