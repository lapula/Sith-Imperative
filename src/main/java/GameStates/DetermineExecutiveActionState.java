/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameStates;

import GameLogic.Game;

/**
 *
 * @author pulli
 */
public class DetermineExecutiveActionState implements GameState {
    
    Game game;
    
    public DetermineExecutiveActionState(Game game) {
        this.game = game;
    }

    @Override
    public void doAction() {
        
        int gamePlayers = game.getVariables().getGamePlayers();
        int fascistPolicies = game.getVariables().getFascistPolicyCount();
        
        if (fascistPolicies >= 4) {
            game.changeState(State.EXECUTION);
        } else if (fascistPolicies == 3) {
            if (gamePlayers > 3) { //6
                game.changeState(State.CALL_SPECIAL_ELECTION);
            } else {
                game.changeState(State.POLICY_PEEK);
            }
        } else if (fascistPolicies == 2) {
            if (gamePlayers > 3) { //6
                game.changeState(State.INVESTIGATE_LOYALTY);
            } else {
                game.changeState(State.ROUND_START);
            }
        } else if (fascistPolicies == 1) {
            if (gamePlayers > 3) {//8
                game.changeState(State.INVESTIGATE_LOYALTY);
            } else {
                game.changeState(State.ROUND_START);
            }
        } else {
            game.changeState(State.ROUND_START);
        }
        
    }

    @Override
    public void receiveData(String player, String data) {
        return;
    }
}