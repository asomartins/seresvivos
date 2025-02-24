public class SerVivo {
    private String nome;
    private String especie;
    private String pais;
    private int idade;

    public SerVivo(String especie, int idade, String nome, String pais) {
        this.especie = especie;
        this.idade = idade;
        this.nome = nome;
        this.pais = pais;
    }

    public String getEspecie() {
        return especie;
    }

    public void criarSerVivo() {}
    public void imprimirDescricaoSerVivo() {}
    public void simulador() {}
}