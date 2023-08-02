package Modelo;

public class Usuario extends Pessoa{
    private int registroAcademico;

    public Usuario(int registroAcademico, int id, String nome, String sobreNome) {
        super(id, nome, sobreNome);
        this.registroAcademico = registroAcademico;
    }

    public int getRegistroAcademico() {
        return registroAcademico;
    }

    public void setRegistroAcademico(int registroAcademico) {
        this.registroAcademico = registroAcademico;
    }   
    
}
