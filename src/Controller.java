import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.*;

/**
 * Created by Ilgiz on 03.07.2018.
*
*/


public class Controller implements ActionListener {
    View view;
    Model model;
    Pattern p = Pattern.compile("[0-9]+");

    public Controller(View view) {
        model = new Model(view);
        this.view=view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (!e.getActionCommand().isEmpty()){
            String command = e.getActionCommand();
            Matcher m = p.matcher(command);
            if (m.find(0)){
                model.addDigit(command);
            }else{
                switch (command){
                    case "<<":
                        model.delDigit();
                        break;
                    case "+":
                        model.setOperation(command);
                        break;
                    case "-":
                        model.setOperation(command);
                        break;
                    case "*":
                        model.setOperation(command);
                        break;
                    case "/":
                        model.setOperation(command);
                        break;
                    case "=":
                        model.equal();
                        break;
                    case "C":
                        model.reset();
                        break;
                }

            }




        }

    }

}
