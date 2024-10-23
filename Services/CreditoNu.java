package Classes.EasyPay.Services;

public class CreditoNu implements PayMode {
    
    public Double juros(){
        
        Double juro = 0.00975;
        return juro;
    }

    public Double taxa(){

        double tax = 0.0;

        if (tax == 0.0){
            return null;
        } else {
            return tax;
        }
        
    }

}
