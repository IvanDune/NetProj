package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Weapon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeaponRepos extends JpaRepository<Weapon, Long> {
    Weapon findByName(String name);
}
