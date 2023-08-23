package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepos extends JpaRepository<Equipment, Long> {
    Equipment findByName(String name);
}
