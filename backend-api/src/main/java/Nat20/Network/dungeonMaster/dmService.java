package Nat20Network.Network.dungeonMaster;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class dmService {
    private final dmRepository dmRepository;

    public dm createDm(dm dm) {
        if (dmRepository.existsByEmail(dm.getEmail())) {
            throw new IllegalStateException("Email already in use: " + dm.getEmail());
        }
        return dmRepository.save(dm);
    }

    public dm updateDm(Long id, dm dmDetails) {
        dm existingDm = dmRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DM not found with id: " + id));

        if (!existingDm.getEmail().equals(dmDetails.getEmail()) &&
                dmRepository.existsByEmail(dmDetails.getEmail())) {
            throw new IllegalStateException("Email already in use: " + dmDetails.getEmail());
        }
        existingDm.setUsername(dmDetails.getUsername());
        existingDm.setEmail(dmDetails.getEmail());
        // Update other fields as necessary

        return dmRepository.save(existingDm);
    }

    public dm getDMById(Long id) {
        return dmRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("DM not found with id: " + id));
    }

    public dm getDMByEmail(String email) {
        return dmRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException("DM not found with email: " + email));
    }
}
