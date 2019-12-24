package nl.ycn.coaching.controller;

import nl.ycn.coaching.database.HrService;
import nl.ycn.coaching.database.SoftskillRepository;
import nl.ycn.coaching.model.Softskill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class HrController {

    private HrService hrService;

    @Autowired
    private SoftskillRepository softskillRepository;

    private List<Softskill> retrieveSoftskillList() {
        return softskillRepository.findAll();
    }

    @GetMapping("teams")
    public String teams() {
        return "/hremployee/teams";
    }

    @GetMapping("users")
    public String users() {
        return "/hremployee/users";
    }

    @GetMapping("bootcamps")
    public String bootcamps() {
        return "/hremployee/bootcamps";
    }

    @GetMapping("skills")
    public String listskills(Model model) {
        model.addAttribute("softskillList", retrieveSoftskillList());

        return "/hremployee/skills";
    }

    @GetMapping("calendar")
    public String calendar() {
        return "/hremployee/calendar";
    }

    @GetMapping("createsoftskillform")
    public String getaddsoftskillpage() {
        return "/hremployee/createsoftskillform";
    }

    @Autowired
    public HrController(HrService hrService) {
        this.hrService = hrService;
    }

    @PostMapping("/createsoftskill")
    public String createSoftskill(String name, String description) {
        hrService.addSoftskill(name, description);
        return "/hremployee/skills";
    }
}
