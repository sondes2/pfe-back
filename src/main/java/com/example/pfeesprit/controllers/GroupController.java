package com.example.pfeesprit.controllers;

import com.example.pfeesprit.entities.Groupe;
import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.services.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Group")

public class GroupController {
    @Autowired
    IGroupService iGroupservice;


    @GetMapping("/findall")
    public List<Groupe> getAllGroups() {
        return iGroupservice.getAllGroup();

    }

  // @PreAuthorize("hasAuthority('Admin')")
    @GetMapping("/Groupbyid/{idGroup}")
    public Groupe getGroupById(@PathVariable("idGroup") Long idGroup) {
        return iGroupservice.findById(idGroup);
    }

    @PostMapping("/AddGroup")
    // @ResponseBody
    public Groupe addGroup(@RequestBody Groupe groupe) {
        return iGroupservice.addgroup(groupe);

    }


    @PutMapping("/UpdateGroup")
    @ResponseBody
    public Groupe updateGroup(@RequestBody Groupe groupe) {
        return iGroupservice.editgroup(groupe);
    }


    @DeleteMapping("/deleteGroupById/{groupId}")
    public void deleteGroupById(@PathVariable("groupId") Long groupId) {
        iGroupservice.deletegroup(groupId);
    }

    @PutMapping("affectUsers/{groupId}")
    public void affectUsers(@RequestBody List<User> users, @PathVariable Long groupId) {
         iGroupservice.affectUsers(users, groupId);
    }

}
