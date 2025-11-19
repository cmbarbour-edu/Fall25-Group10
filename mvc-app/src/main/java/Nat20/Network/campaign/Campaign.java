package Nat20.Network.campaign;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Nat20.Network.dungeonMaster.*;
import Nat20.Network.players.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@Table(name = "campaigns")
public class Campaign {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long campaignID;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false, length = 5000)
    private String description;

    @Column(nullable = false, length = 1000)
    private String shortDescription;

    @Column(nullable = false, length = 255)
    private String edition;
    
    @Column(nullable = false)
    private Boolean isPublic = false;

    @ManyToOne
    @JoinColumn(name = "dm_id", nullable = false)
    @JsonIgnoreProperties({"username", "email", "password", "campaigns", "reviews"})
    private DM dm_id;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JsonIgnore
    @JoinTable(
        name = "campaign_players",
        joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName = "campaignID"),
        inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "playerID")
    )
    private Set<Player> players = new HashSet<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Campaign that)) return false;
        return Objects.equals(campaignID, that.campaignID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(campaignID);
    }
    /*
    public void addPlayer(Player p) {
        players.add(p);
        p.getCampaigns().add(this);
    }

    public void removePlayer(Player p) {
        players.remove(p);
        p.getCampaigns().remove(this);
    }
        */

}
