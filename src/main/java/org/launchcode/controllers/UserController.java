package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String displayAddUserForm() {
        return "add";
    }

    @PostMapping
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        if (!verify.equals(user.getPassword())) {
            model.addAttribute("error", "Passwords do not match");
            return "add";
        }
// add form submission handling code here
        UserData.add(user);
        model.addAttribute("username", user.getUsername());
        return "index";

    }
}
