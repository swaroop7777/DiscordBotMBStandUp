package com.suvam.discord_Stand_up_bot.util;

import com.suvam.discord_Stand_up_bot.entity.StandUpQuestion;
import com.suvam.discord_Stand_up_bot.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InsertQuestions {
    private static String yesterdayTask = "What have you done yesterday?";
    private static String todayTask = "What will you do today?";
    private static String doubt = "Do you have any queries that need to be addressed?";
    private static String bye = "Cya tomorrow!";

    private static List<StandUpQuestion> questions = new ArrayList<>();

    private static QuestionService questionService;

    @Autowired
    public InsertQuestions (QuestionService questionService) {
        this.questionService = questionService;
    }

    public static void insert () {
        questions.add(new StandUpQuestion(yesterdayTask));
        questions.add(new StandUpQuestion(todayTask));
        questions.add(new StandUpQuestion(doubt));
        questions.add(new StandUpQuestion(bye));

        questionService.saveAll(questions);
    }
}
