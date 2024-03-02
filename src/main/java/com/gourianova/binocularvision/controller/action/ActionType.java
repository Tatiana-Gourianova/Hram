package com.gourianova.binocularvision.controller.action;


public enum ActionType {

    CHANGELOCALE(new ChangeLocaleAction());

    Action action;

    Action getAction() {
        return action;
    }

    ActionType(Action action) {
        this.action = action;
    }

}
