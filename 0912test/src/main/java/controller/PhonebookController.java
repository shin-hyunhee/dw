package controller;

import service.PhonebookService;
import vo.Phonebook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/phonebook")
public class PhonebookController {

    @Autowired
    private PhonebookService phonebookService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Phonebook> phonebooks = phonebookService.getAllPhonebooks();
        model.addAttribute("phonebooks", phonebooks);
        return "phonebook/list";
    }

    @PostMapping("/add")
    public String add(Phonebook phonebook) {
        phonebookService.addPhonebook(phonebook);
        return "redirect:/phonebook/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("search") String search, Model model) {
        List<Phonebook> phonebooks = phonebookService.searchPhonebooks(search);
        model.addAttribute("phonebooks", phonebooks);
        return "phonebook/search";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        Phonebook phonebook = phonebookService.getPhonebookById(id);
        model.addAttribute("phonebook", phonebook);
        return "phonebook/view";
    }

    @PostMapping("/update")
    public String update(Phonebook phonebook) {
        phonebookService.updatePhonebook(phonebook);
        return "redirect:/phonebook/list";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        phonebookService.deletePhonebook(id);
        return "redirect:/phonebook/list";
    }
}
