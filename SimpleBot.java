
package test;
 
import java.util.ArrayList;
import org.telegram.telegrambots.exceptions.TelegramApiException;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.api.methods.send.SendMessage;
import org.telegram.telegrambots.api.objects.Message;
import org.telegram.telegrambots.api.objects.Update;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
 
public class SimpleBot extends TelegramLongPollingBot {
 
	public static void main(String[] args) {
		ApiContextInitializer.init();
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
		try {
			telegramBotsApi.registerBot(new SimpleBot());
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
 
	
	public String getBotUsername() {
		return "Cyrillic_Latin_bot";
	}
 
	
	public String getBotToken() {
		return "461097594:AAFLJ0shKrgVSIQx6nI3-70oLz0M4E8wQH4";
	}
 
	
	public void onUpdateReceived(Update update) {
		Message message = update.getMessage();
		if (message != null && message.hasText()) {
                        int check =0;
			if (message.getText().equals("/help")){
                            sendMsg(message, "Введите текст на кириллице, для перевода на латинский алфавит");
                            check++;
                        }
                        if (message.getText().equals("/about")){
                            sendMsg(message, "Бот переводит текст на кириллице в текст на латинице");
                            check++;
                        }
                        String msg = message.getText();
                        if (message.getText().equals(msg) && check==0){
                            //sendMsg(message, "я не бесполезен, я просто не хочу работать!!!");
                            
                            
                            String FMsg = rep(msg);   
                            sendMsg(message, FMsg); 
                            
                        }
			
		}
                
	}
 
	private void sendMsg(Message message, String text) {
		SendMessage sendMessage = new SendMessage();
		sendMessage.enableMarkdown(true);
		sendMessage.setChatId(message.getChatId().toString());
		sendMessage.setReplyToMessageId(message.getMessageId());
		sendMessage.setText(text);
		try {
			sendMessage(sendMessage);
		} catch (TelegramApiException e) {
			e.printStackTrace();
		}
	}
        
        
        
        
        
        private String rep(String msg){
            
            String message = msg;
            String mes = "";
            ArrayList<Integer> ArrMsg = new ArrayList<Integer>();
            int size = message.length();
            for(int i = 0; i < message.length(); i++){
                if(message.charAt(i) == 'ә' || message.charAt(i) == 'ғ' ||
                   message.charAt(i) == 'и' || message.charAt(i) == 'й' || 
                   message.charAt(i) == 'ң' || message.charAt(i) == 'ө' ||
                   message.charAt(i) == 'ш' || message.charAt(i) == 'ч' ||
                   message.charAt(i) == 'ү' || message.charAt(i) == 'у'){
                   size++;
                }
            }
            
            
            
            
            String[][] alphabet = new String[4][35];
                            alphabet[0][0] = " "; alphabet[1][0] = " ";
                            alphabet[0][1] = "Ә"; alphabet[1][1] = "A";
                            alphabet[0][2] = "Б"; alphabet[1][2] = "B";
                            alphabet[0][3] = "Д"; alphabet[1][3] = "D";
                            alphabet[0][4] = "Е"; alphabet[1][4] = "E";
                            alphabet[0][5] = "Ф"; alphabet[1][5] = "F";
                            alphabet[0][6] = "Г"; alphabet[1][6] = "G";
                            alphabet[0][7] = "Ғ"; alphabet[1][7] = "G";
                            alphabet[0][8] = "Х"; alphabet[1][8] = "H";
                            alphabet[0][9] = "Һ"; alphabet[1][9] = "h";
                            alphabet[0][10] = "І"; alphabet[1][10] = "I";
                            alphabet[0][11] = "И"; alphabet[1][11] = "I";
                            alphabet[0][12] = "Й"; alphabet[1][12] = "I";
                            alphabet[0][13] = "Ж"; alphabet[1][13] = "J";
                            alphabet[0][14] = "К"; alphabet[1][14] = "K";
                            alphabet[0][15] = "Л"; alphabet[1][15] = "L";
                            alphabet[0][16] = "М"; alphabet[1][16] = "M";
                            alphabet[0][17] = "Н"; alphabet[1][17] = "N";
                            alphabet[0][18] = "Ң"; alphabet[1][18] = "N";
                            alphabet[0][19] = "О"; alphabet[1][19] = "O";
                            alphabet[0][20] = "Ө"; alphabet[1][20] = "O";
                            alphabet[0][21] = "П"; alphabet[1][21] = "P";
                            alphabet[0][22] = "Қ"; alphabet[1][22] = "Q";
                            alphabet[0][23] = "Р"; alphabet[1][23] = "R";
                            alphabet[0][24] = "С"; alphabet[1][24] = "S";
                            alphabet[0][25] = "Ш"; alphabet[1][25] = "S";
                            alphabet[0][26] = "Ч"; alphabet[1][26] = "C";
                            alphabet[0][27] = "Т"; alphabet[1][27] = "T";
                            alphabet[0][28] = "Ұ"; alphabet[1][28] = "U";
                            alphabet[0][29] = "Ү"; alphabet[1][29] = "U";
                            alphabet[0][30] = "В"; alphabet[1][30] = "V";
                            alphabet[0][31] = "Ы"; alphabet[1][31] = "Y";
                            alphabet[0][32] = "У"; alphabet[1][32] = "Y";
                            alphabet[0][33] = "З"; alphabet[1][33] = "Z";
                            alphabet[0][34] = "А"; alphabet[1][34] = "A";
                            
                            alphabet[2][0] = "*"; alphabet[3][0] = "*";
                            alphabet[2][1] = "ә"; alphabet[3][1] = "a";
                            alphabet[2][2] = "б"; alphabet[3][2] = "b";
                            alphabet[2][3] = "д"; alphabet[3][3] = "d";
                            alphabet[2][4] = "е"; alphabet[3][4] = "e";
                            alphabet[2][5] = "ф"; alphabet[3][5] = "f";
                            alphabet[2][6] = "г"; alphabet[3][6] = "g";
                            alphabet[2][7] = "ғ"; alphabet[3][7] = "g";
                            alphabet[2][8] = "х"; alphabet[3][8] = "h";
                            alphabet[2][9] = "і"; alphabet[3][9] = "i";
                            alphabet[2][10] = "и"; alphabet[3][10] = "i";
                            alphabet[2][11] = "й"; alphabet[3][11] = "i";
                            alphabet[2][12] = "ж"; alphabet[3][12] = "j";
                            alphabet[2][13] = "к"; alphabet[3][13] = "k";
                            alphabet[2][14] = "л"; alphabet[3][14] = "l";
                            alphabet[2][15] = "м"; alphabet[3][15] = "m";
                            alphabet[2][16] = "н"; alphabet[3][16] = "n";
                            alphabet[2][17] = "ң"; alphabet[3][17] = "n";
                            alphabet[2][18] = "о"; alphabet[3][18] = "o";
                            alphabet[2][19] = "ө"; alphabet[3][19] = "o";
                            alphabet[2][20] = "п"; alphabet[3][20] = "p";
                            alphabet[2][21] = "қ"; alphabet[3][21] = "q";
                            alphabet[2][22] = "р"; alphabet[3][22] = "r";
                            alphabet[2][23] = "с"; alphabet[3][23] = "s";
                            alphabet[2][24] = "ш"; alphabet[3][24] = "s";
                            alphabet[2][25] = "ч"; alphabet[3][25] = "c";
                            alphabet[2][26] = "т"; alphabet[3][26] = "t";
                            alphabet[2][27] = "ұ"; alphabet[3][27] = "u";
                            alphabet[2][28] = "ү"; alphabet[3][28] = "u";
                            alphabet[2][29] = "в"; alphabet[3][29] = "v";
                            alphabet[2][30] = "ы"; alphabet[3][30] = "y";
                            alphabet[2][31] = "у"; alphabet[3][31] = "y";
                            alphabet[2][32] = "з"; alphabet[3][32] = "z";
                            alphabet[2][33] = "а"; alphabet[3][33] = "a";
                            alphabet[2][34] = "*"; alphabet[3][34] = "*";
            
            
            int check = 0;
            for(int i = 0; i < message.length(); i++){
                for(int j = 0; j <= 34; j++){
                    for(int l = 0; l <= 2; l=l+2){
                        if(message.charAt(i) == alphabet[l][j].charAt(0)){
                            mes = mes + alphabet[l+1][j].charAt(0);
                             if(message.charAt(i) == 'Ә' || message.charAt(i) == 'Ғ' ||
                                message.charAt(i) == 'И' || message.charAt(i) == 'Й' || 
                                message.charAt(i) == 'Ң' || message.charAt(i) == 'Ө' ||
                                message.charAt(i) == 'Ш' || message.charAt(i) == 'Ч' ||
                                message.charAt(i) == 'Ү' || message.charAt(i) == 'У' ||
                                     
                                message.charAt(i) == 'ә' || message.charAt(i) == 'ғ' ||
                                message.charAt(i) == 'и' || message.charAt(i) == 'й' || 
                                message.charAt(i) == 'ң' || message.charAt(i) == 'ө' ||
                                message.charAt(i) == 'ш' || message.charAt(i) == 'ч' ||
                                message.charAt(i) == 'ү' || message.charAt(i) == 'у'){                                
                                mes = mes + 'ʼ';   
                             }  
                             check++;
                             
                             /*if(message.charAt(i) == ' '){                                
                                mes = mes.;   
                             } */
                        }
                        if(message.charAt(i) != alphabet[l][j].charAt(0) && j==34 && l==2 && check == 0){
                            mes = mes + message.charAt(i);                              
                        }
                    }
                }
                check=0;
            }
            return mes;
            
            
            
        }
 
}