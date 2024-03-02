package com.gourianova.binocularvision.controller;

import com.gourianova.binocularvision.exception.UserNotFoundException;
import com.gourianova.binocularvision.model.User;
import com.gourianova.binocularvision.repo.UserRepo;
import com.gourianova.binocularvision.service.UserService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/")
public class UserResourceController {
    //TODO только один контроллер, остальные команды (command как в news или action как в apptrainer)

    private static final AtomicInteger counter = new AtomicInteger();
    private UserService userService;


    @Setter
    @Getter
    private UserRepo userRepo;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView text() {
        return new ModelAndView("/views/jsp/user_register.jsp", "registration", new User());
    }

    @RequestMapping(value = "/views/jsp/UserResource", method = RequestMethod.POST)

    public String UserResource(@ModelAttribute("SpringWeb") User user,
                               ModelMap model) throws UserNotFoundException {
//TODO с новой сессии база со статусом USER пишется поверху?
        //               new User();
        model.addAttribute("first_name", user.getFirstname());
        model.addAttribute("last_name", user.getFirstname());
        model.addAttribute("login", user.getLogin());
        model.addAttribute("password", user.getPassword());
        model.addAttribute("balance", user.getBalance());
        user.setCreate_time(LocalDate.now());
        user.setRoleId(1);
        user.setId(counter.incrementAndGet());


        // textIn.setCreate_time(LocalDate.now());
        //textIn.setId(counter.incrementAndGet());

        //log.info(String.valueOf(textIn.getLanguage()));
        //   this.userService = new UserService(userRepo);
//    userRepo.save (user1);

        getUserRepo().save(user);
       /* try {
            this.userRepo= new UserRepo(userRepo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }*/


        return "well done!";
    }

  //  public void UserResource(UserService userService) {
   //     this.userService = userService;
    //}


    @GetMapping("all")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        User user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/delete{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Integer id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Bean
    CommandLineRunner commandLineRunner(UserRepo userRepo) {
        return args -> setUserRepo(userRepo);
    }
    }

