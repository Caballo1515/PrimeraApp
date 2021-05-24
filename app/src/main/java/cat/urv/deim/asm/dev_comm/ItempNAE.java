package cat.urv.deim.asm.dev_comm;

public class ItempNAE {
    private int foto;
    private String titulo, texto, fecha;

    public ItempNAE(int foto, String titulo, String texto, String fecha) {
        this.foto = foto;
        this.titulo = titulo;
        this.texto = texto;
        this.fecha = fecha;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
