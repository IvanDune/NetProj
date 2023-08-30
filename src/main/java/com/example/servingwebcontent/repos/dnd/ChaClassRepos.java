package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.ChaClass;
import com.example.servingwebcontent.dto.dnd.characters.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface ChaClassRepos extends JpaRepository<ChaClass, Long> {
    ChaClass findByName(String name);

    Race findById(Event.ID id);

}
