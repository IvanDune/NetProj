package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Characteristics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacteristicRepos extends JpaRepository<Characteristics, Long> {

}
