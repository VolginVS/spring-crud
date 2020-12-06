package ru.volginvs.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.volginvs.crud.model.User;
import ru.volginvs.crud.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "users")
    public String printUserList(Model model, User user) {
        List<User> userList = userService.getUserList();
        model.addAttribute("userList", userList);
        return "users";
    }

    @PostMapping(value ="user-create")
    public String createUser(User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping(value = "user-edit/{id}")
    public String getUserEditPage(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @PostMapping(value = "user-edit")
    public String editUser(User user) {
        userService.update(user);
        return "redirect:/users";
    }

    @GetMapping(value = "user-delete/{id}")
    public String editUser(@PathVariable("id") Long id) {
        userService.removeById(id);
        return "redirect:/users";
    }
}
