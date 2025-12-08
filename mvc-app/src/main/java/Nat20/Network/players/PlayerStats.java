package Nat20.Network.players;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "player_stats")
public class PlayerStats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "stats")
    private Player player;

    @Column(nullable = false)
    private Integer numberOfTimesKicked = 0;

    @Column(nullable = false)
    private Integer numberOfCampaigns = 0;

    @Column(nullable = false)
    private Integer highestLevel = 0;

    @Column(length = 255)
    private String favouriteClass;
}
