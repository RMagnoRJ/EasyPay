package Classes.EasyPay.Services;

public class CreditoPayPal implements PayMode {
    
    public Double juros(){
        
        Double juro = 0.0125;
        return juro;
    }

    public Double taxa(){

        double tax = 0.025;
        return tax;
    }

}
