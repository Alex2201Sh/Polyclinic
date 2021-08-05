package by.it_academy.polyclinic.controller;

import by.it_academy.polyclinic.model.enumeration.InfoType;
import by.it_academy.polyclinic.repositories.InformationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    private InformationRepository informationRepository;

    public MainController(InformationRepository informationRepository) {
        this.informationRepository = informationRepository;
    }

    @GetMapping("/")
    public String greeting(Model model) {
        return "greeting";
    }

    @GetMapping("/info")
    public String infoPage(Model model) {
        model.addAttribute("informations", informationRepository.findByInfoType(InfoType.POLYCLINIC_INFO));
        return "infoAndNews";
    }

    @GetMapping("/news")
    public String newsPage(Model model) {
        model.addAttribute("informations", informationRepository.findByInfoType(InfoType.NEWS));
        return "infoAndNews";
    }

    @GetMapping("/useful")
    public String usefulInfoPage(Model model) {
        model.addAttribute("informations", informationRepository.findByInfoType(InfoType.USEFUL_INFO));
        return "infoAndNews";
    }

//    @PreAuthorize("hasAuthority('ADMIN')")
//    @PostMapping("/main")
//    public String add(@RequestParam String text,
//                      @RequestParam String tag, Model model) {
//        model.addAttribute("text", text);
//        model.addAttribute("tag", tag);
//        informationRepository.save(new Information(text, tag));
//        return "main";
//    }
}