package com.fedin.services;

import com.fedin.annotations.InjectByType;
import com.fedin.entities.Room;
import com.fedin.interfaces.Announcer;
import com.fedin.interfaces.Policeman;

public class CoronaDisinfector {

    @InjectByType
    private Announcer announcer;

    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию");
        policeman.makePeopleLeaveRoom();
        disinfect(room);
        announcer.announce("Можете зайти обратно");
    }

    private void disinfect(Room room) {

        System.out.println("Комната дезинфицируется");


    }
}
