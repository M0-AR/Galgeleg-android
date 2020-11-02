package com.example.galgeleg.state_player;

import com.example.galgeleg.Galgelogik;
import com.example.galgeleg.adapter.PlayerStateAdapter;

public class DeathState extends PlayerStateAdapter {
    @Override
    public void action(Galgelogik galgelogik) {
        galgelogik.ui.dead();
    }
}
