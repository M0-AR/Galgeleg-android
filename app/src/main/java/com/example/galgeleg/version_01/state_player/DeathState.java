package com.example.galgeleg.version_01.state_player;

import com.example.galgeleg.version_01.Galgelogik;
import com.example.galgeleg.version_01.adapter.PlayerStateAdapter;

public class DeathState extends PlayerStateAdapter {
    @Override
    public void action(Galgelogik galgelogik) {
        galgelogik.ui.dead();
    }
}
