package com.example.galgeleg;

public interface GalgeState {
    void start_state(Galgelogik context);
    void play_state(Galgelogik context);
    void win_state(Galgelogik context);
    void lose_state(Galgelogik context);
    void display_result_state(Galgelogik context);
}
