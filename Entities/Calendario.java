package Classes.EasyPay.Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Calendario {
    
    private LocalDate dataDaCompra;
    private DateTimeFormatter formatt = DateTimeFormatter.ofPattern("dd/MM/yyyy");



    public Calendario() {
    }

    public Calendario(LocalDate dataDaCompra) {
        this.dataDaCompra = dataDaCompra;
    }




    public LocalDate getDataDaCompra() {
        return dataDaCompra;
    }



    public void geraCrediario(int parcelas){

        for (int i = 1; i <= parcelas; i++){
            System.out.println("Parcela [" + i + "] : " + getDataDaCompra().plusMonths(i).format(formatt));    
        }

    }


    

    
}
