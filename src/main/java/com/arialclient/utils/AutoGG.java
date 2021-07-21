package com.arialclient.utils;

import com.arialclient.event.EventTarget;
import com.arialclient.event.implement.EventChatRecieved;
import com.arialclient.mods.ModInstances;
import net.minecraft.client.Minecraft;
import net.minecraft.util.IChatComponent;

import java.util.Arrays;

public class AutoGG {

    public static final AutoGG INSTANCE = new AutoGG();

    private long lastTrigger;

    @EventTarget
    public void onChat(EventChatRecieved e) {
        IChatComponent message = e.getChatComponent();
        if (ModInstances.getModAutoGG().isEnabled()) {
            if (Minecraft.getMinecraft().getCurrentServerData() != null && Minecraft.getMinecraft().getCurrentServerData().serverIP != null) {
                if (System.currentTimeMillis() > lastTrigger + 1000L && Arrays.asList(getHypixelTrigger().split("\n")).stream().anyMatch(trigger -> message.getUnformattedText().contains(trigger))) {
                    Minecraft.getMinecraft().thePlayer.sendChatMessage("ggs");
                    Minecraft.getMinecraft().ingameGUI.getChatGUI().addToSentMessages("ggs");
                    lastTrigger = System.currentTimeMillis();
                }
            }
        }
    }

    public static String getHypixelTrigger()
    {
        return "1st Killer - \n" +
                "1st Place - \n" +
                "Winner: \n" +
                " - Damage Dealt - \n" +
                "Winning Team -\n" +
                "1st - \n" +
                "Winners: \n" +
                "Winner: \n" +
                "Winning Team: \n" +
                " won the game!\n" +
                "Top Seeker: \n" +
                "1st Place: \n" +
                "Last team standing!\n" +
                "Winner #1 (\n" +
                "Top Survivors\n" +
                "Winners - \n" +
                "Sumo Duel - \n";
    }

}
