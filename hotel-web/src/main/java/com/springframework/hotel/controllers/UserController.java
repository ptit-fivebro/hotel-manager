package com.springframework.hotel.controllers;

import com.springframework.hotel.dto.LoginRequest;
import com.springframework.hotel.dto.RegisterRequest;
import com.springframework.hotel.dto.SearchRoomRequest;
import com.springframework.hotel.models.Customer;
import com.springframework.hotel.services.ICustomerService;
import com.springframework.hotel.validator.LoginValidator;
import com.springframework.hotel.validator.RegisterValidator;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class UserController {

    private final HttpSession session;
    private final ICustomerService customerService;

    public UserController(HttpSession session, ICustomerService customerService) {
        this.session = session;
        this.customerService = customerService;
    }

    @GetMapping({"login", "login.html"})
    public String login(Model model) {
        model.addAttribute("title", "Đăng nhập");
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    @PostMapping({"login", "login.html"})
    public String login(Model model, @ModelAttribute LoginRequest loginRequest,
                        BindingResult result, LoginValidator loginValidator) {
        //Thuc hien validator
        loginValidator.validate(loginRequest, result);
        if (result.hasErrors()) {
            return "login";
        }
        Optional<Customer> customer = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (!customer.isPresent()) {
            //Define code Error
            model.addAttribute("messsage", "Username or Password is wrong!");
            return "login";
        }
        session.setAttribute("usersession", customer.get());
        model.addAttribute("searchRoom", new SearchRoomRequest());
        return "index";
    }

    @GetMapping({"register", "register.html"})
    public String register(Model model) {
        model.addAttribute("title", "Đăng ký tài khoản");
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping({"register", "register.html"})
    public String register(Model model, @ModelAttribute RegisterRequest registerRequest,
                           BindingResult result, RegisterValidator registerValidator) {
        registerValidator.validate(registerRequest, result);
        if (result.hasErrors()) {
            return "register";
        }
        Customer customer = new Customer();
        BeanUtils.copyProperties(registerRequest, customer);
        if (customer.equals(null)) {
            return "register";
        }
        customerService.register(customer);
        return "successRegister";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        model.addAttribute("loginRequest", new LoginRequest());
        model.addAttribute("searchRoom", new SearchRoomRequest());
        session.invalidate();
        return "index";
    }
}
