package ListasLigadas;

public class SmartPhone {
    private String modelo;

    public SmartPhone(String modelo) {
        this.modelo = modelo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "SmartPhone [Modelo=" + modelo + "]";
    }
}
