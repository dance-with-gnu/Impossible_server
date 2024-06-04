package dance.withgnu.demo.user.service;

import dance.withgnu.demo.user.entity.Pose;
import dance.withgnu.demo.user.repository.PoseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PoseService {

    private final PoseRepository poseRepository;

    @Autowired
    public PoseService(PoseRepository poseRepository) {
        this.poseRepository = poseRepository;
    }

    public List<Pose> getAllPoses() {
        return poseRepository.findAll();
    }
}
