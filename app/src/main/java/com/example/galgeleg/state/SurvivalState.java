package com.example.galgeleg.state;

import com.example.galgeleg.Galgelogik;
import com.example.galgeleg.adapter.PlayerStateAdapter;

public class SurvivalState extends PlayerStateAdapter {
    @Override
    public void action(Galgelogik galgelogik) {
        galgelogik.ui.survive();
    }
}
