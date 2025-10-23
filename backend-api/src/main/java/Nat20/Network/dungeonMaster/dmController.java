package Nat20.Network.dungeonMaster;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/DMs")
@RequiredArgsConstructor
public class DMController {
    private final DMService dmService;

    @PostMapping
    public ResponseEntity<DM> createDm(@Valid @RequestBody DM dm) {
        return ResponseEntity.ok(dmService.createDM(dm));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DM> updateDm(@PathVariable Long id, @Valid @RequestBody DM dmDetails) {
        return ResponseEntity.ok(dmService.updateDM(id, dmDetails));
    }

    @GetMapping("/{id}")
    public ResponseEntity<DM> getDm(@PathVariable Long id) {
        return ResponseEntity.ok(dmService.getDMById(id));
    }
}
