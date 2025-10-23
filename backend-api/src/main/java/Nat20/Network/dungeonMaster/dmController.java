package Nat20Network.Network.dungeonMaster;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/DMs")
@RequiredArgsConstructor
public class dmController {
    private final dmService dmService;

    @PostMapping
    public ResponseEntity<dm> createDm(@Valid @RequestBody dm dm) {
        return ResponseEntity.ok(dmService.createDm(dm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<dm> updateDm(@PathVariable Long id, @Valid @RequestBody dm dmDetails) {
        return ResponseEntity.ok(dmService.updateDm(id, dmDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<dm> getDm(@PathVariable Long id) {
        return ResponseEntity.ok(dmService.getDMById(id));
    }
}
