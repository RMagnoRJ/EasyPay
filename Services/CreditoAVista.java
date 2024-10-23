package Classes.EasyPay.Services;

public class CreditoAVista implements PayMode {
    
    public Double juros(){
        
        Double juro = 0.0;
        
        if (juro == 0.0){
            return null;
        } else {
            return juro;
        }
    }

    public Double taxa(){

        double tax = 0.0325;
        return tax;
    }

}
