package Nat20.Network.sysadmin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/sysadmin")
public class SysadminController {
    @Autowired
    private SysadminService sysadminService;

    @GetMapping("/reviews")
    public List<Review> getAllReviews() {
        return sysadminService.getAllReviews();
}

    @DeleteMapping("/reviews/{id}")
    public void deleteReview(@PathVariable Long id) {
        sysadminService.deleteReviewById(id);
    }

    @GetMapping("/dms")
    public List<DM> getAllDMs() {
        return sysadminService.getAllDMs();
    }

    @GetMapping("/players")
    public List<Player> getAllPlayers() {
        return sysadminService.getAllPlayers();
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable Long id, @RequestBody Player player) {
        return sysadminService.updatePlayer(id, player);
    }

    @DeleteMapping("/players/{id}")
    public void deletePlayer(@PathVariable Long id) {
        sysadminService.deletePlayerById(id);
    }

    @PutMapping("/dms/{id}")
    public DM updateDM(@PathVariable Long id, @RequestBody DM dm) {
        return sysadminService.updateDM(id, dm);
    }

    @DeleteMapping("/dms/{id}")
    public void deleteDM(@PathVariable Long id) {
        sysadminService.deleteDMById(id);
    }

    @GetMapping("/statistics")
    public List<Statistics> getAllStatistics() {
        return sysadminService.getAllStatistics();
    }

    @DeleteMapping("/services/{id}")
    public void deleteService(@PathVariable Long id) {
        sysadminService.deleteServiceById(id);
    }

}
