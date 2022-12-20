package com.app.educator.controller;

import com.app.educator.dto.UserDto;
import com.app.educator.dto.UserProj;
import com.app.educator.entity.User;
import com.app.educator.service.UserService;
import com.app.educator.util.PageSettings;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("user/")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("createUser")
    public ResponseEntity<User> saveUser(@RequestBody User user){
        User save =  userService.createUser(user);
        return ResponseEntity.ok(save);
    }

    @GetMapping("users")
    public ResponseEntity<List<UserDto>> getAll(){
        List<UserDto> users = userService.getAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<User> user(@PathVariable("id") Long id){
        User getUser = userService.getUser(id);
        return ResponseEntity.ok(getUser);
    }

    @PostMapping("editUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody User user){
        User editUser = userService.updateUser(user, id);
        return ResponseEntity.ok(editUser);
    }

    @DeleteMapping("deleteUser/{id}")
    public ResponseEntity<Boolean> deleteUser(@PathVariable("id") Long id){
        Boolean delUser = userService.deleteUser(id);
        return ResponseEntity.ok(delUser);
    }

    @GetMapping("pagination")
    public ResponseEntity<Page<UserProj>> paginationUser(PageSettings pageSettings){
        Page<UserProj> userDtos = userService.pagination(pageSettings.getPage(), pageSettings.getElementPerPage());
        return ResponseEntity.ok(userDtos);
    }
}
