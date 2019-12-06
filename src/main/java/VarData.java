import com.google.errorprone.annotations.Var;

/**
 * Класс предназначен для настройки переменных
 */
public class VarData {

    static String login = "логин";
    static String password = "пароль";
    static String url = "https://ql7pokerdom.com/auth/login";
    static String trackAlert = "track/alert_track.wav";

    public static String getTrackAlert() {
        return VarData.class.getClassLoader().getResource(trackAlert).getPath();
    }
}
