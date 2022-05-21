package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.domain.dnd.characters.DHNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NumberRepos extends JpaRepository<DHNumber, Long> {

}
