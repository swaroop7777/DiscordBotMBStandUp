package com.suvam.discord_Stand_up_bot.task;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

import java.util.*;


public class StandUpScheduler extends TimerTask {
    private final JDA jda;
    public static Map<String, GuildMember> membersMap;

    public StandUpScheduler(JDA jda) {
        this.jda = jda;
    }

    @Override
    public void run() {
        String botName = "checkBot";
        membersMap = new HashMap<>();
        List<User> user = jda.getUsers();
        Iterator<User> userIterator = user.iterator();
        while (userIterator.hasNext()) {
            User guildMember = userIterator.next();
            String memberName = guildMember.getName();
            if (memberName.equals(botName)) {
                continue;
            } else {
                membersMap.put(memberName, new GuildMember(guildMember));
            }
        }
    }
}
