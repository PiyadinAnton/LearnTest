/*package ui;


import ui.pages.ClaimPage;
import ui.pages.LoginPage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
public class Api {
    public static void main(String[] args) throws InterruptedException {
        String url = "https://opensource-demo.orangehrmlive.com/web/index.php/claim/assignClaim";
        LoginPage loginPage = new LoginPage();
        ClaimPage claimPage = new ClaimPage();
        loginPage.loginVoid();
        claimPage.claimAssign();
        claimPage.createInEmployerName();
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            int responseCode = con.getResponseCode();
            System.out.println("Отправлен GET-запрос на " + url);
            System.out.println("Код ответа: " + responseCode);
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println("Ответ сервера:");
            System.out.println(response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/