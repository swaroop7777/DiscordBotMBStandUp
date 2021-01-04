package com.suvam.discord_Stand_up_bot.task;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.util.Map;
import java.util.TimerTask;

public class Attendence extends TimerTask {
    private final JDA jda;

    public Attendence(JDA jda) {
        this.jda = jda;
    }

    @Override
    public void run() {
        Map<String, GuildMember> guildMembers = StandUpScheduler.membersMap; //StandUpScheduler chage 7
        TextChannel channel = jda.getGuildsByName("suvBot", true).get(0).getTextChannelsByName("general", true).get(0);
        EmbedBuilder embed = new EmbedBuilder();
        String absentMembers = "- ";

        for (Map.Entry<String, GuildMember> entry : guildMembers.entrySet()) {
            int numberOfAnswer = entry.getValue().questionsAnswered;
            if (numberOfAnswer == 0) {
                absentMembers += entry.getKey() + " , ";
            }
        }
        embed.addField("Members who are absent for todays standup ", absentMembers, true);
        embed.setColor(Color.RED);
        channel.sendMessage(embed.build()).queue();
    }
}
