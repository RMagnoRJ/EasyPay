package Classes.EasyPay.Entities;

import java.time.format.DateTimeFormatter;

public class NotaFiscal {
    
    private Integer numeroDaNota;
    private Descritivo infoDaCompra;
    private Calendario crediario;
    private DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    
    public NotaFiscal() {
    }

    public NotaFiscal(Integer numeroDaNota, Descritivo infoDaCompra, Calendario crediario) {
        this.numeroDaNota = numeroDaNota;
        this.infoDaCompra = infoDaCompra;
        this.crediario = crediario;
    }

    public Integer getNumeroDaNota() {
        return numeroDaNota;
    }

    public Descritivo getInfoDaCompra() {
        return infoDaCompra;
    }

    public Calendario getCrediario() {
        return crediario;
    }

    
    public void imprimeNotaFiscal(){

        System.out.println("\n*********************************");
        System.out.println(  "           NOTA FISCAL           ");
        System.out.println(  "*********************************\n");
        System.out.println("# " + getNumeroDaNota());
        System.out.println("Data: " + getCrediario().getDataDaCompra().format(formatt));
        System.out.println("\n*********************************\n");
        System.out.printf("Valor da Compra: R$ %.2f %n", getInfoDaCompra().getValorDaCompra());
        System.out.println("\n*********************************\n");
        if (getInfoDaCompra().getParcelamento() != null){
            System.out.printf("Parcelas: %d %n", getInfoDaCompra().getParcelamento());
        }
        if (getInfoDaCompra().getJurosAoMes() != null){
            System.out.printf("Juros ao mês: %.2f", (getInfoDaCompra().getJurosAoMes()*100)); System.out.print(" %\n");
        }
        if (getInfoDaCompra().getTaxaDePagamento() != null){
            System.out.printf("Taxa de compra: %.2f", (getInfoDaCompra().getTaxaDePagamento()*100)); System.out.print(" %\n");
        }
        
        if ( getInfoDaCompra().getParcelaSemJuros() != null ){
            System.out.printf("Parcela sem juros: R$ %.2f %n", getInfoDaCompra().getParcelaSemJuros());
        }
        if ( getInfoDaCompra().getValorDaTaxa() != null ){
            System.out.printf("Valor da taxa: R$ %.2f %n", getInfoDaCompra().getValorDaTaxa());
        }
        if ( getInfoDaCompra().getValorDosJurosAoMes() != null ){
            System.out.printf("Valor dos juros: R$ %.2f %n", getInfoDaCompra().getValorDosJurosAoMes());
        }
        if ( getInfoDaCompra().getTotalDeJuros() != null ){
            System.out.printf("Total de juros: R$ %.2f %n", getInfoDaCompra().getTotalDeJuros());
        }
        if ( getInfoDaCompra().getTotalDeTaxa() != null ){
            System.out.printf("Total de taxa: R$ %.2f %n", getInfoDaCompra().getTotalDeTaxa());
        }
        if ( getInfoDaCompra().getValorDoDesconto() != null ){
            System.out.printf("Valor do desconto: R$ %.2f %n", getInfoDaCompra().getValorDoDesconto());
        }
        if ( getInfoDaCompra().getParcelaComJurosETaxa() != null ){
            System.out.printf("Parcela com juros e taxa: R$ %.2f %n", getInfoDaCompra().getParcelaComJurosETaxa());
        }
        System.out.println(  "\n*********************************\n");
        if ( getInfoDaCompra().getModalidade() == 1 ){
            System.out.printf("Total da compra: R$ %.2f %n", getInfoDaCompra().getTotalDaCompraComJurosETaxa());
        } else if ( getInfoDaCompra().getModalidade() == 2){
            System.out.printf("Total da compra: R$ %.2f %n", getInfoDaCompra().getValorTotalComJuros());
        } else if ( getInfoDaCompra().getModalidade() == 3){
            System.out.printf("Total da compra: R$ %.2f %n", getInfoDaCompra().getValorDaCompraComDesconto());
        } else if ( getInfoDaCompra().getModalidade() == 4){
            System.out.printf("Total da compra: R$ %.2f %n", getInfoDaCompra().getValorDaCompraComTaxa());
        } 
        
        System.out.println(  "\n*********************************\n");

    }
}
