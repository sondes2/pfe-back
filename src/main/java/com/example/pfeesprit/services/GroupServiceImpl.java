package com.example.pfeesprit.services;

import com.example.pfeesprit.entities.Groupe;
import com.example.pfeesprit.entities.User;
import com.example.pfeesprit.repositories.GroupRepository;
import com.example.pfeesprit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class GroupServiceImpl implements IGroupService{

    @Autowired
    GroupRepository groupRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public List<Groupe> getAllGroup() {
        return groupRepository.findAll();
    }

    @Override
    public Groupe addgroup(Groupe groupe) {
        return groupRepository.save(groupe);
    }

    @Override
    public Groupe editgroup(Groupe groupe) {
        return groupRepository.save(groupe);
    }

    @Override
    public void deletegroup(Long id) {
        groupRepository.deleteById(id);
    }

    public Groupe findById(Long id) {
        return groupRepository.findById(id).get();
    }

    @Override
    public void affectUsers(List<User> users, Long groupId) {
        Groupe g = groupRepository.findById(groupId).get();
        users.forEach(user -> user.setGroup(g));
        userRepository.saveAll(users);
    }
}
