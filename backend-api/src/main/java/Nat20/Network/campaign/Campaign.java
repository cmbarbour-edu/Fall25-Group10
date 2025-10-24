package Nat20.Network.campaign;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder.Default;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Nat20.Network.dungeonMaster.*;
import Nat20.Network.player.*;
import Nat20.Network.request.*;
import Nat20.Network.review.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

    @NotBlank
    @Column(nullable = false)
    private Boolean isPublic = false;

    @ManyToOne
    @JoinColumn(name = "dm_id", nullable = false)
    @JsonIgnoreProperties("campaigns")
    private DM dungeon_master;

    @ManyToMany
    @JoinTable(
        name = "campaign_players",
        joinColumns = @JoinColumn(name = "campaign_id", referencedColumnName = "campaignID"),
        inverseJoinColumns = @JoinColumn(name = "player_id", referencedColumnName = "playerID")
    )
    private Set<player> players = new HashSet<>();

    public void addPlayer(player p) {
        players.add(p);
        p.getCampaigns().add(this);
    }

    public void removePlayer(player p) {
        players.remove(p);
        p.getCampaigns().remove(this);
    }

}
