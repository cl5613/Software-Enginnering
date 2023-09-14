package com.webcheckers.ui;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.webcheckers.application.GameCenter;
import com.webcheckers.model.Game;
import com.webcheckers.model.Message;
import com.webcheckers.model.Player;

import spark.Request;
import spark.Response;
import spark.Route;

public class PostBackupMove implements Route{

    private GameCenter gameCenter;
    private Message message;

    public PostBackupMove(GameCenter gameCenter){
        this.gameCenter=gameCenter;
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        Player player= request.session().attribute("user");
        Game game= gameCenter.getGameFromPlayer(player);
        Boolean alreadyMoved= game.backupMove();
        if(alreadyMoved){
            message= Message.info("Backup Move");
        }else{
            message= Message.error("Unable to Backup");
        }
        String json;
        Gson gson= new GsonBuilder().create();
        json= gson.toJson(message);
        return json;
    }
    
}
