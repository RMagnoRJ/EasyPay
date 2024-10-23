package Classes.EasyPay.Services;

public class CreditoVisa implements PayMode {
    
    public Double juros(){
        
        Double juro = 0.05;
        return juro;
    }

    public Double taxa(){

        double tax = 0.03;
        return tax;
    }

}
