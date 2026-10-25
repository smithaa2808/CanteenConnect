
package com.canteenconnect.canteenconnect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AuthController {

    // Open Student Login Page
    @GetMapping("/login/student")
    public String studentLoginPage() {
        return "student-login";
    }

    // Open Teacher Login Page
    @GetMapping("/login/teacher")
    public String teacherLoginPage() {
        return "teacher-login";
    }

    // Process Student Login
    @PostMapping("/login/student")
    public String studentLogin(
            @RequestParam("studentId") String studentId,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {

        if ("2808".equals(studentId)
                && "student123".equals(password)) {
            return "redirect:/menu";
        }

        redirectAttributes.addFlashAttribute(
                "error", "Invalid Student ID or Password");

        return "redirect:/login/student";
    }

    // Process Teacher Login
    @PostMapping("/login/teacher")
    public String teacherLogin(
            @RequestParam("userId") String userId,
            @RequestParam("password") String password,
            RedirectAttributes redirectAttributes) {

        if ("teacher123".equals(userId)
                && "teacher123".equals(password)) {
            return "redirect:/teacher-dashboard";
        }

        redirectAttributes.addFlashAttribute(
                "error", "Invalid Teacher ID or Password");

        return "redirect:/login/teacher";
    }
}
