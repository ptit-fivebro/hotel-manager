package com.springframework.hotel.controllers;

import com.springframework.dto.LoginRequest;
import com.springframework.dto.RegisterRequest;
import com.springframework.hotel.dto.CustomerDTO;
import com.springframework.hotel.models.Customer;
import com.springframework.hotel.services.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class CustomerController {

    private final HttpSession session;
    private final ICustomerService customerService;

    public CustomerController(HttpSession session, ICustomerService customerService) {
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
    public String login(Model model, @ModelAttribute LoginRequest loginRequest) {
        Optional<CustomerDTO> customerDTO = customerService.login(loginRequest.getEmail(), loginRequest.getPassword());
        if (!customerDTO.isPresent()) {
            //Define code Error
            model.addAttribute("messsage", "Username or Password is wrong!");
            return "redirect:/login";
        }
        session.setAttribute("usersession", customerDTO.get());
        return "index";
    }

    @GetMapping({"register", "register.html"})
    public String register(Model model) {
        model.addAttribute("title", "Đăng ký tài khoản");
        model.addAttribute("registerRequest", new RegisterRequest());
        return "register";
    }

    @PostMapping({"register", "register.html"})
    public String register(Model model, @ModelAttribute RegisterRequest registerRequest) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(registerRequest, customer);
        if (customer.equals(null)) {
            return "register";
        }
        customerService.save(customer);
        return "successRegister";
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(ModelMap model) {
        session.invalidate();
        return "index";
    }
}
