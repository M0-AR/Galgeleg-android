package com.example.galgeleg.version_01.state_player;

import com.example.galgeleg.version_01.Galgelogik;
// https://stacktips.com/tutorials/design-patterns/state-design-pattern-in-java
public interface PlayerState {
    void action(Galgelogik galgelogik);
}
