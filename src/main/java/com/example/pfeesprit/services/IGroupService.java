package com.example.pfeesprit.services;

import com.example.pfeesprit.entities.Groupe;
import com.example.pfeesprit.entities.User;

import java.util.List;

public interface IGroupService {
    public List<Groupe> getAllGroup();

    public Groupe addgroup(Groupe groupe);

    public Groupe editgroup(Groupe groupe);

    public void deletegroup(Long id);

    public Groupe findById(Long id);


}
