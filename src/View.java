import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilgiz on 03.07.2018.
 */
public class View {

    JFrame frame = new JFrame();
    Controller controller;
    List<JButton> btnDigits = new ArrayList<JButton>();
    List<JButton> btnOperations= new ArrayList<JButton>();
    JTextField inputText;
    public int tempI=0;

    public View() {

        controller = new Controller(this);
        addButton(controller);

    }

    public void addButton(Controller controller){
        JPanel panelButtonDigit = new JPanel();
        JPanel panelInputText = new JPanel();
        JPanel panelOperation = new JPanel();

        FlowLayout flowLayout = new FlowLayout();
        //GridLayout gridLayout = new GridLayout();
        GridLayout gridLayoutButton = new GridLayout(4,3);
        GridLayout gridLayoutButtonOperations = new GridLayout(5,1);
        // gridLayoutButton.
        BorderLayout borderLayout = new BorderLayout();

        for (int i = 1; i <=9 ; i++) {
            btnDigits.add(new JButton(String.valueOf(i)));
        }

        btnDigits.add(new JButton("0"));
        btnDigits.add(new JButton("<<"));
        btnDigits.add(new JButton("="));

        btnOperations.add(new JButton("C"));
        btnOperations.add(new JButton("+"));
        btnOperations.add(new JButton("-"));
        btnOperations.add(new JButton("*"));
        btnOperations.add(new JButton("/"));


        for (int i = 0; i < btnDigits.size(); i++) {
            panelButtonDigit.add(btnDigits.get(i));
            btnDigits.get(i).setActionCommand(btnDigits.get(i).getText());
            btnDigits.get(i).addActionListener(controller);
        }

        for (int i = 0; i < btnOperations.size(); i++) {
            panelOperation.add(btnOperations.get(i));
/*            btnOperations.get(i).setLayout(null);
            btnOperations.get(i).setBounds(0,0,30,30);*/

            btnOperations.get(i).setActionCommand(btnOperations.get(i).getText());
            btnOperations.get(i).addActionListener(controller);
        }

        inputText = new JTextField(20);
        inputText.setText("0");
        inputText.setBounds(0,0,200,30);

        panelInputText.add(inputText);

        panelButtonDigit.setLayout(gridLayoutButton);
        panelOperation.setLayout(gridLayoutButtonOperations);


        frame.add(panelButtonDigit, BorderLayout.CENTER);
        frame.add(panelInputText, BorderLayout.NORTH);
        frame.add(panelOperation, BorderLayout.EAST);

        frame.setResizable(false);
        frame.setBounds(200,200,300,400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void addDigit(String number){
        if ((inputText.getText().equals("0")) || (inputText.getText().equals("0.0"))){
            inputText.setText("");
        }
        inputText.setText(inputText.getText()+number);;
    }

    public void delDigit(){
        inputText.setText(inputText.getText().substring(0, inputText.getText().length() - 1));
    }

    public void equal(String resultNumber){
        inputText.setText(resultNumber);
    }
    public void clearDigit(){
        inputText.setText("");
    }


}
