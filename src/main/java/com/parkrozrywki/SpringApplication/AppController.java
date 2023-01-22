package com.parkrozrywki.SpringApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
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

        registry.addViewController("/klienci").setViewName("admin/klienci");
        registry.addViewController("/new-klient").setViewName("new-klient");
        registry.addViewController("/edit/{id}").setViewName("user/edit-form");
        registry.addViewController("/save").setViewName("save");

        registry.addViewController("/wybor-atrakcji").setViewName("user/wybor-atrakcji");
        registry.addViewController("/profile").setViewName("user/profile");


        registry.addViewController("/atrakcje").setViewName("admin/atrakcje");
        registry.addViewController("/nowa-atrakcja").setViewName("admin/nowa-atrakcja");
        registry.addViewController("/edytuj-atrakcje/{id}").setViewName("admin/edytuj-atrakcje");
        registry.addViewController("/edit-klient/{id}").setViewName("admin/edit-form");
        registry.addViewController("/new-klient").setViewName("admin/new-klient");
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
    private AtrakcjeDAO atrakcjeDao;

    @RequestMapping("/wybor-atrakcji")
    public String showAtrakcje(Model model){
        List<Atrakcje> listaAtrakcji = atrakcjeDao.list();
        model.addAttribute("listaAtrakcji", listaAtrakcji);

        return "user/wybor-atrakcji";
    }

    @RequestMapping("/nowa-atrakcja")
    public String showNowaAtrakcja(Model model){
        List<String> stanAtrakcji = Arrays.asList("Dzialajacy", "Niedzialajacy", "W trakcie budowy");
        model.addAttribute("stanAtrakcji", stanAtrakcji);

        Atrakcje atrakcja = new Atrakcje();

        int numerAtrakcji = atrakcjeDao.list().size() + 1;
        atrakcja.setId_atrakcji(numerAtrakcji);
        atrakcja.setWodna("0");
        atrakcja.setId_parku(1);

        model.addAttribute("atrakcja", atrakcja);

        return "admin/nowa-atrakcja";
    }

    @RequestMapping(value="/zapisz-atrakcje", method = RequestMethod.POST)
    public String zapiszAtrakcje(@ModelAttribute("atrakcja") Atrakcje atrakcja, @RequestParam("data_otwarcia") String data_otwarcia) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date data = formatter.parse(data_otwarcia);
        atrakcja.setData_otwarcia(data);
        atrakcjeDao.save(atrakcja);

        return "redirect:/atrakcje";
    }

    @RequestMapping("/usun-atrakcje/{id}")
    public String usunKlienta(@PathVariable(name = "id") int id){
        atrakcjeDao.delete(id);

        return "redirect:/atrakcje";
    }

    @RequestMapping("/edytuj-atrakcje/{id}")
    public ModelAndView edytujAtrakcje(@PathVariable(name = "id") int id){
        List<String> stanAtrakcji = Arrays.asList("Dzialajacy", "Niedzialajacy", "W trakcie budowy");

        ModelAndView mav = new ModelAndView("admin/edytuj-atrakcje");
        Atrakcje atrakcje = atrakcjeDao.get(id);
        mav.addObject("atrakcje", atrakcje);
        mav.addObject("stanAtrakcji", stanAtrakcji);

        return mav;
    }

    @RequestMapping("/atrakcje")
    public String showAtrakcjeAdmin(Model model){
        List<Atrakcje> listaAtrakcji = atrakcjeDao.list();
        model.addAttribute("listaAtrakcji", listaAtrakcji);

        return "admin/atrakcje";
    }

    @RequestMapping(value="/aktualizuj-atrakcje", method=RequestMethod.POST)
    public String aktualizacjajAtrakcji(@ModelAttribute("atrakcja") Atrakcje atrakcja){
        atrakcjeDao.update(atrakcja);
        return "redirect:/atrakcje";
    }


    @Autowired
    private KlientDAO dao;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private TransakcjeDAO transakcjeDAO;

    @RequestMapping("/profile")
    public String showProfile(Model model){
        String remoteUser = request.getRemoteUser();
        Klient klient = dao.getProfile(remoteUser);

        List<Transakcje> transakcje = transakcjeDAO.list(remoteUser);


        model.addAttribute("transakcje", transakcje);
        model.addAttribute("mojProfil", klient);

        return "user/profile";
    }
    @RequestMapping("/edit-klient/{id}")
    public ModelAndView showEditForm(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("admin/edit-form");
        Klient klient = dao.get(id);
        mav.addObject("klient", klient);

        return mav;
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView editUser(@PathVariable(name="id") int id){
        ModelAndView mav = new ModelAndView("user/edit-form");
        Klient klient = dao.get(id);
        mav.addObject("klient", klient);

        return mav;
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public String update(@ModelAttribute("klient") Klient klient){
        dao.update(klient);
        return "redirect:/profile";
    }
    @RequestMapping(value="/update-klient", method=RequestMethod.POST)
    public String updateKlient(@ModelAttribute("klient") Klient klient){
        dao.update(klient);
        return "redirect:/klienci";
    }

    @RequestMapping("/klienci")
    public String showKlienciPage(Model model){
        List<Klient> listaKlientow = dao.list();
        model.addAttribute("listaKlientow", listaKlientow);

        return "admin/klienci";
    }


    @RequestMapping("/new-klient")
    public String showNewForm(Model model){
        Klient klient = new Klient();
        model.addAttribute("klient", klient);

        return "admin/new-klient";
    }
    @RequestMapping(value="/save", method = RequestMethod.POST)
    public String save(@ModelAttribute("klient") Klient klient){
        dao.save(klient);
        return "redirect:/klienci";
    }

    @RequestMapping("/delete/{id}")
    public String deleteKlient(@PathVariable(name = "id") int id){
        dao.delete(id);

        return "redirect:/klienci";
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
