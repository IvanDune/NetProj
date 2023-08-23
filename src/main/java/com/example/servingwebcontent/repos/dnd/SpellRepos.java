package com.example.servingwebcontent.repos.dnd;

import com.example.servingwebcontent.dto.dnd.characters.Spell;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellRepos extends JpaRepository<Spell, Long> {
    Spell findByName(String name);
}
