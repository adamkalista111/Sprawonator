public class Config {

    String path;
    String ControlSum; 
    String team;
    String sso;
    String password;


public Config(String[] args) {
    try {

        path = args[0];
        ControlSum = args[1];
        team = args[2];
        sso = args [3];
        password = args[4];


    }catch (Exception e)
    {//tu ktoś mądry zrobi komuniakty
        }
    }

}