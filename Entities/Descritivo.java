package Classes.EasyPay.Entities;

import Classes.EasyPay.Services.PayMode;

public class Descritivo {
    
    private Double valorDaCompra;
    private Integer parcelamento;
    private Double jurosAoMes;
    private Double taxaDePagamento;
    private Integer modalidade;
    private Double parcelaSemJuros;
    private Double parcelaComJuros;
    private Double parcelaComJurosETaxa;
    private Double valorDaTaxa;
    private Double valorDosJurosAoMes;
    private Double valorTotalComJuros;
    private Double totalDeJuros;
    private Double totalDeTaxa;
    private Double totalDaCompraComJurosETaxa;
    private Double valorDoDesconto;
    private Double valorDaCompraComDesconto;
    private Double valorDaCompraComTaxa;
    



    public Descritivo() {
    }

    public Descritivo(Integer modalidade, Double valorDaCompra, PayMode pay) {
        this.valorDaCompra = valorDaCompra;
        this.jurosAoMes = pay.juros();
        this.taxaDePagamento = pay.taxa();
        this.modalidade = modalidade;
        geraPagamento(modalidade);
    }

    public Descritivo(Integer modalidade, Double valorDaCompra, Integer parcelamento, PayMode pay) {
        this.valorDaCompra = valorDaCompra;
        this.parcelamento = parcelamento;
        this.jurosAoMes = pay.juros();
        this.taxaDePagamento = pay.taxa();
        this.modalidade = modalidade;
        geraPagamento(modalidade);
    }



    public Double getValorDaCompra() {
        return valorDaCompra;
    }

    public Integer getParcelamento() {
        return parcelamento;
    }

    public Double getJurosAoMes() {
        return jurosAoMes;
    }

    public Double getTaxaDePagamento() {
        return taxaDePagamento;
    }

    public Integer getModalidade() {
        return modalidade;
    }

    public Double getParcelaSemJuros() {
        return parcelaSemJuros;
    }

    public Double getParcelaComJuros() {
        return parcelaComJuros;
    }

    public Double getParcelaComJurosETaxa() {
        return parcelaComJurosETaxa;
    }

    public Double getValorDaTaxa() {
        return valorDaTaxa;
    }

    public Double getValorDosJurosAoMes() {
        return valorDosJurosAoMes;
    }

    public Double getValorTotalComJuros() {
        return valorTotalComJuros;
    }

    public Double getTotalDeJuros() {
        return totalDeJuros;
    }

    public Double getTotalDeTaxa() {
        return totalDeTaxa;
    }

    public Double getTotalDaCompraComJurosETaxa() {
        return totalDaCompraComJurosETaxa;
    }

    public Double getValorDoDesconto() {
        return valorDoDesconto;
    }

    public Double getValorDaCompraComDesconto() {
        return valorDaCompraComDesconto;
    }

    public Double getValorDaCompraComTaxa() {
        return valorDaCompraComTaxa;
    }

   
    public void geraPagamento (Integer mode){

        double jurAoMes = 0.0;
        double jurFinal = 0.0;

        switch (mode) {

            case 1:
                // PARCELAMENTO COM TAXA
                this.parcelaSemJuros = getValorDaCompra() / getParcelamento();
                jurAoMes = 1 + getJurosAoMes();
                jurFinal = Math.pow(jurAoMes, getParcelamento());
                this.valorTotalComJuros = getValorDaCompra() * jurFinal;
                this.totalDeJuros = getValorTotalComJuros() - getValorDaCompra();
                this.valorDosJurosAoMes = getTotalDeJuros() / getParcelamento();
                this.parcelaComJuros = getValorTotalComJuros() / getParcelamento();
                this.parcelaComJurosETaxa = getParcelaComJuros() + (getParcelaComJuros() * getTaxaDePagamento());
                this.totalDaCompraComJurosETaxa = getParcelaComJurosETaxa() * getParcelamento();
                this.valorDaTaxa = getValorDaCompra() * getTaxaDePagamento();
                this.totalDeTaxa = getValorDaTaxa() * getParcelamento();
                this.valorDaCompraComTaxa = null;
                this.valorDoDesconto = null;
                this.valorDaCompraComDesconto = null;

                break;
        
            case 2:
                // PARCELAMENTO SEM TAXA
                this.parcelaSemJuros = getValorDaCompra() / getParcelamento();
                jurAoMes = 1 + getJurosAoMes();
                jurFinal = Math.pow(jurAoMes, getParcelamento());
                this.parcelaComJuros = getParcelaSemJuros() * jurFinal;
                this.parcelaComJurosETaxa = null;
                this.totalDaCompraComJurosETaxa = null;
                this.valorTotalComJuros = getParcelaComJuros() * getParcelamento();
                this.totalDeJuros = getValorTotalComJuros() - getValorDaCompra();
                this.valorDosJurosAoMes = getTotalDeJuros() / getParcelamento();
                this.valorDaTaxa = null;
                this.totalDeTaxa = null;
                this.valorDaCompraComTaxa = null;
                this.valorDoDesconto = null;
                this.valorDaCompraComDesconto = null;
                break;

            case 3:
                // PAGAMENTO NO PIX ou DINHEIRO
                this.parcelamento = null;
                this.parcelaSemJuros = null;
                this.parcelaComJuros = null;
                this.parcelaComJurosETaxa = null;
                this.totalDaCompraComJurosETaxa = null;
                this.valorTotalComJuros = null;
                this.totalDeJuros = null;
                this.valorDosJurosAoMes = null;
                this.valorDaTaxa = null;
                this.totalDeTaxa = null;
                this.valorDaCompraComTaxa = null;
                this.valorDoDesconto = getValorDaCompra() * getTaxaDePagamento();
                this.valorDaCompraComDesconto = getValorDaCompra() - getValorDoDesconto();
                break;

            case 4:
                // PAGAMENTO DÉBITO ou CRÉDITO ROTATIVO
                this.parcelamento = null;
                this.parcelaSemJuros = null;
                this.parcelaComJuros = null;
                this.parcelaComJurosETaxa = null;
                this.totalDaCompraComJurosETaxa = null;
                this.valorTotalComJuros = null;
                this.totalDeJuros = null;
                this.valorDosJurosAoMes = null;
                this.valorDaTaxa = getValorDaCompra() * getTaxaDePagamento();
                this.totalDeTaxa = null;
                this.valorDaCompraComTaxa = getValorDaCompra() + getValorDaTaxa();
                this.valorDoDesconto = null;
                this.valorDaCompraComDesconto = null;
                break;
            
        }

    }
   
    

}
