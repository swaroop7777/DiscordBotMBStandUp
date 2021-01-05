package com.suvam.discord_Stand_up_bot.task;


import com.suvam.discord_Stand_up_bot.util.InsertQuestions;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.User;

import java.util.*;


public class StandUpScheduler extends TimerTask {
    private final JDA jda;
    public static Map<String, GuildMember> membersMap;
    private final List<Integer> allowedDays;

    String BOT_NAME = "standup-bot";

    public StandUpScheduler(JDA jda) {
        this.jda = jda;
        this.allowedDays=new ArrayList<>();
        this.allowedDays.add(1);
        this.allowedDays.add(2);
        this.allowedDays.add(3);
        this.allowedDays.add(4);
        this.allowedDays.add(5);
        this.allowedDays.add(6);
    }

    @Override
    public void run() {
        Calendar calendar = Calendar.getInstance();
        Integer todaysDay = calendar.get(Calendar.DAY_OF_WEEK);
        if (allowedDays.contains(todaysDay)) {
            InsertQuestions.insert();
            membersMap = new HashMap<>();
            List<User> user = jda.getUsers();
            Iterator<User> userIterator = user.iterator();
            while (userIterator.hasNext()) {
                User guildMember = userIterator.next();
                String memberName = guildMember.getName();
                if (memberName.equals(BOT_NAME)) {
                    continue;
                } else {
                    membersMap.put(memberName, new GuildMember(guildMember));
                }
            }
        }
    }
}
