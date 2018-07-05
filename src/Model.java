/**
 * Created by Ilgiz on 03.07.2018.
 */
public class Model {
    View view;
    Double firstNumber,secondNumber,resultNumber;
     Boolean clearInput;
    String operation;


    public Model(View view) {
        this.view = view;
        firstNumber = 0.0;
        secondNumber = 0.0;
        resultNumber = 0.0;
        operation="";
        clearInput=false;
    }

    public void addDigit(String number){
        if (clearInput){
            view.clearDigit();
            clearInput = false;
        }
        view.addDigit(number);

    }

    public void delDigit(){
        view.delDigit();
    }

    public void reset(){
        view.clearDigit();
        firstNumber = 0.0;
        secondNumber = 0.0;
        resultNumber = 0.0;
        operation="";
        clearInput=false;

    }

    public void setOperation(String operation){
        //if ((!operation.isEmpty()) && ()){
        if (firstNumber==0){
            firstNumber=Double.valueOf(view.inputText.getText());
            this.operation=operation;
            clearInput = true;
        }else{
            if (!this.operation.isEmpty()){
                secondNumber=Double.valueOf(view.inputText.getText());

                equal();
            }else{
                this.operation=operation;
                secondNumber=Double.valueOf(view.inputText.getText());
                equal();
            }
        }

    }

    public void equal(){
        secondNumber=Double.valueOf(view.inputText.getText());

        switch (operation){
            case "+":
                resultNumber=firstNumber+secondNumber;
                break;
            case "-":
                resultNumber=firstNumber-secondNumber;
                break;
            case "*":
                resultNumber=firstNumber*secondNumber;
                break;
            case "/":
                resultNumber=firstNumber/secondNumber;
                break;

        }
        System.out.println("First = "+firstNumber+" "+operation+" Second="+secondNumber+ "  Result="+resultNumber);
        firstNumber=resultNumber;
        view.equal(String.valueOf(resultNumber));

    }
}
