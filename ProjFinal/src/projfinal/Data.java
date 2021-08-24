package projfinal;

public class Data {

    private byte dia;
    private byte mes;
    private int ano;

    public byte getDia() {
        return dia;
    }

    public void setDia(byte dia) {
        this.dia = dia;
    }

    public byte getMes() {
        return mes;
    }

    public void setMes(byte mes) {
        this.mes = mes;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public boolean validarData() {
        return this.dia > 0 && this.dia < 32 && this.mes > 0 && this.mes < 13 && this.ano > 0 && ((this.mes == 1 || this.mes == 3 || this.mes == 5 || this.mes == 7 || this.mes == 8 || this.mes == 10 || this.mes == 12) || ((this.mes == 4 || this.mes == 6 || this.mes == 9 || this.mes == 11) && this.dia <= 30) || (this.mes == 2 && (this.dia <= 29 && this.ano % 4 == 0 && (this.ano % 100 != 0 || this.ano % 400 == 0)) || this.dia <= 28));
    }

    @Override
    public String toString() {
        return dia + "/" + mes + "/" + ano;
    }

}
