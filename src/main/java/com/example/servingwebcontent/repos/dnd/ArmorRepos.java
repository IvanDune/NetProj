package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Armor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArmorRepos extends JpaRepository<Armor, Long> {
    Armor findByName(String name);
}
