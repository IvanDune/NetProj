package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.domain.dnd.characters.ChaClass;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChaClassRepos extends JpaRepository<ChaClass, Long> {
    ChaClass findByName(String name);
}
