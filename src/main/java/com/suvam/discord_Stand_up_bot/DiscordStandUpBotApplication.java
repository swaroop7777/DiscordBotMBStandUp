package com.suvam.discord_Stand_up_bot;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.ChunkingFilter;
import net.dv8tion.jda.api.utils.MemberCachePolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.security.auth.login.LoginException;
import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
public class DiscordStandUpBotApplication {

	public static void main(String[] args) throws LoginException, InterruptedException {
		SpringApplication.run(DiscordStandUpBotApplication.class, args);

		String token = "NzkzNDM1NzY2OTY0ODc5Mzgw.X-sOpA.ZalSCiNH_zP84AaChlySmdiaZQg"; //NzkzNTAyNjUyMTMwMjYzMDkx.X-tM7g.sAvgj6tObemT8Sdi5rlXzBOfG2g
		JDA jda = JDABuilder.createDefault(token).setChunkingFilter(ChunkingFilter.ALL)
				.setMemberCachePolicy(MemberCachePolicy.ALL).enableIntents(GatewayIntent.GUILD_MEMBERS)
				.setActivity(Activity.watching("morning standup"))
				.addEventListeners(new com.suvam.discord_Stand_up_bot.event.UserRepliedEvent())
				.build().awaitReady();

		Timer timer = new Timer();

		TimerTask standUp = new com.suvam.discord_Stand_up_bot.task.StandUpScheduler(jda);
		TimerTask attendence = new com.suvam.discord_Stand_up_bot.task.Attendence(jda);

		timer.schedule(standUp, 0, 1000*24*60*60);
		timer.schedule(attendence, 80000,1000*24*60*60);
	}

}
