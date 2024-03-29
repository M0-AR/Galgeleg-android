package com.example.galgeleg.version_01;

import com.example.galgeleg.version_01.activity.*;
import com.example.galgeleg.version_01.state_player.ActionState;
import com.example.galgeleg.version_01.state_player.DeathState;
import com.example.galgeleg.version_01.state_player.PlayerState;
import com.example.galgeleg.version_01.state_player.SurvivalState;

import java.util.ArrayList;
import java.util.HashSet;

public class Galgelogik {
    private static Galgelogik instance;
    private PlayerState currentPlayerState;
    public static GameActivity ui;
    public HashSet<String> mCorrectLettersTheUserUsed;
    public HashSet<String> mWrongLettersTheUserUsed;


    /** AHT afprøvning er muligeOrd synlig på pakkeniveau */
    public ArrayList<String> muligeOrd = new ArrayList<String>();
    private String ordet;
    private ArrayList<String> brugteBogstaver = new ArrayList<String>();
    private String synligtOrd;
    private int antalForkerteBogstaver;
    private boolean sidsteBogstavVarKorrekt;
    private boolean spilletErVundet;
    private boolean spilletErTabt;
    private int antalForsøg;
    private String playerName;

    public static Galgelogik getInstance(GameActivity gameActivity) {
        if (instance == null) instance = new Galgelogik(gameActivity);
        return instance;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getAntalForsøg() {
        return antalForsøg;
    }

    private Galgelogik(GameActivity context) {
        ui = context;
    }


    public ArrayList<String> getBrugteBogstaver() {
        return brugteBogstaver;
    }

    public String getSynligtOrd() {
        return synligtOrd;
    }

    public String getOrdet() {
        return ordet;
    }

    public int getAntalForkerteBogstaver() {
        return antalForkerteBogstaver;
    }

    public boolean erSidsteBogstavKorrekt() {
        return sidsteBogstavVarKorrekt;
    }

    public void erSpilletVundet() {
        if (spilletErVundet)
            setState(new SurvivalState());
        currentPlayerState.action(this);
    }

    public void erSpilletTabt() {
        if (spilletErTabt)
            setState(new DeathState());
        currentPlayerState.action(this);
    }

    public boolean erSpilletSlut() {
        return spilletErTabt || spilletErVundet;
    }


    public void startNytSpil(String playerName, String word) {
        setState(new ActionState());
        this.playerName = playerName;
        brugteBogstaver.clear();
        antalForkerteBogstaver = 0;
        antalForsøg = 0;
        mCorrectLettersTheUserUsed = new HashSet<>();
        mWrongLettersTheUserUsed = new HashSet<>();
        spilletErVundet = false;
        spilletErTabt = false;
        ordet = word;
        opdaterSynligtOrd();
    }


    private void opdaterSynligtOrd() {
        synligtOrd = "";
        spilletErVundet = true;
        for (int n = 0; n < ordet.length(); n++) {
            String bogstav = ordet.substring(n, n + 1);
            if (brugteBogstaver.contains(bogstav)) {
                synligtOrd = synligtOrd + bogstav;
            } else {
                synligtOrd = synligtOrd + "*";
                spilletErVundet = false;
            }
        }
    }

    public void gætBogstav(String bogstav) {
        antalForsøg++;
        if (bogstav.length() != 1) return;
        System.out.println("Der gættes på bogstavet: " + bogstav);
        if (brugteBogstaver.contains(bogstav)) return;
        if (spilletErVundet || spilletErTabt) return;

        brugteBogstaver.add(bogstav);

        if (ordet.contains(bogstav)) {
            sidsteBogstavVarKorrekt = true;
            System.out.println("Bogstavet var korrekt: " + bogstav);
        } else {
            // Vi gættede på et bogstav der ikke var i ordet.
            sidsteBogstavVarKorrekt = false;
            System.out.println("Bogstavet var IKKE korrekt: " + bogstav);
            antalForkerteBogstaver = antalForkerteBogstaver + 1;
            if (antalForkerteBogstaver > 6) {
                spilletErTabt = true;
            }
        }
        opdaterSynligtOrd();
    }

    public void logStatus() {
        System.out.println("---------- ");
        System.out.println("- ordet (skult) = " + ordet);
        System.out.println("- synligtOrd = " + synligtOrd);
        System.out.println("- forkerteBogstaver = " + antalForkerteBogstaver);
        System.out.println("- brugeBogstaver = " + brugteBogstaver);
        if (spilletErTabt) System.out.println("- SPILLET ER TABT");
        if (spilletErVundet) System.out.println("- SPILLET ER VUNDET");
        System.out.println("---------- ");
    }

    public void setState(PlayerState playerState) {
       currentPlayerState = playerState;
    }


}
