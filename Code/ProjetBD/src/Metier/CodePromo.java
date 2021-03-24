package Metier;

public class CodePromo {

    private int codePromo; //codePromo
    private int noClient; //noClient

    public CodePromo(int codePromo, int noClient) {
        this.codePromo = codePromo;
        this.noClient = noClient;
    }

    public int getCodePromo(){
        return codePromo;
    }

    public void setCodePromo(int codePromo){
        this.codePromo = codePromo;
    }

    public int getNoClient(){
        return noClient;
    }

    public void setNoClient(int noClient){
        this.noClient = noClient;
    }
}
