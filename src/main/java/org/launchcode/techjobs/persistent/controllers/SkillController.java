package org.launchcode.techjobs.persistent.controllers;

import org.launchcode.techjobs.persistent.models.Employer;
import org.launchcode.techjobs.persistent.models.Skill;
import org.launchcode.techjobs.persistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("skill")
public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping
    public String displayListOfSkills(Model model){
        model.addAttribute("title", "Skills");
        model.addAttribute("skill", skillRepository.findAll());
        return "skill/index";
    }

    @GetMapping("add")
    public String displayAddSkillForm(Model model){
        model.addAttribute("title", "Add Skills");
        model.addAttribute(new Skill());
        return "skill/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Skill newSkill,
                                      Errors errors, Model model){
        if (errors.hasErrors()) {
            model.addAttribute("allSkills", skillRepository.findAll());
            return "skill/add";
        }

        skillRepository.save(newSkill);

        return "redirect:";

    }

    @GetMapping("view/{skillId}")
    public String displayViewEmployer(Model model, @PathVariable int skillId) {

        Optional optSkill = skillRepository.findById(skillId);
        if (optSkill.isPresent()) {
            Skill skill = (Skill) optSkill.get();
            model.addAttribute("skill", skill);
            return "skill/view";
        } else {
            return "redirect:../";
        }
    }
}
