package nl.ycn.coaching.database;

import nl.ycn.coaching.model.Bootcamp;
import nl.ycn.coaching.model.Softskill;
import nl.ycn.coaching.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HrService {

    @Autowired
    private BootcampRepository bootcampRepository;
    @Autowired
    private BootcampService bootcampService;
    @Autowired
    private SoftskillRepository softskillRepository;


    public void addSoftskill(
            String name,
            String description){
        Softskill softskill = new Softskill(name, description);
        softskillRepository.save(softskill);
    }

    //retreive top 'length' bootcamps from the repository and return a list with the top 'length' bootcamps.
    public List<Bootcamp> getTopActiveBootcamps(int length){
        Page<Bootcamp> topBootcamps = bootcampRepository.findAllByStatus(true, PageRequest.of(0,length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
    }

    public List<Bootcamp> getTopFinishedBootcamps(int length){
        Page<Bootcamp> topBootcamps = bootcampRepository.findAllByStatus(false, PageRequest.of(0,length, Sort.by("endDate").descending()));
        return topBootcamps.getContent();
    }

}
