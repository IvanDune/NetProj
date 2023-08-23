package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.ChaClass;
import com.example.servingwebcontent.dto.dnd.characters.Race;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChaClassRepos extends JpaRepository<ChaClass, Long> {
    ChaClass findByName(String name);

    Race findById(ID id);

}
