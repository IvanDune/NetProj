package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.domain.dnd.characters.Character;
import com.example.servingwebcontent.domain.dnd.characters.Race;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepos extends JpaRepository<Character, Long> {
    Character findByName(String name);

    Race findById(ID id);

}
