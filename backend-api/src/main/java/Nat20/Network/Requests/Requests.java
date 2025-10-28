package Nat20.Network.requests;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import Nat20.Network.players.*;
import Nat20.Network.campaign.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "requests")

public class Requests {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id", nullable = false)
    @JsonIgnoreProperties("requests")
    private Player player;

    @ManyToOne
    @JoinColumn(name = "campaign_id", nullable = false)
    @JsonIgnoreProperties({"requests"})
    private Campaign campaign;

    @NotNull
    @Enumerated(EnumType.STRING)
    private RequestType type;

    @NotNull
    private boolean active = true;
}

enum RequestType {
    ONE_TIME 
}

