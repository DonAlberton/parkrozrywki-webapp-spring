package com.parkrozrywki.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Configuration
@Controller
public class AppController implements WebMvcConfigurer {
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/main").setViewName("main");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/main_admin").setViewName("admin/main_admin");
        registry.addViewController("/main_user").setViewName("user/main_user");

        registry.addViewController("/klienci").setViewName("klienci");
        registry.addViewController("/new-klient").setViewName("new-klient");
        registry.addViewController("/edit/{id_klienta}").setViewName("edit-form");
        //"/edit/{id}"
        //registry.addViewController("/save").setViewName("save");

    }

    @Controller
    public class DashboardController
    {
        @RequestMapping
                ("/main"
                )
        public String defaultAfterLogin
                (HttpServletRequest request) {
            if
            (request.isUserInRole
                    ("ADMIN")) {
                return "redirect:/main_admin";
            }
            else if
            (request.isUserInRole
                            ("USER")) {
                return "redirect:/main_user";
            }
            else
            {
                return "redirect:/index";
            }
        }
    }


    @Autowired
    private KlientDAO dao;
    //private static final Logger LOGGER = Logger.getLogger(AppController.class.getName());

    @RequestMapping("/klienci")
    public String showKlienciPage(Model model){
        List<Klient> listaKlientow = dao.list();
        model.addAttribute("listaKlientow", listaKlientow);

        return "klienci";
    }
    @RequestMapping("/new-klient")
    public String showNewForm(Model model){
        Klient klient = new Klient();
        model.addAttribute("klient", klient);

        return "new-klient";
    }
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("klient") Klient klient){
        dao.save(klient);
        return "redirect:/";
    }
    @RequestMapping("/edit/{id_klienta}")
    public ModelAndView showEditForm(@PathVariable(name="id_klienta") int id){
        ModelAndView mav = new ModelAndView("edit-form");
        Klient klient = dao.get(id);
        mav.addObject("klient", klient);

        return mav;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute("klient") Klient klient){
        dao.update(klient);
        return "redirect:/";
    }

    @RequestMapping(value={"/main_admin"})
    public String showAdminPage(Model model) {
        return "admin/main_admin";
    }
    @RequestMapping(value={"/main_user"})
    public String showUserPage(Model model) {
        return "user/main_user";
    }
}
