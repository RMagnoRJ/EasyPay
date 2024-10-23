package Classes.EasyPay.Services;

public class CreditoMaster implements PayMode {
    
    public Double juros(){
        
        Double juro = 0.06775;
        return juro;
    }

    public Double taxa(){

        double tax = 0.0297;
        return tax;
    }

}
