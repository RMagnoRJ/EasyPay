package Classes.EasyPay.Application;

import java.time.LocalDate;
import java.util.Scanner;

import Classes.EasyPay.Entities.ArquivoGeral;
import Classes.EasyPay.Entities.Descritivo;
import Classes.EasyPay.Entities.Calendario;
import Classes.EasyPay.Entities.NotaFiscal;
import Classes.EasyPay.Services.CreditoAVista;
import Classes.EasyPay.Services.CreditoMaster;
import Classes.EasyPay.Services.CreditoNu;
import Classes.EasyPay.Services.CreditoPayPal;
import Classes.EasyPay.Services.CreditoVisa;
import Classes.EasyPay.Services.Debito;
import Classes.EasyPay.Services.GeneralFunctions;
import Classes.EasyPay.Services.PayMode;
import Classes.EasyPay.Services.Pix;

public class Program {
    
    public static void main(String[] args) throws InterruptedException {
        // Aula 170 - Exercício INTERFACE
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("\n*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        System.out.println("                     EASY PAY v 1.0                  ");
        System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*\n");
        
        Scanner inn = new Scanner (System.in);
        GeneralFunctions function = new GeneralFunctions();
        ArquivoGeral arquivo = new ArquivoGeral();
        NotaFiscal nota;
        LocalDate hoje;
        Calendario data;
        int menu = 0;
        boolean on = true;

        while (on == true){

            System.out.println("\n      ***********************");
            System.out.println(  "      |  MODO DE PAGAMENTO  |");
            System.out.println(  "      ***********************");

            System.out.print("\n[1] Pix/Dinheiro\n" +
                    "[2] Débito\n" +
                    "[3] Crédito à vista\n" +
                    "[4] Crédito Parcelado - PayPal\n" +
                    "[5] Crédito Parcelado - NuBank\n" +
                    "[6] Crédito Parcelado - Visa\n" +
                    "[7] Crédito Parcelado - Master\n" +
                    "[8] Buscar nota fiscal\n" +
                    "[9] Arquivo Geral de Notas Fiscais\n" +
                    "[10] Encerrar programa\n" +
                    "\n> ");

            menu = inn.nextInt();

            double valorDaCompra = 0.0;
            Integer modalidade = 0;
            Integer dia = 1;
            Integer mes = 1;
            Integer ano = 0;


            if (menu < 8){

                System.out.print("\nValor da compra: ");
                valorDaCompra = inn.nextDouble(); inn.nextLine();

                System.out.println("\nData da compra: \n");
                System.out.print("Dia: ");
                dia = inn.nextInt(); inn.nextLine();
                System.out.print("Mes: ");
                mes = inn.nextInt(); inn.nextLine();
                ano = 2024;
                System.out.println();
            }

            hoje = LocalDate.of(ano, mes, dia);

            switch (menu) {

                case 1:
                    // PIX/Dinheiro
                    PayMode noPix = new Pix();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 3;
                    Descritivo pagNoPix = new Descritivo(modalidade, valorDaCompra, noPix);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoPix, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 2:
                    // Débito
                    PayMode noDebito = new Debito();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 4;
                    Descritivo pagNoDebito = new Descritivo(modalidade, valorDaCompra, noDebito);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoDebito, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 3:
                    // Crédito a vista
                    PayMode creditoAVista = new CreditoAVista();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 4;
                    Descritivo pagNoCreditoAVista = new Descritivo(modalidade, valorDaCompra, creditoAVista);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoCreditoAVista, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 4:
                    // PayPal
                    System.out.print("Quantidade de parcelas: ");
                    int parcelasPayPal = inn.nextInt(); inn.nextLine();
                    
                    PayMode payPal = new CreditoPayPal();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 1;
                    Descritivo pagNoPayPal = new Descritivo(modalidade, valorDaCompra, parcelasPayPal, payPal);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoPayPal, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    data.geraCrediario(parcelasPayPal);
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 5:
                    // Nubank
                    System.out.print("Quantidade de parcelas: ");
                    int parcelaNu = inn.nextInt(); inn.nextLine();
                    
                    PayMode nuPay = new CreditoNu();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 2;
                    Descritivo pagNoNuBank = new Descritivo(modalidade, valorDaCompra, parcelaNu, nuPay);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoNuBank, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    data.geraCrediario(parcelaNu);
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 6:
                    // Parcelado Visa
                    System.out.print("Quantidade de parcelas: ");
                    int parcelaVisa = inn.nextInt(); inn.nextLine();

                    PayMode visa = new CreditoVisa();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 1;
                    Descritivo pagNoVisa = new Descritivo(modalidade, valorDaCompra, parcelaVisa, visa);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoVisa, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    data.geraCrediario(parcelaVisa);
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 7:
                    // Parcelado Master
                    System.out.print("Quantidade de parcelas: ");
                    int parcelaMaster = inn.nextInt(); inn.nextLine();

                    PayMode master = new CreditoMaster();
                    //hoje = LocalDate.now();
                    data = new Calendario(hoje);
                    modalidade = 1;
                    Descritivo pagNoMaster = new Descritivo(modalidade, valorDaCompra, parcelaMaster, master);
                    nota = new NotaFiscal(function.addRegistro(7), pagNoMaster, data);
                    arquivo.addRecibo(nota);
                    System.out.println();
                    function.pause("Registrando", '.',3,500);
                    System.out.println();
                    nota.imprimeNotaFiscal();
                    data.geraCrediario(parcelaMaster);
                    System.out.println(  "\n==========================================");
                    function.waitLine();
                    System.out.println(  "==========================================\n");
                    break;

                case 8:
                    // Buscar nota fiscal por REGISTRO ou DATA
                    System.out.print("\nSelecione uma opção:\n"+
                    "\n[1] Buscar por número de Nota Fiscal\n" +
                    "[2] Buscar por data de compra\n"+
                    "\n> ");
                    int busca = inn.nextInt(); inn.nextLine();
                    if (busca == 1){
                        System.out.print("\nDigite o número da Nota Fiscal: ");
                        int notaFiscal = inn.nextInt(); inn.nextLine();
                        arquivo.buscaRegistro(notaFiscal);
                    } else {
                        System.out.print("\nDigite a data da compra:\n\nDia: ");
                        int diaBusca = inn.nextInt(); inn.nextLine();
                        System.out.print("Mês: ");
                        int mesBusca = inn.nextInt(); inn.nextLine();
                        System.out.print("ano: ");
                        int anoBusca = inn.nextInt(); inn.nextLine();
                        LocalDate buscaData = LocalDate.of(anoBusca, mesBusca, diaBusca);
                        System.out.println();
                        arquivo.buscaData(buscaData);
                    }
                    break;

                case 9:
                    // Arquivo Geral de Notas Fiscais
                    arquivo.arquivoGeralNotas();
                    break;

                case 10:
                    // sair
                    on = false;
                    break;
            }
        }

        System.out.println(  "\n*********************************");
        System.out.println(  "           VOLTE SEMPRE          ");
        System.out.println(  "*********************************\n");
        inn.close();
    }
}
