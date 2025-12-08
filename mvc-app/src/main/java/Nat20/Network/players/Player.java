package Nat20.Network.players;

import Nat20.Network.campaign.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@Table(name = "players")

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long playerID;

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

    @JsonIgnore
    @JsonIgnoreProperties("players")
    @ManyToMany(mappedBy = "players")
    private Set<Campaign> campaigns = new HashSet<>();


    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "stats_id", referencedColumnName = "id")
    @JsonIgnoreProperties("player")
    private PlayerStats stats;
    
    public Player(long id) {
        this.playerID = id;
    }

    public Set<Campaign> getCampaigns() {
        return campaigns;
    }

    public PlayerStats getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player that)) return false;
        return Objects.equals(playerID, that.playerID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(playerID);
    }

    /*
    public void addCampaign(Campaign c) {
        campaigns.add(c);
        c.getPlayers().add(this);
    }

    public void removeCampaign(Campaign c) {
        campaigns.remove(c);
        c.getPlayers().remove(this);
    }
        */



}
