package com.example.galgeleg.state_player;

import com.example.galgeleg.Galgelogik;
// https://stacktips.com/tutorials/design-patterns/state-design-pattern-in-java
public interface PlayerState {
    void action(Galgelogik galgelogik);
}
