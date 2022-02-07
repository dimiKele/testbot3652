package com.bot365.app;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.SendResponse;

public class bot365App {
    public static void main(String[] args) {
        String token = "5160171978:AAGqmXSWZ7o5L6K9UFXfXCVpt53-TXmSwXc";
        TelegramBot bot = new TelegramBot(token);
        bot.setUpdatesListener(updates -> {
            for (Update update : updates) {
                if (update.message() != null) {
                    long chatId = update.message().chat().id();
                    SendResponse response = bot.execute(new SendMessage(chatId, "Hello!"));
                }
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

    }
}
