package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.domain.dnd.characters.Race;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RaceRepos extends JpaRepository<Race, Long> {
    Race findByName(String name);
//    Race findById(ID id);
}
