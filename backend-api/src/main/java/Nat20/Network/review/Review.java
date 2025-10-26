package Nat20.Network.review;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
@Table(name = "reviews")
public class Review {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnoreProperties({"reviews", "subscriptions"})
    private Player player;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonIgnoreProperties({"reviews", "players", "gameMaster"})
    private Campaign campaign;

    @NotNull
    @Min(1)
    @Max(5)
    private Double freshnessRating;

    @NotNull
    @Min(1)
    @Max(5)
    private Double deliveryRating;

    @Min(1)
    @Max(5)
    private Double overallRating;

    @Column(columnDefinition = "TEXT")
    private String comment;

    @NotNull
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(columnDefinition = "TEXT")
    private String dmResponse;

    private LocalDateTime dmResponseDate;


}