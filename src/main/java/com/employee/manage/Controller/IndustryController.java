package com.employee.manage.Controller;

import com.employee.manage.Model.IndustryConf;
import com.employee.manage.Model.response.CreateOrUpdateIndustryResponse;
import com.employee.manage.Service.IndustryConfService;
import com.employee.manage.mapper.IndustryMapper;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
@Controller
@AllArgsConstructor
public class IndustryController {

    private final IndustryConfService industryService;
    private final IndustryMapper industryMapper;
    @GetMapping("/industry")
    public String showThis( Model model) {
        IndustryConf industry = industryService.getIndustryInformation();
        model.addAttribute("industry", industry);
        return "industry_info";
    }
    @GetMapping("/industry/{id}")
    public String showEditPage(@PathVariable(name = "id") long id, Model model) {
        IndustryConf industry = industryService.getThis(id);
        model.addAttribute("industry", industry);
        return "edit_industry";
    }
    @PostMapping("/update-industry")
    public String updateCompany(
            HttpSession session,
            @PathVariable(name = "id") long id,
            @ModelAttribute("updateIndustry") IndustryConf industryConf,
            @RequestParam("logo") MultipartFile logo
    ) throws IOException {
        industryService.update(id,industryConf);
        return "redirect:/industry";
    }
}
