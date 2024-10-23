package Classes.EasyPay.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Classes.EasyPay.Services.GeneralFunctions;

public class ArquivoGeral {
    
    private List<NotaFiscal> recibo = new ArrayList<>();
    private DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    GeneralFunctions functions = new GeneralFunctions();

    public ArquivoGeral() {
    }

    public ArquivoGeral(List<NotaFiscal> recibo) {
        this.recibo = recibo;
    }

    public List<NotaFiscal> getRecibo() {
        return recibo;
    }

    public void addRecibo(NotaFiscal notaDeCompra){
        recibo.add(notaDeCompra);
    }

    public void deleteRecibo(NotaFiscal notaDeCompra){
        recibo.remove(notaDeCompra);
    }
    

    public void arquivoGeralNotas(){

        int total = recibo.size();

        System.out.println("\nNOTAS ARQUIVADAS: " + total + "\n");

        for (int i = 0; i < recibo.size(); i++){

            System.out.println("REGISTRO # " + (i+1));
            System.out.println(  "\n*********************************\n");
            System.out.println("Nota Fiscal: " + recibo.get(i).getNumeroDaNota());
            System.out.println("Data da compra: " + recibo.get(i).getCrediario().getDataDaCompra().format(formatt));
            System.out.println("Valor da compra: R$ " + recibo.get(i).getInfoDaCompra().getValorDaCompra());
            if (recibo.get(i).getInfoDaCompra().getParcelamento() != null){
                System.out.println("Parcelas: " + recibo.get(i).getInfoDaCompra().getParcelamento());
            }
            System.out.println(  "\n*********************************\n");
            System.out.println(  "\n==========================================");
            functions.waitLine();
            System.out.println(  "==========================================\n");
        }
    }

    public void buscaRegistro(int registro){

        boolean found = false;

        for (int i = 0; i < recibo.size(); i++){
            
            if (recibo.get(i).getNumeroDaNota() == registro){
                found = true;
                recibo.get(i).imprimeNotaFiscal();
                System.out.println(  "\n==========================================");
                functions.waitLine();
                System.out.println(  "==========================================\n");
            }
        }
        if (found == false){
            System.out.println("\nNOTA FISCAL NÃO LOCALIZADA");
        }
    }

    public void buscaData(LocalDate data){

        boolean found = false;

        for (int i = 0; i < recibo.size(); i++){
            
            if (recibo.get(i).getCrediario().getDataDaCompra().equals(data)){
                found = true;
                recibo.get(i).imprimeNotaFiscal();
                System.out.println(  "\n==========================================");
                functions.waitLine();
                System.out.println(  "==========================================\n");
            }
        }

        if (found == false){
            System.out.println("NOTA FISCAL NÃO LOCALIZADA");
        }
    }

}
