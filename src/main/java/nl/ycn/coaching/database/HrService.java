package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Softskill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HrService {

    @Autowired
    private SoftskillRepository softskillRepository;

    public void addSoftskill(
            String name,
            String description){
        Softskill softskill = new Softskill(name, description);
        softskillRepository.save(softskill);
    }
}
