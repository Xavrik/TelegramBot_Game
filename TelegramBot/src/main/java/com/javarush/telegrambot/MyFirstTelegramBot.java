package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "xavrcheck_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = "6544272036:AAGQXhfb0bax4SUy2gpxvgESiZNZGct7V4E"; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update update) {
       //TODO 1 - отобразить сообщение начала игры
        if(getMessageText().equals("/start")){
            setUserGlory(0);
            sendPhotoMessageAsync("step_1_pic");
            sendTextMessageAsync(STEP_1_TEXT, Map.of(
                    "Взлом холодильника","step_1_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_1_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_2_pic");
            sendTextMessageAsync(STEP_2_TEXT, Map.of(
                    "Взть сосиську! +20 славы", "step_2_btn",
                    "Взять рыбку! +20 свавы","step_2_btn",
                    "Скинуть банку с огурцами! +20 славы","step_2_btn"
            ));
        }
        //TODO 2 - взламываем робот- пылесос
        if(getCallbackQueryButtonKey().equals("step_2_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_3_pic");
            sendTextMessageAsync(STEP_3_TEXT, Map.of(
                    "Взлом робот-пылесоса","step_3_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_3_btn")){
            setUserGlory(20);
            sendPhotoMessageAsync("step_4_pic");
            sendTextMessageAsync(STEP_4_TEXT, Map.of(
                    "Отправить робот пылесос за едой! +30 славы", "step_4_btn",
                    "Покататься на робот-пылесосе! +30 свавы","step_4_btn",
                    "Бежать от робот-пылесоса +30 славы","step_4_btn"
            ));
        }
        //TODO 3 - взломать камеру Go-Pro
        if(getCallbackQueryButtonKey().equals("step_4_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_5_pic");
            sendTextMessageAsync(STEP_5_TEXT, Map.of(
                    "Укратить Go-Pro","step_5_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_5_btn")){
            setUserGlory(30);
            sendPhotoMessageAsync("step_6_pic");
            sendTextMessageAsync(STEP_6_TEXT, Map.of(
                    "Заснять приключение! +40 славы", "step_6_btn",
                    "Прсомотреть записи! +40 свавы","step_6_btn",
                    "поставить на зарядку +40 славы","step_6_btn"
            ));
        }

        //TODO 4 - взломать компьютер
        if(getCallbackQueryButtonKey().equals("step_6_btn")){
            setUserGlory(40);
            sendPhotoMessageAsync("step_7_pic");
            sendTextMessageAsync(STEP_7_TEXT, Map.of(
                    "Взломай компьютер этого коженного","step_7_btn"
            ));
        }
        if(getCallbackQueryButtonKey().equals("step_7_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("step_8_pic");
            sendTextMessageAsync(STEP_8_TEXT, Map.of(
                    "Зависнуть в инете! +40 славы", "step_8_btn",
                    "Псомтреть сериальчик! +40 свавы","step_8_btn",
                    "Поменять пароль компьютера +40 славы","step_8_btn"
            ));
        }

        //TODO 5 - хвастаться дворовым котам
        if(getCallbackQueryButtonKey().equals("step_8_btn")){
            setUserGlory(50);
            sendPhotoMessageAsync("final_pic");
            sendTextMessageAsync(FINAL_TEXT, Map.of(
                    "Респект от котов","step_9_btn"
            ));
            addUserGlory(100);
        }
     

    }



    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}


