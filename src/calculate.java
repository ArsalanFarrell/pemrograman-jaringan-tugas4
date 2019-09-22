
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Arsalan Farrell
 */
public class calculate {

    private calcDisp view;

    Pattern pattern = Pattern.compile("^[a-zA-Z]+$");

    public calculate(calcDisp view) {
        this.view = view;

        this.view.getCalcButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calc();
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(calculate.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        this.view.getResButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.getPanjang().setText("");
                view.getLebar().setText("");
                view.getLuas().setText("");
                view.getKeliling().setText("");
            }
        });
    }

    public void calc() throws FileNotFoundException{
        if (this.view.getPanjang().getText().isEmpty() || this.view.getLebar().getText().isEmpty()) {
            File fileLogErr = new File("C:\\Users\\Arsalan Farrell\\Documents\\tugas4Log\\log.err");
            PrintStream erL = new PrintStream(fileLogErr);
            JOptionPane.showMessageDialog(null, "Inputan tidak boleh kosong.");
            erL.println("Inputan tidak boleh kosong.");
        } else if (this.view.getPanjang().getText().equals(pattern) || this.view.getPanjang().getText().equals(pattern)) {
            File fileLogErr = new File("C:\\Users\\Arsalan Farrell\\Documents\\tugas4Log\\log.err");
            PrintStream erL = new PrintStream(fileLogErr);
            JOptionPane.showMessageDialog(null, "Tolong masukkan angka.");
            erL.println("Tolong masukkan angka.");
        } else {
            File fileLog = new File("C:\\Users\\Arsalan Farrell\\Documents\\tugas4Log\\log.log");
            PrintStream lg = new PrintStream(fileLog);
            String timeStamp = new SimpleDateFormat("ddMMyyy_HHmmss").format(Calendar.getInstance().getTime());
            //membuat variabel inputan panjang dan lebar
            int panjang = Integer.valueOf(view.getPanjang().getText());
            int lebar = Integer.valueOf(view.getLebar().getText());

            //Hitung luas dan keliling
            int luas = panjang * lebar;
            int keliling = (2 * panjang) + (2 * lebar);

            //Tampilkan hasil pada output gui Luas dan Keliling
            view.getLuas().setText(String.valueOf(luas));
            view.getKeliling().setText(String.valueOf(keliling));

            lg.println("panjang : " + panjang);
            lg.println("lebar : " + lebar);
            lg.println("luas : " + luas);
            lg.println("keliling : " + keliling);
            lg.println("========================");
            lg.println("task comlpleted on : " + timeStamp);

        }

    }

}
